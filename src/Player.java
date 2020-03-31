/**
 * this class represents a Player
 *
 * @author Amir Naziri
 * @version 1.0
 */
public class Player
{
    private boolean turn; // is turn
    private String tawColor; // taw color
    private int points; // points
    boolean isMachine; // is machine player


    /**
     * creates a new Player
     */
    public Player ()
    {
        this.tawColor = "non-color";
        turn = false;
        points = 0;
        isMachine = false;
    }


    /**
     * sets a color for Player
     * @param color input Color
     */
    public void setTawColor (String color)
    {
        tawColor = color;
    }

    /**
     * @return isTurn of Player
     */
    public boolean isTurn () {
        return turn;
    }

    /**
     * @return taw color of a player
     */
    public String getTawColor () {
        return tawColor;
    }

    /**
     * done it's turn
     */
    public void doneTurn ()
    {
        this.turn = false;
    }

    /**
     * now it's turn
     */
    public void makeTurn ()
    {
         this.turn = true;
    }

    /**
     * sets point
     * @param points input point
     */
    public void setPoints (int points)
    {
        this.points = points;
    }

    /**
     * @return points of Player
     */
    public int getPoints () {
        return points;
    }

    /**
     * @return is player Machine
     */
    public boolean isMachine () {
        return isMachine;
    }

    /**
     * make player a Machine
     */
    public void changeToMachine ()
    {
        isMachine = true;
    }
}
