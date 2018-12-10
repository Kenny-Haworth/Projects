import retro
import numpy as np
import random
import os

import skimage as skimage
from skimage import transform
from skimage.viewer import ImageViewer

from keras.models import Sequential
from keras.layers.convolutional import Conv2D
from keras.layers import Dense
from keras.layers import MaxPooling2D
from keras.optimizers import Adam
from keras.layers import Flatten

from collections import deque

numberOfEpisodes = 1000
path = "world1-1Weights.h5"
memory = deque(maxlen=2000)
gamma = 0.95 #discount rate
epsilon = 1.0 #exploration rate
epsilon_min = .05 #5% of all actions are random at minimum
epsilon_decay = 0.9995 #very slow epsilon decay
learningRate = 1e-5

state = None #global variables
first = False

#Returns a Neural Network for Deep-Q learning Model
def buildModel():

	print("Building model...")
	
	model = Sequential() #create a sequential model to stack layers from input to output
	
	#convo2D(number of output channels, kernel size, strides, activation function, input shape)
	model.add(Conv2D(32, kernel_size=(5, 5), strides=(1, 1), activation='relu', input_shape=(65, 70, 4)))
	
	#pooling layer, defines size of pooling and size of strides
	model.add(MaxPooling2D(pool_size=(2, 2), strides=(2, 2)))
	
	#add another convolutional and maxpooling layer, strides defaulted to (1,1) & equal to pool size
	model.add(Conv2D(64, (5, 5), activation='relu'))
	model.add(MaxPooling2D(pool_size=(2, 2)))
	
	model.add(Conv2D(64, (3,3), activation='relu'))
	
	#flatten the output, specify maximum of 2048 hidden nodes
	model.add(Flatten())
	model.add(Dense(2048, activation='hard_sigmoid'))
	
	model.add(Dense(4)) #the final dense layer specifies the size of the output
	adam = Adam(lr=learningRate)
	model.compile(loss='mse', optimizer=adam)
	
	print("Model compiled successfully!")
	return model
	
def train(model, image):
	
	#choose a random action
	if (np.random.rand() <= epsilon):
		num = random.randint(0,3)
		return (lookup_table(num), [0,0,0,0]) 

	q = model.predict(image) #q is an np array [[a, b, c, d]]
	
	return (lookup_table(np.argmax(q[0])), q[0])
	
def remember(observation, action, reward, nextState, done):
	memory.append((observation, action, reward, nextState, done))
	
def replay(model, batchSize):
	
	global epsilon #the local epsilon is the same as the global and can be changed from this method
	minibatch = random.sample(memory, batchSize)
	
	for state, action, reward, nextState, done in minibatch:
		target = reward
		
		if not done:
			target = (reward + gamma * np.amax(model.predict(nextState)[0]))
			
		targetF = model.predict(state)
		targetF[0][np.argmax(action)] = target
		model.fit(state, targetF, epochs=1, verbose=0)
		
	if epsilon > epsilon_min:
		epsilon *= epsilon_decay
		
	return model
	
#returns the action to take
def lookup_table(action):

	#right arrow only
	if (action == 0):
		return [0,0,0,0,0,0,0,1,0]
		
	#right arrow and jump key
	elif (action == 1):
		return [0,0,0,0,0,0,0,1,1]
	
	#right arrow and sprint button
	elif (action == 2):
		return [1,0,0,0,0,0,0,1,0]
		
	#right arrow, jump key, and sprint button
	elif (action == 3):
		return [0,0,0,0,0,0,0,1,1]
		
	else:
		print("Fatal logic error!")
	
def loadModel(model):
	model.load_weights(path)
	print("Successfully loaded network")
	
def saveModel(model):
	model.save(path)
	print("Model saved successfully")

#performs image pre-processing, returns an np array
def processImage(frame1, frame2, frame3, frame4) -> np.array:
	
	state = np.stack((processFrame(frame1), processFrame(frame2), processFrame(frame3), processFrame(frame4)), axis=2)
	state = state.reshape(1, state.shape[0], state.shape[1], state.shape[2])
	
	return state
	
def processFrame(frame):

	grayScaleState = skimage.color.rgb2gray(observation)
	resizedState = skimage.transform.resize(grayScaleState, (65, 70))
	
	return resizedState

if __name__ == "__main__":
	env = retro.make(game='SuperMarioBros-Nes', state='Level1-1', record = './World1')
	
	model = buildModel() #create a convolutional neural network
	loadModel(model) #load the saved weights for the model
	batchSize = 200
	maximumTotalReward = 0
	newBest = False
	
	for episode in range(numberOfEpisodes):
	
		observation = env.reset() #reset the environment
		
		if (newBest == False) and (episode != 0): #delete the replay, it wasn't good enough to save
	
			string = str(episode-1)
			
			while len(string) != 6:
				string = "0" + string
			
			os.remove("./World1/SuperMarioBros-Nes-Level1-1-" + string + ".bk2")
		
		newBest = False
		
		steps = 0
		frame_count = 0
		lives = 2 #the initial number of lives
		
		t = 0 #time step for frame inputs
		frame1 = observation
		frame2 = observation
		frame3 = observation
		frame4 = observation
		
		previousReward = 0
		totalReward = 0
		rewardOverFourFrames = 0
		
		#process the first image to load the image buffer
		image = processImage(frame1, frame2, frame3, frame4)
		previousImage = image
		
		while True:
		
			#env.render() #disable to increase speed by ~1.1x
			
			if (t == 0): #only choose a new action every 4 frames
				action, networkAction = train(model, image) #get an action
				
			nextObservation, reward, done, info = env.step(action) #take an action
			
			if (t == 0):
				frame1 = nextObservation
			elif (t == 1):
				frame2 = nextObservation
			elif (t == 2):
				frame3 = nextObservation
			elif (t == 3):
				frame4 = nextObservation
				
			totalReward += reward
			frame_count += 1
			steps += 1
			rewardOverFourFrames += reward
			
			if (info['lives'] > lives): #the player gained a 1UP, update the number of lives
				lives = info['lives']
			
			if (t == 3):
				image = processImage(frame1, frame2, frame3, frame4)
				remember(image, networkAction, rewardOverFourFrames, previousImage, done) #add to the memory buffer
				rewardOverFourFrames = 0
				previousImage = image
			
			previousReward = reward
			
			t += 1
			
			if (t == 4):
				t = 0
			
			if done or (lives > info['lives']): #completing the level or losing a life ends the episode
				print("\nEpisode #{} ended in {} steps. Epsilon = {}. Total reward = {}".format(episode+1, steps, epsilon, totalReward))
				
				#save the replay if it was better than anything seen previously
				if (totalReward > maximumTotalReward):
				
					print("NEW BEST REPLAY!!!")
					maximumTotalReward = totalReward
					newBest = True
				
				break
				
			#call replay memory
			if len(memory) > batchSize and (frame_count % 500) == 0: #500 frames is 15 in-game seconds or 6 real seconds
				model = replay(model, batchSize)
				
		#if (episode % 10 == 0): #save the model every 10 episodes
			#saveModel(model)
		
env.close()
exit(0)