/* Ship.java
 * Brendan Galvin
 * Mr.Blondin
 * Java II - Graphics
 * 1/4/21
 */
 public class Ship {
 	
 	private int player; // 1 for player, 0 for computer
 	private String type; // type of ship
 	private int length; // length of ship depending upon type
 	private int positionX; // position of ship on the board
 	private int positionY;
 	private int hitCounter; // hits the ship has taken
 	private int totalHits; // total amount of hits each ship can take
 	private int randomCoordinate;
 	private int randomDirection;
 	private int direction; // 0, 1, 2, 3 depending upon the direction which the ship is facing on the board
 	// Directions for the ship:
 	//   0
 	// 3   1
 	//   2
 	
 	public Ship(String type, int length, int totalHits) {
 		this.type = type;
 		this.length = length;
 		this.totalHits = totalHits;
 	}
 	
 	public void setPlayer(int pr)
 	{
 		player = pr;
 	}
 	public int getPlayer()
 	{
 		return player;
 	}
 	
 	public void setType(String tp)
 	{
 		type = tp;
 	}
 	public String getType()
 	{
 		return type;
 	}
 	public void setLength(int lt)
 	{
 		length = lt;
 	}
 	public int getLength()
 	{
 		return length;
 	}
 	
 	public void setPositionX(int px)
 	{
 		positionX = px;
 	}
 	
 	public int getPositionX()
 	{
 		return positionX;
 	}
 	
 	public void setPositionY(int py)
 	{
 		positionY = py;
 	}
 	
 	public int getPositionY()
 	{
 		return positionY;
 	}
 	
 	public void setHitCounter(int hc)
 	{
 		hitCounter = hc;
 	}
 	
 	public int getHitCounter()
 	{
 		return hitCounter;
 	}
 	
 	public void setTotalHits(int th)
 	{
 		totalHits = th;
 	}
 	
 	public int getTotalHits()
 	{
 		return totalHits;
 	}
 	
 	public void setDirection(int dr)
 	{
 		direction = dr;
 	}
 	
 	public int getDirection()
 	{
 		return direction;
 	}
 	public int getRandomCoordinate(){
 		randomCoordinate = (int)Math.random() * 9;
 		return randomCoordinate;
 	}
 	public int getRandomDirection(){
 		randomDirection = (int)Math.random() * 3;
 		return randomDirection;
 	}
 }