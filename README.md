Legends: Monsters and Heroes

## Files
---------------------------------------------------------------------------
GameStarter.java

. This is the main file where the program execution begins. 
. A start object is created and the startGame() function is called from this
file.

Start.java

. Used to help modularize code.
. Consists of functions which are required to implemet the game.

Legends.java

. Helps create the game menu, party and board (grid).
. Contains code to start playing the game with the created party and board.

Item.java

. Item class which is used to create Armors, Weapons, Spells and Potions. 
. This is the base class for Armor, Weapon, Spell and Potion classes.

Weapon.java

. Used to create a weapon.
. Subclass of Item class.

Armor.java

. Used to create an Armor.
. Subclass of Item class.

Spell.java

. Used to create a spell.
. Subclass of Item class.

Potion.java

. Used to create a potion.
. Subclass of Item class.

BoardGame.java

. BoardGame super class which consists of 2 attributes rows and columns
 which are common to all board games. 	

CommonArea.java

. Handles all monster fights.

CommonTile.java

. Extends the GameTile class.
. Sets an empty space as the marker for the tile.

Creature.java

. Super class which contains attributes common to heroes and monsters.
. The Hero and Monster classes extend this class.

Dragon.java

. Creates the Dragon monster. 
. Extends the Monster class.

Exoskeleton.java

. Creates the Exoskeleton monster. 
. Extends the Monster class.

FireSpell.java
.
. Creates a Fire spell.
. Extends the Spell class.

GameTile.java

. Creates a game tile which is used to create the board or grid.
. The gameTileMarker attribute helps determine the type of tile.

Grid.java

. Class with a static method which displays a grid and gets a 
marker for each element in the grid.  

Hero.java

. Creates a Hero. 
. Extends the Creature class. 

Heroes.java

. Used to get data of heroes from the given text files.
. Displays Hero and Party details.
. Adds Heroes to the party.

HeroTile.java

. Extends the GameTile class.
. Sets the string "P" as the marker for the tile.

IceSpell.java

. Creates an Ice spell.
. Extends the Spell class.

InaccessibleTile.java

. Extends the GameTile class.
. Sets the string "X" as the marker for the tile.

LegendsBoard.java

. Creates the game tiles and the board.
. Extends the BoardGame class.

LightningSpell.java

. Creates a Lightning spell.
. Extends the Spell class.

Market.java

. Creates a market and allows the user to buy from ot sell to the market.  
. Obtains item data from text files.
. Displays Market items.

MarketTile.java

. Extends the GameTile class.
. Sets the string "M" as the marker for the tile.

Monster.java

. Creates a Monster. 
. Extends the Creature class. 

Monsters.java

. Obtains monster data from text files.
. Seperates the monster data into three differnet lists.

Paladin.java

. Creates a Paladin hero.
. Extends the Hero class.

Party.java

. Creates a party (user chosen heroes).
. Displays the statistics for every paty member and their items.

Play.java

. Controls player actions and movements in the board/grid.

Randomizer.java

. Class to randomize data.

Sorcerer.java

. Creates a Sorcerer hero.
. Extends the Hero class.

Spirit.java

. Creates the Spirit monster. 
. Extends the Monster class.

Validator.java

. Helps validate integer inputs to ensure that the player 
enters only Integers when an Integer input is required.

Warrior.java

. Creates a Warrior hero.
. Extends the Hero class.


## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "Legends" after unzipping the files.
2. Run the following commands after opening a terminal. 

javac *.java
java GameStarter

## Input/Output Example
---------------------------------------------------------------------------

Final Output:

[OUTPUT]Welcome to Legends: Monsters and Heroes
Instructions:
1. Each party consists of 1-3 heroes
2. A world representing grid of size (row x column) is created. This is where moves and decisions need to be made.
3. There are three different spaces which are Inaccessible spaces, Common spaces and Market spaces
4. Use the w,a,s,d keys to move from one space to another
5. The party can only move to market and common spaces
6. When the party lands on a market space each Hero in the party will be able to buy Armors, Weapons, Potions or Spells
7. The first weapon the Hero purchases is set as the default weapon. This can be changed during battle
8. A Hero needs to be at least equal to the required hero level of the item and must have sufficient balance to purchase an item
9. When selling an item to the market the item will be bought back for 50% of the price it was bought for
10. The hero begins at position(0,0) and will have an adjacent market which can be visited
11. When the party visits a common space there is a 50% chance for them to encounter monsters
12. Heroes are also defeated if their hit points reaches 0 or goes below 0
13. Defeated heroes will be revived after the battle if at least one member in the party survives
14. Monsters are defeated if their hit points reaches 0 or goes below 0
15. If a hero defeats a monster the hero obtains gold and experience points
16. The hero will level up and become stronger when enough experience points have been obtained.
17. The attributes which are enhanced for a hero depends on the type of hero
18. If all party members are defeated the game ends

How many Heroes would you like to have in your party?(1-3)
[INPUT]2
[OUTPUT]Enter type of hero 1
1. Warrior
2. Sorcerer
3. Paladin
[INPUT]1
[OUTPUT]Choose your character
   Name                     Mana     Strength    Agility    Dexterity    Money    Experience    HitPoints
1. Gaerdal_Ironhand         1    100     700.0       500.0       600.0      1354          7          100.0

2. Sehanine_Monnbow         1    600     700.0       800.0       500.0      2500          8          100.0

3. Muamman_Duathall         1    300     900.0       500.0       750.0      2546          6          100.0

4. Flandal_Steelskin        1    200     750.0       650.0       700.0      2500          7          100.0

5. Undefeated_Yoj           1    400     800.0       400.0       700.0      2500          7          100.0

6. Eunoia_Cyn               1    400     700.0       800.0       600.0      2500          6          100.0

[INPUT]4
[OUTPUT]Enter type of hero 2
1. Warrior
2. Sorcerer
3. Paladin
[INPUT]2
[OUTPUT]Choose your character
   Name                     Mana     Strength    Agility    Dexterity    Money    Experience    HitPoints
1. Parzival                 1    300     750.0       650.0       700.0      2500          7          100.0

2. Sehanine_Moonbow         1    300     750.0       700.0       700.0      2500          7          100.0

3. Skoraeus_Stonebones      1    250     650.0       600.0       350.0      2500          4          100.0

4. Garl_Glittergold         1    100     600.0       500.0       400.0      2500          5          100.0

5. Amaryllis_Astra          1    500     500.0       500.0       500.0      2500          5          100.0

6. Caliber_Heist            1    400     400.0       400.0       400.0      2500          8          100.0

[INPUT]2
[OUTPUT]Your party is:
   Name                     Level    Mana    Strength    Agility    Dexterity    Money    Experience    Hit Points
1. Flandal_Steelskin        1    200     750.0       650.0       700.0      2500          7          100.0

2. Sehanine_Moonbow         1    300     750.0       700.0       700.0      2500          7          100.0

Enter number of rows the game should have (>3):
[INPUT]8
[OUTPUT]Enter number of columns the game should have (>3):
[INPUT]8

[OUTPUT]A new board has been created!
Marker P: Party space
Marker M: Market space
Marker X: Inaccessible space
Empty space: Common space

|P |M |M |  |  |X |  |  |
-------------------------
|X |  |  |  |  |M |M |  |
-------------------------
|  |M |X |  |  |  |M |  |
-------------------------
|X |M |  |  |M |  |  |M |
-------------------------
|M |  |  |  |M |  |M |M |
-------------------------
|  |M |X |  |  |X |  |  |
-------------------------
|M |  |M |  |X |  |  |  |
-------------------------
|X |M |  |  |  |  |M |M |
-------------------------

Turn 1:
Enter w to move up
Enter a to move left
Enter s to move down
Enter d to move right
Enter q to quit game
Enter i to show information
[INPUT]d
[OUTPUT]
|  |P |M |  |  |X |  |  |
-------------------------
|X |  |  |  |  |M |M |  |
-------------------------
|  |M |X |  |  |  |M |  |
-------------------------
|X |M |  |  |M |  |  |M |
-------------------------
|M |  |  |  |M |  |M |M |
-------------------------
|  |M |X |  |  |X |  |  |
-------------------------
|M |  |M |  |X |  |  |  |
-------------------------
|X |M |  |  |  |  |M |M |
-------------------------

Turn 2:
Enter w to move up
Enter a to move left
Enter s to move down
Enter d to move right
Enter q to quit game
Enter i to show information
Enter m to enter market
[INPUT]m
[OUTPUT]What would you like to do?
1. Buy armor
2. Buy weapons
3. Buy potions
4. Buy spells
5. sell items
6. Exit
[INPUT]1
[OUTPUT]Name              Cost  Required level  Damage Reduction
1. Platinum_Shield     150.0       1       200
2. Breastplate         350.0       3       600
3. Full_Body_Armor     1000.0       8       1100
4. Wizard_Shield       1200.0       10       1500
5. Guardian_Angel      1000.0       10       1000
Enter the corresponding number to buy your armor or enter -1 to go back
[INPUT]1
[OUTPUT]Who wants to buy this armor?
   Name                      Money items
1. Flandal_Steelskin        2500   []
2. Sehanine_Moonbow         2500   []
[INPUT]1
[OUTPUT]Item has been purchased!
What would you like to do?
1. Buy armor
2. Buy weapons
3. Buy potions
4. Buy spells
5. sell items
6. Exit
[INPUT]2
[OUTPUT]
   Name              Cost  Required level  Damage  Required Hands
1. Sword               500.0       1       800       1
2. Bow                 300.0       2       500       2
3. Scythe              1000.0       6       1100       2
4. Axe                 550.0       5       850       1
5. TSwords             1400.0       8       1600       2
6. Dagger              200.0       1       250       1
Enter the corresponding number to buy your weapon or enter -1 to go back
[INPUT]1
[OUTPUT]Who wants to buy this weapon?
   Name                      Money items
1. Flandal_Steelskin        2350   [Platinum_Shield]
2. Sehanine_Moonbow         2500   []
[INPUT]1
[OUTPUT]Item has been purchased!
What would you like to do?
1. Buy armor
2. Buy weapons
3. Buy potions
4. Buy spells
5. sell items
6. Exit
[INPUT]2
[OUTPUT]
   Name              Cost  Required level  Damage  Required Hands
1. Sword               500.0       1       800       1
2. Bow                 300.0       2       500       2
3. Scythe              1000.0       6       1100       2
4. Axe                 550.0       5       850       1
5. TSwords             1400.0       8       1600       2
6. Dagger              200.0       1       250       1
Enter the corresponding number to buy your weapon or enter -1 to go back
[INPUT]6
[OUTPUT]
Who wants to buy this weapon?
   Name                      Money items
1. Flandal_Steelskin        1850   [Platinum_Shield, Sword]
2. Sehanine_Moonbow         2500   []
[INPUT]2
[OUTPUT]Item has been purchased!
What would you like to do?
1. Buy armor
2. Buy weapons
3. Buy potions
4. Buy spells
5. sell items
6. Exit
[INPUT]6
[OUTPUT]Exiting Market

Turn 3:
Enter w to move up
Enter a to move left
Enter s to move down
Enter d to move right
Enter q to quit game
Enter i to show information
Enter m to enter market
[INPUT]s
[OUTPUT]
|  |M |M |  |  |X |  |  |
-------------------------
|X |P |  |  |  |M |M |  |
-------------------------
|  |M |X |  |  |  |M |  |
-------------------------
|X |M |  |  |M |  |  |M |
-------------------------
|M |  |  |  |M |  |M |M |
-------------------------
|  |M |X |  |  |X |  |  |
-------------------------
|M |  |M |  |X |  |  |  |
-------------------------
|X |M |  |  |  |  |M |M |
-------------------------

Turn 4:
Enter w to move up
Enter a to move left
Enter s to move down
Enter d to move right
Enter q to quit game
Enter i to show information
[INPUT]d
|  |M |M |  |  |X |  |  |
-------------------------
|X |  |P |  |  |M |M |  |
-------------------------
|  |M |X |  |  |  |M |  |
-------------------------
|X |M |  |  |M |  |  |M |
-------------------------
|M |  |  |  |M |  |M |M |
-------------------------
|  |M |X |  |  |X |  |  |
-------------------------
|M |  |M |  |X |  |  |  |
-------------------------
|X |M |  |  |  |  |M |M |
-------------------------
Monster encountered!
Battle Phase
Jormunngand:
level: 1
hit points: 100.0
defense: 115

Flandal_Steelskin:
level: 1
hit points: 100.0
Mana: 200

What will Flandal_Steelskin do?
1. Attack
2. Cast a spell
3. Use a potion
4. Change armor
5. Change weapon
6. Quit game
[INPUT]1
[OUTPUT]Flandal_Steelskin inflicted 754.0 damage to Jormunngand using Sword
Jormunngand fainted
Flandal_Steelskin earned 100 Gold!
Flandal_Steelskin gained 1 experience point(s)
Monster encountered!
Battle Phase
Melchiresas:
level: 1
hit points: 100.0
defense: 24

Sehanine_Moonbow:
level: 1
hit points: 100.0
Mana: 300

What will Sehanine_Moonbow do?
1. Attack
2. Cast a spell
3. Use a potion
4. Change armor
5. Change weapon
6. Quit game
[INPUT]1
[OUTPUT]Sehanine_Moonbow inflicted 751.25 damage to Melchiresas using Dagger
Melchiresas fainted
Sehanine_Moonbow earned 100 Gold!
Sehanine_Moonbow gained 1 experience point(s)

Turn 5:
Enter w to move up
Enter a to move left
Enter s to move down
Enter d to move right
Enter q to quit game
Enter i to show information
[INPUT]i
[OUTPUT]Your party is:
   Name                     Level    Mana    Strength    Agility    Dexterity    Money    Experience    Hit Points
1. Flandal_Steelskin        1    200     750.0       650.0       700.0      1950          8          100.0

Armors:
Name: Platinum_Shield, Damage Reduction: 200, Cost: 150.0
Weapons:
Name: Sword, Damage: 800, Cost: 500.0
2. Sehanine_Moonbow         1    300     750.0       700.0       700.0      2400          8          100.0

Weapons:
Name: Dagger, Damage: 250, Cost: 200.0

Turn 5:
Enter w to move up
Enter a to move left
Enter s to move down
Enter d to move right
Enter q to quit game
Enter i to show information
[INPUT]q
[OUTPUT]Do you want to quit the current game and start a new game?(Y/N)
[INPUT]n
