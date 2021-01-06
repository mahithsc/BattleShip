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
    private int direction; // 0, 1, 2, 3 depending upon the direction which the ship is facing on the board
    
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
    
    // other methods
    
    public int setRandomDirection()
    {
        setDirection(Math.random() * 3);
    }
    //public int setRandomPla
}