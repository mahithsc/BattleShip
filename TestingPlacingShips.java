/* TestingPlacingShips.java
 * Brendan Galvin
 * Mr.Blondin
 * Java II - Graphics
 * 1/6/21
 */
 import java.util.ArrayList;
 
 public class TestingPlacingShips {
 	
 	public static void main(String [] args){
 	
 	
 	ArrayList<Ship> playerShips = new ArrayList<Ship>();
 	ArrayList<Ship> computerShips = new ArrayList<Ship>();
 	
 	}
 	public static void declareShips(int player){
 		ArrayList<Ship> ships = new ArrayList<Ship>();
 	
 		ships.add(new Ship("Patrol Boat", 2, 2));
 		ships.add(new Ship("Submarine", 3, 3));
 		ships.add(new Ship("Destroyer", 3, 3));
 		ships.add(new Ship("Battleship", 4, 4));
 		ships.add(new Ship("Aircraft Carrier", 5, 5));
 		
 		int randomShip;
 		
 		if(player == 1){
 			for (int i = 0; i<ships.size(); i++){
 				randomShip = Math.random() * 4;
 				playerShips.add(ships.get(randomShip));
 			}
 		}
 		else{
 			
 		}
 		
    }
 	
 }
 	