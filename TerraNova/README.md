# Terra Nova Changelog

<strong>"Danger"</strong> update, <ins>July 30, 2018</ins>.
This update focuses on implementing danger into the game.

Most of the following are stats for nerds, so to summarize the danger update, successfully harvesting food or materials in a dangerous area is dependent upon your offense.
If you failed or partially failed to loot a dangerous area, get more offense and try again. More offense will always increase your chances of success.

<strong>Changes:</strong>

<ul>

<li>Hunting and gathering materials can be dangerous, and can have negative consequences.</li>
<li>There are 3 possibilities when going to a dangerous area:</li>
<ul>
	<li><strong>Failure:</strong> a negative consequence occurs.</li>
	<li><strong>Partial success:</strong> resources are successfully obtained, but a negative consequence occurs.</li>
	<ul>
		<li>Less resources are gained here than that from a complete success.</li>
		<li>The negative consequence is not near as bad as that from a failure.</li>
	</ul>
	<li><strong>Complete success:</strong> all resources are successfully obtained.</li>
</ul>
<li>Areas are marked in order of increasing danger on the hunt and material gathering menus. (added in first update, re-mentioned here for clarity)</li>
<li>The higher the danger, the greater the consequence if the player is not successful in hunting or gathering in these areas.</li>
<li>Each area to hunt or gather materials has a corresponding danger value associated with it. The greater the danger, the higher the danger value.</li>
<li><strong>Successfully hunting or gathering materials in these areas is determined by the following formula:</strong></li>
<ul>
	<li>If the player's offense is less than half the area's danger value, the player will always fail.</li>
	<li>If the player's offense is exactly half the area's danger value, there is a 75% chance of failure, 25% chance of partial success, and a 0% chance of complete success.</li>
	<li>If the player's offense is one less than the area's danger value, there is a 10% chance of failure, 20% chance of partial success, and a 70% chance of complete success.</li>
	<li>If the player's offense is equal to or greater than the area's danger value, there is a 100% chance of complete success.</li>
	<ul>
		<li>Even when the player has a 100% chance of complete success, there is still a 25% or 75% chance of being attacked, depending on the area.</li>
		<li>There will be no negative consequences in this case.</li>
		<li>In some areas getting attacked will slightly decrease harvest gains, and in other areas it will slightly increase harvest gains.</li>
	</ul>
	<li>If the player's offense is between half the area's danger value and the area's danger value, it is calculated by linear regression.</li>
	<ul>
		<li>Chances of partial success and complete success will rise according to your offense in this case.</li>
		<li>The closer your offense is to the minimum offense value for success, or half the area's danger value, the closer you are to having a 0% chance of complete success and 25% chance of partial success.</li>
		<li>The closer your offense is to the maximum offense value for success (before reaching the area's danger value), the closer you are to having a 70% chance of complete success and 20% chance of partial success.</li>
	</ul>
	<li>Let's look at an example to clarify. In this case, the area's danger value is 10. The chances of failure, partial success, and complete success will be based on your offense as shown:</li>
	
	![Danger Example Photo](https://github.com/Kenny-Haworth/Projects/blob/master/TerraNova/images/dangerExample.PNG "Danger Example Photo")
	
	<ul>
		<li>The Total column on the right displays the combined chances of partial and complete success, or the chances of not getting a failure.</li>
		<li>The chances scale between half the area's danger value (5) and the area's danger value (10):</li>
		<ul>
			<li>Failure scales down between 75% and 10%.</li>
			<li>Partial success scales down between 25% and 20%.</li>
			<li>Complete success scales up between 0% and 70%.</li>
			<li>Total success (the chances of a partial success or a complete success) scales up between 25% and 90%.</li>
		</ul>
	</ul>
	<li>So, what is the danger value of each area, you might ask? You'll just have to the play the game enough to find out!</li>
</ul>
<li>Added an option to gather materials outside the gates with no danger.</li>
<li>Changed gathering materials at the Shoreline to gathering materials at the Cove.</li>
<li>Changed gathering materials at the Deep Mines to gathering materials at the Volcano.</li>
<li>Changed the Underwater Caves to the Caves.</li>
<li>Changed starting materials to 0.</li>


</ul>

<strong>Bugfixes:</strong>

<ul>

<li>Fixed some text on the material gathering menu for consistency.</li>
<li>Removed duplicate option lines on the Offensive Upgrades menu.</li>
<li>The tooltip now correctly displays valid inputs when an invalid input is entered.</li>
<li>Fixed improper spacing caused by the following conditions:</li>
<ul>
	<li>Duplicate spaces caused when weather does not occur for a day.</li>
	<li>Missing spacing on the Defensive Upgrades menu after buying an upgrade.</li>
	<li>Missing spacing on the Main Menu after turning text delay off.</li>
	<li>Missing spacing when displaying statistical gains after purchasing ballistas or trenches.</li>
</ul>

</ul>

Total lines of code: <strong>2685</strong> (<strong>added 898</strong> since last update)


<hr />


<strong>"Quality of Life"</strong> update, <ins>July 18, 2018</ins>.
This update mostly focuses on making the game more user-friendly and bugfixes.

<strong>Changes:</strong>

<ul>

<li>Added this changelog to keep a document of all changed features for each update.</li>
<li>The user can now enter 0 (zero) at any time to see the colony's current statistics.</li>
<li>The user now has the option to go back on any menu.</li>
<li>Added an option to toggle the text delay from the main menu.</li>
<li>After each day, the console will clear the previous day's text to make things clearer and prevent a "wall of text."</li>
<li>Food is eaten each day based upon the size of the population. For example, 35 population consume 35 food per day. Failure to feed your population results in 1/2 of all who went unfed that day to starve to death.</li>
<li>Weather now only has a 50% chance of occuring each day.</li>
<li>The chance of an enemy attack is now only 50% each day.</li>
<li>Food now begins at 40, population at 10, and offense at 0.</li>
<li>Changed text from holding a festival, holding a feast, and gathering resources to make it more realistic and immersive.</li>
<li>Decreased the population gains from the portal to balance the food consumption of a larger population.</li>
<li>Since the player will not have a reasonable chance of rescuing the fair maiden early on, she will now only spawn after day 50, but still has a 1 in 100 chance of spawning each day after that point.</li>

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
		<li>Reinforced Walls      (+5 defense, -15 materials)</li>
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