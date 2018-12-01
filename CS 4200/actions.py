import retro
from numpy import array

env = retro.make(game='SuperMarioBros-Nes', state='Level1-1')
#env = wrappers.Monitor(env, "./replays", force=True)

numEpisodes = 1000

#action = array( [0,1,0,1,1,0,0,1,1])#env.action_space.sample()
#action = [0,1,0,1,1,0,0,1,1]
action = [0,0,0,0,0,0,0,0,0]

#action[0] = 0 #b button
#action[1] = 1
#action[2] = 0
#action[3] = 1
#action[4] = 1
#action[5] = 0
#action[6] = 1 #left arrow
#action[7] = 1 #right arrow
#action[8] = 1 #jump button

for episode in range(numEpisodes):

	observation = env.reset()
	
	totalReward = 0
	steps = 0
	lives = 2

	while True:
	
		if (steps == 100):
			action[0] = 0 #b button
			action[1] = 0
			action[2] = 0
			action[3] = 0 #what button is crouch? definitely needed for going into the pipes
			action[4] = 0
			action[5] = 0
			action[6] = 0 #left arrow
			action[7] = 0 #right arrow
			action[8] = 0 #jump button
			
		env.render()
		obs, reward, done, info = env.step(env.action_space.sample())
		
		print(info['score'])
		
		for i in range(40000):
			pass
		
		steps += 1
		totalReward += reward
		
		if (info['lives'] > lives): #the player gained a 1UP, update the number of lives
			lives = info['lives']
		
		if done or (lives > info['lives']):
			print("\nEpisode #{} ended in {} steps. Total reward = {}".format(episode+1, steps, totalReward))
				
			break
			
print("Largest reward: ", maxReward)
exit(0)


#jumping actions:
#
#[0 1 0 1 1 0 0 1 1]
#[0 1 0 0 0 0 0 1 1]
#[1 1 0 0 1 0 0 1 1]
#[1 0 1 1 0 0 1 0 1]



