/* BattleShipBoard.java
 * Alex Rabines, Simon Donkor, Brendan Galvin and Mahith Chitrapu
 * Java II Programming
 * Mr. Blondin
 * 1/7/2021
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class BattleShipBoard
    extends JFrame implements ActionListener{
    	
    final int NUMBER_OF_SHIPS = 5;
   	
   	Ship[] playerShips = new Ship[NUMBER_OF_SHIPS];
 	Ship[] computerShips = new Ship[NUMBER_OF_SHIPS];
 	
 	String [][] computerBoard = new String[10][10];
 	String [][] playerBoard = new String[10][10];
	
    // storage variables
    int computerHits = 0;
	int playerHits = 0;
	String shipsStatus;
	int hits = 0;
	int matches = 0;
    // JPanels
    JPanel backgroundPnl = new JPanel ();
    JPanel titlePnl = new JPanel ();
    JPanel messagePnl = new JPanel ();
    JPanel gamePnl = new JPanel ();
    JPanel scorePnl = new JPanel ();
    JPanel shipPnl = new JPanel ();
    JPanel[][] playerPnl = new JPanel[10][10];

    // JLabels
    JLabel titleLbl = new JLabel("BattleShip");
    JLabel messageLbl = new JLabel("Can you sink all the ships?");
    JLabel statusLbl = new JLabel("Welcome to Battleship!");
    JLabel battleShipLbl = new JLabel("Your Battleship is Alive");
    JLabel patrolBoatLbl = new JLabel("Your Patrol Boat is Alive");
    JLabel submarineLbl = new JLabel("Your Submarine is Alive");
    JLabel aircraftCarrierLbl = new JLabel("Your Aircraft Carrier is Alive");
    JLabel destroyerLbl = new JLabel("Your Destroyer is Alive");
    JLabel hitsLbl = new JLabel("Hits: " + hits);
    JLabel matchesLbl = new JLabel("Matches: " + matches);

    // JButtons
    JButton[][] gameButtons = new JButton[10][10];
    JButton startButton = new JButton("Restart");
    JButton stopButton = new JButton("Exit");

    // image icons
    ImageIcon blank = new ImageIcon("blank.gif");
    ImageIcon hit = new ImageIcon("hit.gif");
    ImageIcon miss = new ImageIcon("miss.gif");

    // constructor
    public BattleShipBoard() {
    	super("BattleShip");
    	declareShips(playerShips, NUMBER_OF_SHIPS);
 		declareShips(computerShips, NUMBER_OF_SHIPS);
 		declareBoardArray(playerBoard);
 		declareBoardArray(computerBoard);
 		placeManyShips(playerShips, playerBoard);
 		placeManyShips(computerShips, computerBoard);
    	
        setSize(1500, 800);
        
        // add ActionListener to the start and stop buttons
        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        backgroundPnl.setLayout(new BorderLayout());

        // title Panel (NORTH)
        titlePnl.setBackground(Color.LIGHT_GRAY);
        titlePnl.add(titleLbl);
        backgroundPnl.add(titlePnl, BorderLayout.NORTH);

        // message Panel (SOUTH)
        messagePnl.setBackground(Color.LIGHT_GRAY);
        messagePnl.add(messageLbl);
        backgroundPnl.add(messagePnl, BorderLayout.SOUTH);

		// score Panel (EAST)
		scorePnl.setBackground(Color.LIGHT_GRAY);
		scorePnl.setLayout(new GridLayout (5,1,2,2));
		scorePnl.add(startButton);
		scorePnl.add(stopButton);
		scorePnl.add(matchesLbl);
		scorePnl.add(hitsLbl);
		backgroundPnl.add(scorePnl, BorderLayout.EAST);

        // game Panel (CENTER)
        gamePnl.setBackground(Color.LIGHT_GRAY);
        gamePnl.setLayout(new GridLayout(10,10,2,2));
        // make JButtons
        makeGameButtons();
        // add JButtons
        backgroundPnl.add(gamePnl, BorderLayout.CENTER);

        // Ship status panel (WEST)
        shipPnl.setBackground(Color.LIGHT_GRAY);
        shipPnl.setLayout(new GridLayout(6,1,2,2));
        shipPnl.add(statusLbl);
        shipPnl.add(patrolBoatLbl);
        shipPnl.add(submarineLbl);
        shipPnl.add(destroyerLbl);
        shipPnl.add(battleShipLbl);
        shipPnl.add(aircraftCarrierLbl);
        backgroundPnl.add(shipPnl, BorderLayout.WEST);
        // add the backgroundPnl
        add(backgroundPnl);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        	
        }

    public void makeGameButtons() {
    	for (int row = 0; row<gameButtons.length; row++) {
  			for (int col = 0; col<gameButtons[0].length; col++) { 
  				// put the original image on all the buttons
            	gameButtons[row][col] = new JButton(blank);
            	// add ActionListener to the buttons
            	gameButtons[row][col].addActionListener(this);
            	gamePnl.add(gameButtons[row][col]);
  			}
  		}     
    }

    public void resetGameButtons() {
        for (int row = 0; row<gameButtons.length; row++) {
  			for (int col = 0; col<gameButtons[0].length; col++) { 
  				gameButtons[row][col].setIcon(blank);
            	gameButtons[row][col].setEnabled(true);
  			}
  		}     
    }
    public static void declareShips(Ship[] nameShips, int numberShips){
 		
 		nameShips[0] = new Ship("Patrol Boat", 2, 2);
 		nameShips[1] = new Ship("Submarine", 3, 3);
 		nameShips[2] = new Ship("Destroyer", 3, 3);
 		nameShips[3] = new Ship("Battleship", 4, 4);
 		nameShips[4] = new Ship("Aircraft Carrier", 5, 5);
	}
 	public static void declareBoardArray(String [][] boardArray){
 		for (int row = 0; row<boardArray.length; row++) {
  			for (int col = 0; col<boardArray[0].length; col++) { 
  				boardArray[row][col] = "/";
  			}
  		}
 	}
 	
 	public static void placeManyShips(Ship [] s, String [][] board){
 		for (int i = 0; i<s.length; i++){
 			placeShipTest(s[i], board);
 		}
 	}
    public static void placeShipTest(Ship s, String [][] board){
 	
 		s.setDirection(s.getRandomDirection());
 		int x = s.getRandomCoordinate();
 		int y = s.getRandomCoordinate();
 		int xb = x;
 		int yb = y;
 		int test = 0;
 		int counter = 0;
 		
 		while(test == 0){
 			if(s.getDirection() == 0){
 				if(y - s.getLength() >= 0){
 						for (int i = 0; i<s.getLength(); i++){
 							if(board[y][x].equals("/")){
 								y--;
 								counter++;
 								if(counter == s.getLength()){
 									for(int length = s.getLength(); length > 0; length--){
 										yb--;
 										board[yb][xb] = s.getType();
 									}
 									test = 1;
 									counter = 0;
 								}
 							}
 							else{
 								x = s.getRandomCoordinate();
 								y = s.getRandomCoordinate();
 								xb = x;
 								yb = y;
 								counter = 0;
 								break;
 							}
 						}
 					}
 				else{
 				x = s.getRandomCoordinate();
 				y = s.getRandomCoordinate();
 				xb = x;
 				yb = y;
 				}
 			}
 			if(s.getDirection() == 1){
 				if(x + s.getLength() <= 9){
 						for (int i = 0; i<s.getLength(); i++){
 							if(board[y][x].equals("/")){
 								x++;
 								counter++;
 								if(counter == s.getLength()){
 									for(int length = s.getLength(); length > 0; length--){
 										xb++;
 										board[yb][xb] = s.getType();
 									}
 									test = 1;
 									counter = 0;
 								}
 							}
 							else{
 								x = s.getRandomCoordinate();
 								y = s.getRandomCoordinate();
 								xb = x;
 								yb = y;
 								counter = 0;
 								break;
 							}
 						}
 					}
 				else{
 				x = s.getRandomCoordinate();
 				y = s.getRandomCoordinate();
 				xb = x;
 				yb = y;
 				}
 			}
 			if(s.getDirection() == 2){
 				if(y + s.getLength() <= 9){
 						for (int i = 0; i<s.getLength(); i++){
 							if(board[y][x].equals("/")){
 								y++;
 								counter++;
 								if(counter == s.getLength()){
 									for(int length = s.getLength(); length > 0; length--){
 										yb++;
 										board[yb][xb] = s.getType();
 									}
 									test = 1;
 									counter = 0;
 								}
 							}
 							else{
 								x = s.getRandomCoordinate();
 								y = s.getRandomCoordinate();
 								xb = x;
 								yb = y;
 								counter = 0;
 								break;
 						}
 					}
 					}
 				else{
 				x = s.getRandomCoordinate();
 				y = s.getRandomCoordinate();
 				xb = x;
 				yb = y;
 				}
 			}
 			if(s.getDirection() == 3){
 				if(x - s.getLength() >= 0){
 						for (int i = 0; i<s.getLength(); i++){
 							if(board[y][x].equals("/")){
 								x--;
 								counter++;
 								if(counter == s.getLength()){
 									for(int length = s.getLength(); length > 0; length--){
 										xb--;
 										board[yb][xb] = s.getType();
 									}
 									test = 1;
 									counter = 0;
 								}
 							}
 							else{
 								x = s.getRandomCoordinate();
 								y = s.getRandomCoordinate();
 								xb = x;
 								yb = y;
 								counter = 0;
 								break;
 						}
 					}
 					}
 				else{
 				x = s.getRandomCoordinate();
 				y = s.getRandomCoordinate();
 				xb = x;
 				yb = y;
 				}
 			}
 		}
 	}

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        // check if the source is start or start
        if(source == startButton) {
            resetGame();
        }
        if(source == stopButton) {
            // stop the program
            System.exit(1);
        }
    		
    		//if(playerTurn == true){
    			for (int row = 0; row<computerBoard.length; row++) {
  					for (int col = 0; col<computerBoard[0].length; col++) { 
  						if(source == gameButtons[col][row]){
  							if(computerBoard[col][row].equals("/")){
    							computerBoard[col][row] = "hit";
    							System.out.println ("Miss P");
    							gameButtons[col][row].setIcon(miss);
    							computerTurn();
    						}
    						else if(computerBoard[col][row].equals("hit")){
    							System.out.println ("Pick another spot");
    							statusLbl.setText("Pick another spot!");
    							
    						}
    						else if(!computerBoard[col][row].equals("miss")){
    							gameButtons[col][row].setIcon(hit);
    							for (int i = 0; i<computerShips.length; i++){
    								if(computerBoard[col][row].equals(computerShips[i].getType())){
    									playerHits++;
    									hits += 1;
    									hitsLbl.setText("Hits: " + hits);
    								}
    							}
    							computerBoard[col][row] = "hit";
    							System.out.println ("Hit P");
    							System.out.println (playerHits);
    							if(playerHits == 17){
    								System.out.println ("Player Wins");
    								endGame("You Won!");
    							}
    							computerTurn();
    						}
  						}
  					}  
    			}
    }
	public void computerTurn(){
		
			int xRand = (int)(Math.random() * 10);
    		int yRand = (int)(Math.random() * 10);
		
    		if(playerBoard[yRand][xRand].equals("/")){
    			playerBoard[yRand][xRand] = "miss";
    			System.out.println ("Miss C");
    		}
    		else if(playerBoard[yRand][xRand].equals("hit")){
   				computerTurn();
   			}
   			else if(!playerBoard[yRand][xRand].equals("miss")){
    			
    			System.out.println ("Hit C");
    			System.out.println (computerHits);
    			shipsStatus = "The Computer Hit Your " + playerBoard[yRand][xRand];
    			statusLbl.setText(shipsStatus);
    			for (int i = 0; i<playerShips.length; i++){
    				if(playerBoard[yRand][xRand].equals(playerShips[i].getType())){
    					playerShips[i].setHitCounter(playerShips[i].getHitCounter() - 1);
    					computerHits++;
    					if(playerShips[i].getHitCounter() == 0){
    						shipsStatus = "The Computer Sunk Your " + playerShips[i].getType();
    						statusLbl.setText(shipsStatus);
    						if(playerShips[i].getType().equals("Battleship")){
  								battleShipLbl.setText("Your Battleship Is Sunk");
    						}
    						else if(playerShips[i].getType().equals("Aircraft Carrier")){
  								aircraftCarrierLbl.setText("Your Aircraft Carrier Is Sunk");
    						}
    						else if(playerShips[i].getType().equals("Patrol Boat")){
  								patrolBoatLbl.setText("Your Patrol Boat Is Sunk");
    						}
    						else if(playerShips[i].getType().equals("Submarine")){
  								submarineLbl.setText("Your Submarine Is Sunk");
    						}
    						else if(playerShips[i].getType().equals("Destroyer")){
  								destroyerLbl.setText("Your Destroyer Is Sunk");
    						}
    					}
    				}
    			}
    			
    			playerBoard[yRand][xRand] = "hit";
    			if(computerHits == 17){
    				System.out.println ("Computer Wins");
    				endGame("The Computer Won!");
    			}
    		}
   	}
   	public void resetGame(){
   		declareBoardArray(playerBoard);
 		declareBoardArray(computerBoard);
 		placeManyShips(playerShips, playerBoard);
 		placeManyShips(computerShips, computerBoard);
   		resetGameButtons();
   		statusLbl.setText("Welcome to Battleship!");
   		computerHits = 0;
		playerHits = 0;
		matches += 1;
		hits = 0;
		matchesLbl.setText("Matches: " + matches);
		hitsLbl.setText("Hits: " + hits);
		
   	}
   	public void endGame(String text){
   		for (int row = 0; row<gameButtons.length; row++) {
  			for (int col = 0; col<gameButtons[0].length; col++) { 
            	gameButtons[row][col].setEnabled(false);
  			}
  		} 
  		statusLbl.setText("Gameover: " + text); 
  		aircraftCarrierLbl.setText("Your Aicraft Carrier is Alive");
  		aircraftCarrierLbl.setText("Your Submarine is Alive");
  		aircraftCarrierLbl.setText("Your Patrol Boat is Alive");
  		aircraftCarrierLbl.setText("Your Battleship is Alive");
  		aircraftCarrierLbl.setText("Your Destroyer is Alive");
   	}
    public static void main(String [] args){
    	BattleShipBoard battleShipBoard = new BattleShipBoard();
    } // end main method
} // end class BattleShipBoard