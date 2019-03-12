# Terra Nova Changelog

<strong>"Bugfixes"</strong> update, <ins>December 16, 2018</ins>.

Winter break is finally here, and with it I have some time to work on Terra Nova again!
This update contains a few improvements focused around... ???

<strong>Changes:</strong>

<ul>
<li>The screen now clears after a game over and after the lore has been read at the start of a new game.</li>
<li>Text printed immediately after turning text delay on now has text delay.</li>
<li>Added in the lore and tutorial (finally).</li>
<li>When population die to starvation, happiness is now subtracted based upon whichever of the following two calculations is lowest:</li>
<ul>
	<li>1. -1 happiness for every 2 people that starve</li>
	<li>2. Loss of happiness based upon the percentage of the population that died to starvation.</li>
	<li>This prevents loss of population from crippling the player late game, as losing 200 people resulted in -100 happiness under the first calculation, lowering defense by 3/4 and resulting in an unrecoverable game over. However, losing 200 population is a small amount compared to 1000 people, so only 20 happiness is lost based on the second calculation.</li>
</ul>
<li>Reduced starting food to 40 and starting population to 10.</li>
<ul>
	<li>This little change makes early game much easier, as there is not too much population to feed starting out, and any population needed as defense increases can be gained through the portal or festivals.</li>
</ul>
<li></li>
</ul>

<strong>Bugfixes:</strong>

<ul>
<li>The colony information menu now properly displays statistics up to 4 digits long.</li>
<li>When population die to starvation, only the amount of happiness that was able to be subtracted from the colony is displayed.</li>
<li>When population die to starvation and there is no food, -0 food is no longer displayed.</li>
<li></li>
<li></li>
</ul>

Total lines of code: <strong>3262</strong> (<strong>added </strong> since last update)

<hr />





<strong>"Cornucopia"</strong> update, <ins>August 20, 2018</ins>.

Cornucopias contain a plethora of delicious things, and this update is no different!

<strong>Changes:</strong>

<ul>
<li>Happiness now caps at 100.</li>
<li>Happiness, food, population, offense, defense, and materials can no longer become negative.</li>
<li>The Colony Manager now returns how much of a stat was able to be added or subtracted for stats that have a floor or cap.</li>
<li>The following changes were made to the Weather Manager:</li>
<ul>
	<li>Fog and wind now subtract 10% of the colony's offense and defense for the day, respectively, rather than a flat value.</li>
	<li>If happiness is added or subtracted because of weather, only the amount that was able to be added or subtracted at the beginning of the day will be reverted at the end of the day.</li>
	<ul>
		<li>For example, take a colony of 95 happiness that experiences sunshine weather, granting +10 happiness. Happiness will cap at 100, but 10 happiness will not be subtracted at the end of the day, since this will leave the colony at 90 happiness, a net loss of 5 happiness. Instead, only 5 happiness will be subtracted at the end of the day, since only 5 happiness was able to be added at the beginning of the day before hitting the happiness cap.</li>
		<li>As another example, take a colony of 5 happiness that experiences rain weather, resulting in -10 happiness. Happiness flatlines at 0, but 10 happiness will not be added at the end of the day, since this will leave the colony at 10 happiness, a net gain of 5 happiness. Instead, only 5 happiness will be added at the end of the day, since only 5 happiness was able to be subtracted at the beginning of the day before hitting the happiness base of 0.</li>
	</ul>
</ul>
	
<li>Information printed to the screen from the Event Manager and Weather Manager in regards to stat gain or loss to the colony has been changed along the following guidelines:</li>
<ul>
	<li>Only the amount that is able to be added or subtracted from a given stat will be shown on screen for the user to see.</li>
	<ul>
		<li>For example, if a colony has 96 happiness and experiences sunshine, the user will be told that only 4 happiness was gained, not 10, since only 4 happiness could be added before hitting the happiness cap of 100.</li>
	</ul>
	<li>If none of a statistic can be added or subtracted from the colony, the user is not informed that 0 of that stat was added or subtracted.</li>
	<ul>
		<li>For example, if a colony has 0 happiness and experiences rain, the user will not be told of any effects, since no more happiness can be subtracted from the colony.</li>
	</ul>
</ul>
<li>The population gains and material costs on the Festival Menu has been changed to the following:</li>
<ul>
	<li>A Dance        (+5 population,  -10 materials)</li>
	<li>A Parade       (+10 population, -20 materials)</li>
	<li>A Play         (+20 population, -40 materials)</li>
	<li>A Carnival     (+40 population, -80 materials)</li>
</ul>
<li>Doubled food cost for feasts and changed the Feast Menu to the following:</li>
<ul>
	<li>A Picnic                  (+5 happiness,  -20 food)</li>
	<li>A Banquet                 (+10 happiness, -40 food)</li>
	<li>A Barbeque                (+20 happiness, -80 food)</li>
	<li>A huge multi-meal feast!  (+30 happiness, -120 food)</li>
</ul>
<li>Quadrupled food gains from hunting. Yes, you read that correctly. Quadrupled. Cornucopias are a symbol of plenty, after all.</li>
<li>Increased material gains from the Caves and the Volcano to +40 materials and +80 materials, respectively.</li>
<li>The Offensive Upgrades menu has been changed to the following items:</li>
<ul>
	<li>Spears              (+ 5 offense, -10 materials)</li>
	<li>Buggies             (+10 offense, -20 materials)</li>
	<li>Muskets             (+20 offense, -40 materials)</li>
	<li>Assault Rifles      (+40 offense, -80 materials)</li>
	<li>A Rocket Launcher   (+80 offense, -160 materials)</li>
</ul>
<li>The Defensive Upgrades menu has been changed to the following items:</li>
<ul>
	<li>Tall Towers           (+ 5 defense, -10 materials)</li>
	<li>Reinforced Walls      (+10 defense, -20 materials)</li>
	<li>Personal Body Armor   (+20 defense, -40 materials)</li>
	<li>A Moat                (+40 defense, -80 materials)</li>
	<li>Ballistas             (+80 defense, -160 materials)</li>
</ul>
<li>Increased starting food to 80 and starting population to 20.</li>
<li>If one person goes unfed at the end of the day they now starve to death rather than the user being informed that they lost 0 population.</li>
<li>Losing population to starvation now deducts happiness at a rate of -1 happiness for every 2 people who starve.</li>
<li>Increased gains from finding the Fair Maiden from +100 food to +500 food and +50 materials to +200 materials.</li>
<li>The Fair Maiden now spawns after day 20 instead of after day 50.</li>
<li>Holding a festival to increase population can now only increase population by half as many people as you have.</li>
<ul>
	<li>Logically, if you had 10 people you couldn't make more than 5 babies, assuming an equal ratio of male to female.</li>
	<li>If you have 1 population, you will be unable to increase your population through a festival. The only way to raise population above 1 is through gaining population from the portal, after which festivals can be held to increase population again.</li>
</ul>
<li>Failing to hunt or gather resources in a dangerous area now deducts happiness in addition to population.</li>
</ul>

<strong>Bugfixes:</strong>

<ul>
<li>Fixed a crash when the Fair Maiden spawns caused by the Event Manager reading null chars. The Event Manager now checks if the char exists before reading it.</li>
<li>The player can no longer get an instant game over from fog deducting 10 defense from the colony for a day.</li>
<li>Fixed a broken text delay when enemy attack strength prints during an attack.</li>
<li>Fixed a grammar error when people starve to death and there is 0 food.</li>
<li>Fixed a grammar error when fog lifts at the end of the day.</li>
</ul>

<strong>Additional Notes:</strong>

This update makes the game much more balanced. Early game is a little bit difficult if the player does not immediately gather resources,
but late game becomes incredibly easy. The player can reach around day 250 before sustaining a large population is no longer viable, since enemy strength scales infinitely
and only 240 food can be gathered each day.

Total lines of code: <strong>3262</strong> (<strong>added 265</strong> since last update)

<hr />





<strong>"Attack"</strong> update, <ins>August 14, 2018</ins>.

Happiness and population now matter! The lower happiness and population are, the weaker your effective defense will be,
and the higher happiness and population are, the stronger your effective defense will be.

<strong>Changes:</strong>

<ul>
<li>A combination of happiness, population, and defense now determine the colony's effective defense when an enemy attacks.</li>
<li>The effect of happiness (ignoring population) upon effective defense is the following:</li>
<ul>
	<li>If happiness is 85, the colony's effective defense will be the same as the colony's defense.</li>
	<li>If happiness is above 85, the colony's effective defense will be greater than the colony's defense.</li>
	<li>If happiness is below 85, the colony's effective defense will be less than the colony's defense.</li>
	<ul>
		<li>This effect will scale down to 1/4, such that at 0 happiness the colony's effective defense will always be 1/4 of the colony's defense.</li>
	</ul>
</ul>
<li>The effect of population (ignoring happiness) upon effective defense is the following:</li>
<ul>
	<li>If population is equal to or above the colony's defense, the colony's effective defense will be the same as the colony's defense.</li>
	<li>If population is less than the colony's defense, the colony's effective defense will be less than the colony's defense.</li>
	<ul>
		<li>This effect will scale down to 0, such that at 0 population the colony's effective defense will always be 0 regardless of the colony's actual defense.</li>
		<li><strong>Note</strong> that at some point 0 population will mean game over, but this will be added in a later update. For now, 0 population is still a death sentence as you will be sure to die to the next enemy attack.</li>
	</ul>
</ul>
<li>When an enemy attacks, the player will be told how strong their effective defense is based upon their population and happiness.</li>
<ul>
	<li>The less population the colony has compared to defense, the more severely the player is warned that there are not enough men to defend Terra Nova with all available weapons.</li>
	<li>The more unhappy the colony gets, the more severely the player is warned that the men are unhappy and will not fight at full strength. If happiness is above 85, the player will be told the colony is getting a defense boost from the colony's happiness.</li>
	<li>The event manager handles printing this event. There are 25 possibilities to be printed.</li>
</ul>
<li>The way enemy attack strength is calculated has been changed in the following ways:</li>
<ul>
	<li>Enemy attack strength begins on day 1 at a minimum strength of 1 and a maximum strength of 6.</li>
	<li>Every day after that, both minimum strength and maximum strength are raised by 1.</li>
	<ul>
		<li>Assuming the player does not change their effective defense, the earliest game over possible is now on day 6 with a maximum attack strength of 11.</li>
		<li>Assuming the player does not change their effective defense, the latest game over possible is now on day 11 with a minimum attack strength of 11.</li>
	</ul>
	<li>The following changes were made to Sixer attacks:</li>
	<ul>
		<li>Sixer attacks can now only occur after day 15.</li>
		<li>After day 15, if there is an attack, there is a 50% chance of dinosaur attack and a 50% chance of Sixer attack.</li>
		<li>Tying in battle with Sixers now decreases happiness by 30 instead of 20.</li>
		<li>Sixer attacks are now 1/4 stronger than dinosaur attacks.</li>
		<ul>
			<li>For example, if dinosaurs would have attacked with a strength of 100, the Sixer attack will be a strength of 125.</li>
		</ul>
	</ul>
</ul>
<li>The colony now starts with 85 happiness.</li>
<li>The Event Manager can now handle reading text files up to 99 sections long instead of up to 10 sections long.</li>
</ul>

<strong>Bugfixes:</strong>

<ul>
<li>Removed some unnecessary logic parentheses in the Event Manager class.</li>
</ul>

<strong>Additional Notes:</strong>

<strong>The game is unbalanced at this point, and not in the player's favor!</strong> I played on this update a little bit to test it and I couldn't make it past day 10.
Later updates will focus on making it easier to keep a larger population by drastically increasing food gains from hunting!

Here's my reasoning on the way happiness and population affect defense in this update:

<ins>Population:</ins> If you had 10 people and bought 20 assault rifles, your defense should not rise as much as if you had 20 people and bought 20 assault rifles,
as 10 people can only wield 10 assault rifles.

Thus, increasing your defense has no effect if your population does not at least equal your defense.
Try and keep your population as high as your defense for the best results.
If your population ever drops to 0, you logically would not be able to defend Terra Nova with no people, which is why effective defense scales down to 0 based upon population.

<ins>Happiness:</ins> Your people will always have some willingness to defend themselves regardless of how unhappy they are. At a baseline level, they want to survive.
However, they will fight much better if they are happier, so effective defense scales down to a proportion of your defense as happiness drops, in this case 1/4 of your defense at 0 happiness.

Total lines of code: <strong>2997</strong> (<strong>added 167</strong> since last update)

<hr />





<strong>"Organization"</strong> update, <ins>August 11, 2018</ins>.

<strong>Changes:</strong>

<ul>
<li>All event text files are now in an "Events" folder, with subfolders for hunt events and resource events.</li>
<li>All menu text files are now in a "Menus" folder.</li>
<li>All managers (ColonyManager.java, DisplayManager.java, etc.) are now in a "Managers" folder and are imported through a "Managers" package.</li>
</ul>

Total lines of code: <strong>2830</strong> (<strong>added 16</strong> since last update)

<hr />





<strong>"Fair Maiden"</strong> update, <ins>August 10, 2018</ins>.

<strong>Changes:</strong>

<ul>
<li>The Menu Manager and Event Manager now handle the Fair Maiden event.</li>
<li>Nearly all text for finding and rescuing the Fair Maiden has been completely redone.</li>
<li>The Fair Maiden can now be found at or after day 50.</li>
<li>Increased the chances of the Fair Maiden spawning from 1% to 2%.</li>
<li>Successfully rescuing the Fair Maiden now gives the following rewards:</li>
<ul>
	<li>+100 happiness</li>
	<li>+100 food</li>
	<li>+10 population</li>
	<li>+15 offense</li>
	<li>+15 defense</li>
	<li>+50 materials</li>
</ul>
<li>Greatly reduced the amount of code needed to roll chances for the Fair Maiden.</li>
<li>Chances to find the Fair Maiden now increases by 1% for every 1 offense you have, instead of by 10% for every 10 offense you have.</li>
<li>Chances to return with the Fair Maiden now increases by 1% for every 1 defense you have, instead of by 10% for every 10 defense you have.</li>
<li>There is no longer a text delay on the spacing before printing "Your current colony statistics:" at the beginning of a day.</li>
<li>The Event Manager can now handle the following conditions:</li>
<ul>
	<li>Ending on a blank line.</li>
	<li>Printing custom delays or commands on the last line that is printed for a section.</li>
	<li>Printing a dark statement, a "noNewLine" custom command, and the end of a section all on the same line.</li>
	<li>The user no longer has to press enter to continue at the end of a section if the new custom command "noEnter" has been specified.</li>
</ul>
</ul>

As a testament to the efficiency of the Fair Maiden update, the total lines of code has dropped despite adding more content!

Total lines of code: <strong>2814</strong> (<strong>removed 42</strong> since last update)

<hr />





<strong>"Event Manager"</strong> update, <ins>August 7, 2018</ins>.

<strong>Changes:</strong>

<ul>
<li>The following events events are no longer handled within TerraNova.java but are instead handled within EventManager.java:</li>
<ul>
	<li>Holding a Festival</li>
	<li>Holding a Feast</li>
	<li>Going on a Hunt</li>
	<li>Gathering Resources</li>
	<li>Purchasing items from the Offensive Menu</li>
	<li>Purchasing items from the Defensive Menu</li>
</ul>
<li>The Event Manager will not tell the user that 0 of a stat is gained or lost if the stat calculation is a proportion as opposed to a flat amount.</li>
</ul>

<strong>Bugfixes:</strong>

<ul>
<li>Fixed a couple of grammar errors when failing to raid the Tyrannosaurus Rex Breeding Grounds.</li>
</ul>

Total lines of code: <strong>2856</strong> (<strong>added 184</strong> since last update)

<hr />





<strong>"Menu Manager"</strong> update, <ins>August 4, 2018</ins>.

<strong>Changes:</strong>

<ul>
<li>Menu's and sub-menu's are no longer displayed from TerraNova.java but are instead displayed from MenuManager.java.</li>
<ul>
	<li>The only menu not handled by the Menu Manager is the main menu, which is handled by the Display Manager.</li>
	<li>Menu's are now read in through a text file, and all text files are processed through the same method. This makes it much easier to add additional menu's or edit existing menu's.</li>
</ul>
</ul>

<strong>Bugfixes:</strong>

<ul>
<li>The main game method now correctly throws InterruptedException and IOException rather than Exception.</li>
<li>The people no longer enjoy a "palet of food" at the banquet.</li>
<li>Wind now "dies down" at the end of the day rather then "ends at the end of the day."</li>
</ul>

As a testament to the efficiency of the Menu Manager, for the first time the total amount of code has dropped from an update!

Total lines of code: <strong>2672</strong> (<strong>removed 153</strong> since last update)

<hr />





<strong>"Display Manager"</strong> update, <ins>August 3, 2018</ins>.

<strong>Changes:</strong>

<ul>
<li>The following screen events are no longer executed within TerraNova.java but are instead handled and executed from DisplayManager.java:</li>
<ul>
	<li>The main menu.</li>
	<li>The exposition.</li>
	<li>The tutorial.</li>
	<li>The credits.</li>
	<li>The colony menu.</li>
</ul>
</ul>

<strong>Bugfixes:</strong>

<ul>
<li>Removed an unused import statement used for file management (missed removing it in the Colony Manager update).</li>
</ul>

Total lines of code: <strong>2825</strong> (<strong>added 32</strong> since last update)

<hr />






<strong>"Weather Manager"</strong> update, <ins>August 2, 2018</ins>.

<strong>Changes:</strong>

<ul>
<li>Weather events are no longer controlled within TerraNova.java but are instead controlled within WeatherManager.java.</li>
<li>The styling for the hunt menu now matches the styling for the resource gathering menu.</li>
<li>Changed the following text delays:</li>
<ul>
<li>The main menu now has much faster text delay.</li>
<li>The resource gathering menu now has much faster text delay.</li>
<li>Increased the speed of all other menus by an equal amount.</li>
<li>Changed the tutorial, credits, and lore text delays to the same values.</li>
</ul>
</ul>

<strong>Bugfixes:</strong>

<ul>
<li>Removed several unnecessary text delay variables.</li>
<li>Fixed a bug where after day 10 enemy attack strength would be read out twice.</li>
</ul>

Total lines of code: <strong>2793</strong> (<strong>added 22</strong> since last update)

<hr />





<strong>"Colony Manager"</strong> update, <ins>August 1, 2018</ins>.

The next few updates will not add any new content to the game but will instead focus on optimizing the existing parts of TerraNova.
Specifically, code will be organized into a more object-oriented scheme, which should allow faster and more frequent updates.

For example, in this update everything to do with managing a colony has been moved into ColonyManager.java.
This can then be instantiated as an object for the main method in TerraNova.java to use.
Should multiplayer or npc colonys later be added to the game, this will now be much easier to do since multiple objects of the colony can be made and managed individually.

<strong>Changes:</strong>

<ul>
<li>The colony is no longer managed within TerraNova.java but is instead it's own class in ColonyManager.java.</li>
</ul>

<strong>Bugfixes:</strong>

<ul>
<li>Fixed an uneven text delay on the main menu.</li>
<li>Cleaned up inefficiency in the Fair Maiden method.</li>
<li>Removed two unused methods, check and saveGameStatistics.</li>
<li>Removed four unused import statements for date and time management and file management.</li>
</ul>


Total lines of code will now be measured as a combined total of all java and text files that are necessary for TerraNova to run.

Total lines of code: <strong>2771</strong> (<strong>added 86</strong> since last update)

<hr />






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
</ul>

![alt text](https://github.com/Kenny-Haworth/Projects/blob/master/TerraNova/images/dangerExample.png)

<li>Let's look at an example to clarify. In this case, the area's danger value is 10. The chances of failure, partial success, and complete success will be based on your offense as shown above.</li>
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
<li>Since the player will not have a reasonable chance of rescuing the Fair Maiden early on, she will now only spawn after day 50, but still has a 1 in 100 chance of spawning each day after that point.</li>

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
<li>Added in a "Fair Maiden."</li>
<ul>
	<li>The Fair Maiden has a 1 in 100 chance of spawning each day.</li>
	<li>The player can choose to look for the Fair Maiden after she spawns or not.</li>
	<li>100 offense is required to successfully find the Fair Maiden 100% of the time after she spawns, with chances decreasing by 10% for every 10 less offense the user has than 100. (50 offense = 50% chance to rescue her)</li>
	<li>100 defense is required to successfully bring the Fair Maiden back to the colony 100% of the time, with chances decreasing by 10% for every 10 less defense the user has than 100. (50 defense = 50% chance to bring her back to the colony)</li>
	<li>Should the player choose to look for the Fair Maiden and fail in finding her, the colony loses half it's population.</li>
</ul>
  
</ul>

Total lines of code: <strong>1109</strong> (<strong>added 1109</strong> since last update)