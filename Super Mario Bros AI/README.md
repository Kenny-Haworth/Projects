# Super Mario Bros AI

This project uses machine learning techniques to train an agent to play the original NES Super Mario Bros.
It uses Deep Q Learning with a Convolutional Neural Network (CNN) that is fed the raw pixel input of the game screen.

The agent was trained over several hundred game sessions, slowly getting better and better at the game.
This type of machine learning is known as reinforcement learning.

The agent was successfully able to beat the first stage during the 64th attempt.
While the agent was trained on other stages as well, the agent was not able to beat them due to time constraints. CNNs are incredibly resource-intensive and time-consuming to train, and if I had a better processor or GPU to train with I would have been able to find much faster results.

<li><strong>project.py</strong> contains the source code for this project.</li>
<li>The <strong>replays</strong> folder contains several runs of the game, showing how the agent improved from the first few episodes on for the first three worlds. Later episodes are always better!</li>
<li><strong>Project Proposal.pdf</strong> is a paper I wrote outlining the the intent and goals for this project. Within the next two weeks I will be writing and uploading a paper analyzing my results in-depth.</li>
<li>The neural network <strong>weights</strong> were not able to be uploaded due to the 100MB upload restriction enforced by GitHub.</li>

Planned goals for the future of this project:

<li>Have the agent play two levels simultaneously with one input for the controls</li>
<li>Complete multiple levels in a row (during the same run)</li>
<li>Obtain the maximum number of points</li>
<li>Defeat the most enemies</li>
<li>Collect the most coins</li>
<li>Obtain as many hidden items as possible</li>
<li>Find as many hidden paths as possible</li>


![alt text](https://github.com/Kenny-Haworth/Projects/blob/master/Super%20Mario%20Bros%20AI/replays/screenshot.png)