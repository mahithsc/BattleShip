# BattleShip

Rabines: Scribe
Brendan Galvin: Main Programmer
Mahith: Second Programmer
Simon Donkor: Project Manager

Preliminary Thoughts:
How to place the Ships,
math.random() function to the orient of the ships
Use random locations and use if statements to see whether or not the ship would fit.
Starting out with writing all the values and the easy mode before progressing on the creation of the medium and hard mode( ex. 10 x 10, 15 x 15, 20 x 20)
We need to create an object for ship
Has a length, hit counter, name, position
Placing the ships




Panels
West: ship status
East: Hit, miss, start
North: Title/gif of the battleship
Ship Class
	Methods:
Length
Name

Alex
Crew log: Stardate 121620
We discussed using an array to store the ships for use on the board, as well as using an out of bounds check, other requirements would be ensuring all ships are used, and that they occupy the proper amount of space, for placement using the random, must ensure that the ship is not improperly placed i.e all parts of the ship are together on the same column/row. Pick either the first or last piece of the ship and randomly orientate the rest of it linearly in one of the four cardinal directions to prevent misplacement. To create an easy level board we must create a textbox populated with 100 buttons labeled (A-J)(1-10). Using gifs as the buttons for the mainboard. Panels for hits, misses, and other info.

Alex
Crew log: Stardate 010421
Began coding the easy board(Simon and I) and the battleships(Mahith and Brendan). On the grid, the buttons will have properties that are visible(When shot at Hit/Miss) and invisible(Occupied or not by a ship). Battleship objects appear to be complete for potential use on the board at present.

Simon
Crew log:
We began programming the ship’s main functionalities and Brendan began the development of the math.random for ship placements and limits. We have also developed all types of ships from light cruisers like patrol boats to battleships themselves.  

Alex
Crew Log: 1/7/21
Simon and I continued working on the board layout and graphical design. 
Mahith and Brendan were working on the logic of the placing the ships and declaring the array to store the positions of the computer and the players ships in addition to starting the actual logic of seeing if the placed ships would overlap when placed. They wrote the methods for generating random coordinates and orientations for the ships in order to place them in random order on the board, and if the ship overlaps then it will regenerate the placement and the orientation until it finds a valid position.

Alex
Crew Log: 1/12/21
We all began consolidating separate classes into coherent projects to be used in the final submission. We also worked out a few bugs on the respective programs to ensure a smooth transition.

Alex
Crew Log: 1/13/21
Simon and I were working on matching the images we chose for the board with the actions they were chosen to represent, but eventually faced minor bugs and other issues that will be addressed tomorrow after the school day in full.

Alex
Crew Log: 1/15/21
Continued integration work group-wide. Worked out more bugs and compatibility errors.

Alex
Crew Log: 1/19/21
Finished adding ship placement logic to the board. The group also picked out images to use on the board for different situations, i.e. still water/hit ship/ missed ship.

Alex
Crew Log: 1/20/21
Put finishing touches on the fully merged project. Notable mentions include implementing the images chosen for the board, i.e. still/hit/miss.
