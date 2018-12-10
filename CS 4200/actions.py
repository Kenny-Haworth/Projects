import retro
from numpy import array

env = retro.make(game='SuperMarioBros-Nes', state='Level1-1')

numEpisodes = 1000

action = [0,0,0,0,0,0,0,0,0] #take no action

for episode in range(numEpisodes):

	observation = env.reset()
	
	totalReward = 0
	steps = 0
	lives = 2

	while True:
	
		if (steps == 100):
			action[0] = 0 #sprint button
			action[1] = 0
			action[2] = 0
			action[3] = 0
			action[4] = 0
			action[5] = 0
			action[6] = 0 #left arrow
			action[7] = 1 #right arrow
			action[8] = 0 #jump button
			
		env.render()
		obs, reward, done, info = env.step(action)
		
		steps += 1
		totalReward += reward
		
		for i in range(400000): #busy loop to slow down emulator to real-time
			pass
		
		if (info['lives'] > lives): #the player gained a 1UP, update the number of lives
			lives = info['lives']
		
		if done or (lives > info['lives']):
			print("\nEpisode #{} ended in {} steps. Total reward = {}".format(episode+1, steps, totalReward))

			break
			
exit(0)