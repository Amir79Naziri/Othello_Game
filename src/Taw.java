/**
 * this class represents a taw
 *
 * @author Amir Naziri
 * @version 1.0
 */
public class Taw
{
    private String color; // color of Taw


    /**
     * creates a new Taw
     */
    public Taw ()
    {
        this.color = "non-color";
    }


    /**
     * @return color of taw
     */
    public String getColor () {
        return color;
    }

    /**
     * sets color for Taw
     * @param color color
     */
    public void setColor (String color)
    {
        this.color = color;
    }

    /**
     * prints a Taw on console
     */
    public void printTaw ()
    {
        if (getColor ().equals ("black"))
            System.out.print ('\u26AA');
        if (getColor ().equals ("white"))
            System.out.print ('\u26AB');
        if (getColor ().equals ("dotted"))
            System.out.print ('\u25CC');
        else
            System.out.print (" ");
    }

}
