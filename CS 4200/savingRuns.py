import retro
import os

env = retro.make(game='SuperMarioBros-Nes', state='Level1-1', record='./replays')
#env = wrappers.Monitor(env, "./replays", force=True)

numEpisodes = 1000
maxReward = 0
newBest = False

for episode in range(numEpisodes):

	observation = env.reset()
	
	if (newBest == False) and (episode != 0): #delete the replay, it wasn't good enough
	
		string = str(episode-1)
		
		while len(string) != 6:
			string = "0" + string
		
		os.remove("./replays/SuperMarioBros-Nes-Level1-1-" + string + ".bk2")
		
	newBest = False
	
	totalReward = 0
	steps = 0
	lives = 2

	while True:
		#env.render()
		obs, reward, done, info = env.step(env.action_space.sample())
		
		steps += 1
		totalReward += reward
		
		if (info['lives'] > lives): #the player gained a 1UP, update the number of lives
			lives = info['lives']
		
		if done or (lives > info['lives']):
			print("\nEpisode #{} ended in {} steps. Total reward = {}".format(episode+1, steps, totalReward))
			
			if (maxReward < totalReward):
				print("NEW BEST!!!!")
				newBest = True
				maxReward = totalReward
				
			break
			
print("Largest reward: ", maxReward)
exit(0)