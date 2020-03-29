public class Player
{
    private boolean turn;
    private String tawColor;
    private int points;

    public Player ()
    {
        this.tawColor = "non-color";
        turn = false;
        points = 0;
    }

    public void setTawColor (String color)
    {
        tawColor = color;
    }

    public boolean isTurn () {
        return turn;
    }

    public String getTawColor () {
        return tawColor;
    }

    public void doneTurn ()
    {
        this.turn = false;
    }

    public void makeTurn ()
    {
         this.turn = true;
    }

    public void setPoints (int points)
    {
        this.points = points;
    }

    public int getPoints () {
        return points;
    }
}
