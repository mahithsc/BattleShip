/* BattleShipBoard.java
 * Alex Rabines and Simon Donkor
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
    int button1 = -1;
    int button2 = -1;
    int computerHits = 0;
	int playerHits = 0;
	String shipsStatus;
    // counter variables
    int gameCounter = 1;
    int hitsCounter = 0;
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
    JLabel gameLbl = new JLabel("Games: " + gameCounter);
    JLabel matchLbl = new JLabel("Hits: " + hitsCounter);
    JLabel shipLbl = new JLabel("Sunk: " + hitsCounter);
    JLabel statusLbl = new JLabel(shipsStatus);

    // JButtons
    JButton[][] gameButtons = new JButton[10][10];
    JButton startButton = new JButton("Restart");
    JButton stopButton = new JButton("Stop");

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

        // game Panel (CENTER)
        gamePnl.setBackground(Color.LIGHT_GRAY);
        gamePnl.setLayout(new GridLayout(10,10,2,2));
        // make JButtons
        makeGameButtons();
        // add JButtons
        backgroundPnl.add(gamePnl, BorderLayout.CENTER);

        // score panel (EAST)
        scorePnl.add(startButton);
        scorePnl.add(stopButton);
        scorePnl.add(gameLbl);
        scorePnl.add(matchLbl);
        scorePnl.setLayout(new GridLayout(5,1,2,2));
        backgroundPnl.add(scorePnl, BorderLayout.EAST);

        // Ship status panel (WEST)
        //scorePnl.add(shipLbl);
        shipPnl.setLayout(new GridLayout(5,1,2,2));
        shipPnl.add(statusLbl);
        backgroundPnl.add(shipLbl, BorderLayout.WEST);
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
    
    public void resetBoard() {
        // resetGameButtons
        resetGameButtons();
        // reset all the storage variables
        button1 = -1;
        button2 = -1;
        // add to the gameCounter and reset all the other counters
        gameCounter++;
        gameLbl.setText("Games: " + gameCounter);
        hitsCounter = 0;
        matchLbl.setText("Hits: " + hitsCounter);

    }
    public static void declareShips(Ship[] nameShips, int numberShips){
 		
 	//	int randomShip; // declares the random ship from the arraylist
 		
 		nameShips[0] = new Ship("Patrol Boat", 2, 2);
 		nameShips[1] = new Ship("Submarine", 3, 3);
 		nameShips[2] = new Ship("Destroyer", 3, 3);
 		nameShips[3] = new Ship("Battleship", 4, 4);
 		nameShips[4] = new Ship("Aircraft Carrier", 5, 5);
 		
 	//	for (int i = 0; i<(numberShips - 1); i++){
 	//			randomShip = (int)Math.random() * 4;
 	//			nameShips.add(ships.get(randomShip));
 	//	}
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
        /*if(source == startButton) {
            resetBoard();
        }
        if(source == stopButton) {
            // stop the program
            System.exit(1);
        }*/
    		
    		//if(playerTurn == true){
    			for (int row = 0; row<computerBoard.length; row++) {
  					for (int col = 0; col<computerBoard[0].length; col++) { 
  						if(source == gameButtons[col][row]){
  							if(computerBoard[col][row].equals("/")){
    							computerBoard[col][row] = "hit";
    							System.out.println ("Miss");
    							gameButtons[col][row].setIcon(miss);
    							computerTurn();
    						}
    						else if(computerBoard[col][row].equals("hit")){
    							System.out.println ("Pick another spot");
    						}
    						else{
    							computerBoard[col][row] = "hit";
    							playerHits++;
    							gameButtons[col][row].setIcon(hit);
    							System.out.println ("Hit");
    							System.out.println (playerHits);
    							if(playerHits == 17){
    								System.out.println ("Player Wins");
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
    			System.out.println ("Miss");
    		}
    		else if(playerBoard[yRand][xRand].equals("hit")){
   				computerTurn();
   			}
   			else{
    			computerHits++;
    			System.out.println ("Hit");
    			System.out.println (computerHits);
    			for (int i = 0; i<computerShips.length; i++){
    				if(playerBoard[yRand][xRand].equals(computerShips[i])){
    					computerShips[i].setHitCounter(computerShips[i].getHitCounter() - 1);
    					if(computerShips[i].getHitCounter() == 0){
    						shipsStatus = "The computer sunk your" + computerShips[i].getType();
    					}
    				}
    			}	
    			playerBoard[yRand][xRand] = "hit";
    			if(computerHits == 17){
    				System.out.println ("Computer Wins");
    			}
    			
    		}
   	}
    public static void main(String [] args){
    	BattleShipBoard battleShipBoard = new BattleShipBoard();
    }
} // end class BattleShipBoard