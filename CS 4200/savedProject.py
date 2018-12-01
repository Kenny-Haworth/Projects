import retro
import numpy as np
import random

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

numberOfEpisodes = 10000000 #we will train forever
path = "test.h5"
memory = deque(maxlen=2000)
gamma = 0.95 #discount rate
epsilon = 1.0 #exploration rate
epsilon_min = 0.05 #5% of all actions are random at minimum
epsilon_decay = 0.999 #very slow epsilon decay
learningRate = 1e-4

state = None
first = False

#Returns a Neural Network for Deep-Q learning Model
def buildModel(actionSize):

	print("Building model...")
	
	model = Sequential() #create a sequential model to stack layers from input to output
	
	#convo2D(number of output channels, kernel size, strides, activation function, input shape)
	model.add(Conv2D(32, kernel_size=(5, 5), strides=(1, 1), activation='relu', input_shape=(56, 60, 4)))
	
	#pooling layer, defines size of pooling and size of strides
	model.add(MaxPooling2D(pool_size=(2, 2), strides=(2, 2)))
	
	#add another convolutional and maxpooling layer, strides defaulted to (1,1) & equal to pool size
	model.add(Conv2D(64, (5, 5), activation='relu'))
	model.add(MaxPooling2D(pool_size=(2, 2)))
	
	model.add(Conv2D(64, (3,3), activation='relu'))
	
	#flatten the output, specify maximum of 1024 hidden nodes
	model.add(Flatten())
	model.add(Dense(1024, activation='hard_sigmoid')) #change to 4096 hidden nodes?
	
	model.add(Dense(actionSize)) #the final dense layer specifies the size of the output
	adam = Adam(lr=learningRate)
	model.compile(loss='mse', optimizer=adam)
	
	print("Model compiled successfully!")
	return model
	
def train(model, image, actionSize):
	
	#choose a random action
	if (np.random.rand() <= epsilon):
		return env.action_space.sample()

	q = model.predict(image)
	
	chosen_action = np.zeros(actionSize)
	chosen_action[np.argmax(q[0])] = 1
	return chosen_action
	
def remember(observation, action, reward, nextState, done):
	memory.append((observation, action, reward, nextState, done))
	
def replay(model, batchSize):
	
	global epsilon #the local epsilon is the same as the global and can be changed from this method
	minibatch = random.sample(memory, batchSize)
	
	for state, action, reward, nextState, done in minibatch:
		target = reward
		
		if not done:
			nextState = processImage(nextState)
			target = (reward + gamma * np.amax(model.predict(nextState)[0]))
			
		state = processImage(state)
		targetF = model.predict(state)
		targetF[0][np.argmax(action)] = target
		model.fit(state, targetF, epochs=1, verbose=0)
		
	if epsilon > epsilon_min:
		epsilon *= epsilon_decay
	
def loadModel(model):
	model.load_weights(path)
	print("Successfully loaded network")
	
def saveModel(model):
	model.save(path)
	print("Model saved successfully")

#performs image pre-processing, returns an np array
def processImage(observation) -> np.array:
	
	global first
	global state
	
	#convert the image to grayscale. Having colors is too computationally intensive.
	#The image is now (224, 240) with no third channel for color
	#grayScaleState = skimage.color.rgb2gray(observation)
	grayScaleState = skimage.color.rgb2lab(observation)
	grayScaleState = grayScaleState[:,:,1]/100
	
	#now we must downscale the image into something that is much smaller than 224x240
	#this transforms the image into a quarter the original resolution
	resizedState = skimage.transform.resize(grayScaleState, (56, 60))
	
	#viewer = ImageViewer(resizedState)
	#viewer.show()
	
	#We must stack 4 images together as the input to the Convolutional Neural Network (CNN)
	#the state is now (56, 60, 4)
	
	#initialize the stacked image with the same 4 images since this is the first image
	if first == False:
		state = np.stack((resizedState, resizedState, resizedState, resizedState), axis=2)
		first = True
	else:
		state = np.concatenate((resizedState[:,:,None], state[0,:,:,:3]), axis=2)
	
	#viewer = ImageViewer(state)
	#viewer.show()
	
	#the keras model requires 4 dimensions, add a fourth dimension
	#the state is now (1, 56, 60, 4)
	state = state.reshape(1, state.shape[0], state.shape[1], state.shape[2])
	
	return state
	
#saves the best replay, overwriting the previous best replay
def saveReplay():
	print("NEW BEST REPLAY!")
	pass

if __name__ == "__main__":
	env = retro.make(game='SuperMarioBros-Nes', state='Level1-1')
	
	actionSize = env.action_space.n #returns 9, the number of possible actions
	initialAction = np.zeros([actionSize]) #forms an array of 0's in the action space
	
	model = buildModel(actionSize) #create a convolutional neural network
	loadModel(model) #load the saved weights for the model
	batchSize = 100
	maximumTotalReward = 0
	
	for episode in range(numberOfEpisodes):
	
		#reset the environment
		observation = env.reset()
		
		steps = 0
		frame_count = 0
		lives = 2 #the initial number of lives
		
		previousReward = 0
		stepsWithoutRewardGain = 0
		totalReward = 0
		
		#process the first image to load the image buffer
		image = processImage(observation)
		
		while True:
		
			env.render() #disable to increase speed by ~1.1x
			
			action = train(model, image, actionSize) #get an action
			nextObservation, reward, done, info = env.step(action) #take an action
			
			frame_count += 1
			steps += 1
			totalReward += reward
			
			#penalize losing a life heavily, total reward is independent of this
			if (lives > info['lives']):
				reward = -100
			
			remember(observation, action, reward, nextObservation, done) #add to the memory buffer
			
			observation = nextObservation
			
			if (info['lives'] > lives): #the player gained a 1UP, update the number of lives
				lives = info['lives']
			
			image = processImage(observation)
			
			if (previousReward == reward):
				stepsWithoutRewardGain += 1
			else:
				stepsWithoutRewardGain = 0
			
			previousReward = reward
			
			if done or (lives > info['lives']) or (stepsWithoutRewardGain > 1001): #losing a life ends the episode or not moving for 30 in-game seconds
				print("\nEpisode #{} ended in {} steps. Epsilon = {}. Total reward = {}".format(episode+1, steps, epsilon, totalReward))
				
				#save the replay if it was better than anything seen previously
				if (totalReward > maximumTotalReward):
					maximumTotalReward = totalReward
					saveReplay()
				
				break
				
			#call replay memory
			if len(memory) > batchSize and (frame_count % 1000) == 0: #1000 frames is 30 in-game seconds
				replay(model, batchSize)
				
		#if (episode % 10 == 0): #save the model every 10 episodes
		#saveModel(model) #save the model every episode
		
env.close()
exit(0)

#keep button pressed for 4 frames rather than choosing a new action each frame
	#this requires keeping each of 4 frames for CNN input
###terminate the episode if no progress after x amount of time (still train though, training learns what bad Q values are too!)
###slow the cooling schedule! (change .95 gamma?)
#increase pixel input to 80x80 maybe
###if you lose a life, give a giant penalty! -100 reward
#grade rewards over time, so that it becomes heavily incentivized to move instead of standing still
#implement monitoring for replays (try it in test.py), python -m retro.scripts.playback_movie ./replays/SuperMarioBros-Nes-Level1-1-000000.bk2


#print("Action Space {}".format(env.action_space))
#print("State Space {}".format(env.observation_space))

#action[0] = 0
#action[1] = 0
#action[2] = 0
#action[3] = 0
#action[4] = 0
#action[5] = 0
#action[6] = 0 #left arrow
#action[7] = 1 #right arrow
#action[8] = 1

#print(env.observation_space) #Box(224, 240, 3)
#print(env.action_space) #<gym.spaces.multi_binary.MultiBinary object at 0x000001EA6EE47470>

#busy loop to slow emulator down to real time!
#for i in range(400000):
#	pass

#action is an array of 9 numbers, all either 0 or 1 to indicate a button pressed or not pressed
#obs is some giant matrix
#reward is the reward
#done is the status of the game
#info is a dictionary with the following keys:
#	levelLo
#	xscrollHi
#	levelHi
#	coins
#	xscrollLo
#	time
#	scrolling
#	lives
#	score