# Terra Nova Changelog

<strong>"Quality of Life"</strong> update, <ins>July 18, 2018</ins>.
This update mostly focuses on making the game more user-friendly and bugfixes.

<strong>Changes:</strong>

<ul>

<li>Added this changelog to keep a document of all changed features for each update.</li>
<li>The user can now enter 0 (zero) at any time to see the colony's current statistics.</li>
<li>The user now has the option to go back on any menu.</li>
<li>Added an option to toggle the text delay from the main menu.</li>
<li>After each day, the console will clear the previous day's text to make things clearer and prevent a "wall of text".</li>
<li>Food is eaten each day based upon the size of the population. For example, 35 population consume 35 food per day. Failure to feed your population results in 1/2 of all who went unfed that day to starve to death.</li>
<li>Weather now only has a 50% chance of occuring each day.</li>
<li>The chance of an enemy attack is now only 50% each day.</li>
<li>Food now begins at 40, poppulation at 10, and offense at 0.</li>
<li>Changed text from holding a festival, holding a feast, and gathering resources to make it more realistic and immersive.</li>
<li>Decreased the population gains from the portal to balance the food consumption of a larger population.</li>
<li>Since the player will not have a reasonable chance of rescuing the fair maiden early on, she will now only spawn after day 50, but still has only a 1 in 100 chance of spawning each day after that point.</li>

</ul>

<strong>Bugfixes:</strong>

<ul>

<li>The user can no longer crash the game from inputting a string instead of an integer.</li>
<li>The main menu no longer breaks once the integer length of a statistic changes.</li>
<li>The user can no longer buy something from the menus that they do not have enough resources for.</li>
<li>Tweaked many of the delay values to make text delay faster and the menus feel snappier.</li>
<li>Fixed improper spacing between menus and tabs within menus.</li>
<li>Removed inefficient, unused or unnecessary, and repetitive code to reduce game file size and improve performance.</li>
  
</ul>

Total lines of code: <strong>1787</strong> (<strong>added 678</strong> since last update)



<hr />



Uploaded Terra Nova to this repository for the first time, <ins>April 27, 2018</ins>.
Terra Nova has been in development since <ins>November 22, 2016</ins>,
so this list includes all features since development began.

<strong>Changes:</strong>

<ul>

<li>Added a main menu for the user to start a new game, see the tutorial, or see the credits.</li>
<li>Added happiness, food, population, offense, defense, and materials for the user to manage their colony.</li>
<ul>
	<li>Happiness begins at 60.</li>
	<li>Food begins at 20.</li>
	<li>Population begins at 20.</li>
	<li>Offense begins at 5.</li>
	<li>Defense begins at 10.</li>
	<li>Materials begins at 10.</li>
</ul>

<li>Added a colony menu that prints at the beginning of each day so the user can view their colony statistics.</li>
<li>Added text delay for theatrical effect.</li>
<li>Added weather. The effects of weather are temporary and only last for a single day.</li>
<ul>
	<li>Rain			(-10 happiness)</li>
	<li>Sunshine		(+10 happiness)</li>
	<li>Lightning Storm	(currently nothing)</li>
	<li>Snow			(currently nothing)</li>
	<li>Wind			(-10 offense)</li>
	<li>Fog				(-10 defense)</li>
</ul>

<li>Each day, the user has four options available to them, along with the following sub-menus:</li>
<ul>
	<li>Hold a festival  	(increases population, costs materials)</li>
	<ul>
		<li>A Dance        (+5 population,  -10 materials)</li>
		<li>A Parade       (+10 population, -18 materials)</li>
		<li>A Play         (+20 population, -30 materials)</li>
		<li>A Carnival     (+30 population, -45 materials)</li>
	</ul>
	<li>Hold a feast     	(increases happiness, costs food)</li>
	<ul>
		<li>A Picnic                  (+5 happiness,  -10 food)</li>
		<li>A Banquet                 (+10 happiness, -18 food)</li>
		<li>A Barbeque                (+20 happiness, -30 food)</li>
		<li>A huge multi-meal feast!  (+30 happiness, -45 food)</li>
	</ul>
	<li>Go on a hunt     	(increases food, may be dangerous)</li>
	<ul>
		<li>Right Outside the Gates                 (+5 food, no danger)</li>
		<li>The Waterfalls                          (+10 food, low danger)</li>
		<li>The Open Plains                         (+20 food, moderate danger)</li>
		<li>The Deep Forest                         (+30 food, moderate-high danger)</li>
		<li>The Badlands                            (+50 food, high danger)</li>
		<li>The Tyrannosaurus Rex Breeding Grounds  (+60 food, very high danger)</li>
	</ul>
	<li>Gather resources 	(increases materials, may be dangerous)</li>
	<ul>
		<li>The Riverbeds         (+5 materials,  low danger)</li>
		<li>The Shoreline         (+10 materials, medium danger)</li>
		<li>The Underwater Caves  (+20 materials, medium-high danger)</li>
		<li>The Deep Mines        (+30 materials, high danger)</li>
	</ul>
</ul>

<li>Added enemy attacks:</li>
<ul>
	<li>Each day there is a 100% chance of being attacked.</li>
	<li>The user can be attacked by dinosaurs or "sixers" (enemy colonies of other humans).</li>
	<ul>
		<li>The first 10 days the user is always attacked by dinosaurs.</li>
		<li>After the first 10 days, the user has a 50% chance of being attacked by dinosaurs and a 50% chance of being attacked by sixers.</li>
	</ul>
	<li>If the attackers have more attack strength then the colony defense, it is game over.</li>
	<li>Attack strength is randomized, with a minimum attack strength of 1 and a maximum attack strength of 8 + 2*the current day. Thus, each day the enemy's maximum attack strength grows by 2, while it's minimum attack strength remains at 1.</li>
</ul>

<li>Each day after enemy attack, the user has the option of spending materials to increase offensive of defensive capabilities with the following sub-menus:</li>
<ul>
	<li>Increase Offense  	(increases offense, costs materials)</li>
	<ul>
		<li>Spears      (+5 offense,  -15 materials)</li>
		<li>Guns        (+10 offense, -40 materials)</li>
		<li>Ballistas   (+20 offense, -100 materials)</li>
	</ul>
	<li>Increase Defense     	(increases defense, costs materials)</li>
	<ul>
		<li>Reinforced Walls      (+ 5 defense, -15 materials)</li>
		<li>Personal Body Armor   (+10 defense, -40 materials)</li>
		<li>Trenches              (+20 defense, -100 materials)</li>
	</ul>
	<li>Continue to Next Day</li>
</ul>

<li>The user must press the enter key to confirm on-screen events and continue the game after the following events:</li>
<ul>
	<li>The colony statistics are read out at the beginning of the day.</li>
	<li>The user holds a festival, holds a feast, goes on a hunt, or gathers resources.</li>
	<li>After an attack by dinosaurs or sixers.</li>
	<li>After upgrading offensive or defensive capabilities.</li>
	<li>After the end of each day.</li>
</ul>

<li>Added in a portal that gives resources to the player at the end of each day. The user receives more of what they need.</li>
<li>Added in a "fair maiden."</li>
<ul>
	<li>The fair maiden has a 1 in 100 chance of spawning each day.</li>
	<li>The player can choose to look for the fair maiden after she spawns or not.</li>
	<li>100 offense is required to successfully find the fair maiden 100% of the time after she spawns, with chances decreasing by 10% for every 10 less offense the user has than 100. (50 offense = 50% chance to rescue her)</li>
	<li>100 defense is required to successfully bring the fair maiden back to the colony 100% of the time, with chances decreasing by 10% for every 10 less defense the user has than 100. (50 defense = 50% chance to bring her back to the colony)</li>
	<li>Should the player choose to look for the fair maiden and fail in finding her, the colony loses half it's population.</li>
</ul>
  
</ul>

Total lines of code: <strong>1109</strong> (<strong>added 1109</strong> since last update)