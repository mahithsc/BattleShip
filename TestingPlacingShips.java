/* TestingPlacingShips.java
 * Brendan Galvin
 * Mr.Blondin
 * Java II - Graphics
 * 1/6/21
 */
 import java.util.ArrayList;
 
 public class TestingPlacingShips {
 	public static void main(String [] args){
 		final int NUMBER_OF_SHIPS = 5;
 		
 		Ship[] playerShips = new Ship[NUMBER_OF_SHIPS];
 		Ship[] computerShips = new Ship[NUMBER_OF_SHIPS];
 	
 		String [][] computerBoard = new String[10][10];
 		String [][] playerBoard = new String[10][10];
 		
 		declareShips(playerShips, NUMBER_OF_SHIPS);
 		declareShips(computerShips, NUMBER_OF_SHIPS);
 		declareBoardArray(playerBoard);
 		declareBoardArray(computerBoard);
 		placeManyShips(playerShips, playerBoard);
 		placeManyShips(computerShips, computerBoard);
 		//outputArray(playerBoard);
 		//outputArray(computerBoard);
 	}
 	public static void declareShips(Ship[] nameShips, int numberShips){
 	//	ArrayList<Ship> ships = new ArrayList<Ship>();
 		
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
 				//System.out.print ("Checking>>>");
 				//System.out.print (" " + x);
 				//System.out.println (" " + y);
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
 				//System.out.print ("Checking>>>");
 				//System.out.print (" " + x);
 				//System.out.println (" " + y);
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
 				//System.out.print ("Checking>>>");
 				//System.out.print (" " + x);
 				//System.out.println (" " + y);
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
 				//System.out.print ("Checking>>>");
 				//System.out.print (" " + x);
 				//System.out.println (" " + y);
 				}
 			}
 		}
 	}
 	public static void outputArray(String [][] board){
 		for (int row = 0; row<board.length; row++) {
  			for (int col = 0; col<board[0].length; col++) { 
  				System.out.print (board[row][col] + " ");
  			}
  			System.out.println ();
  		}
 	}
 }