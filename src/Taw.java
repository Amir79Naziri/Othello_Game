public class Taw
{
    private String color;



    public Taw ()
    {
        this.color = "non-color";
    }



    public String getColor () {
        return color;
    }

    public void setColor (String color)
    {
        this.color = color;
    }

    public void printTaw ()
    {
        if (getColor ().equals ("black"))
            System.out.print ('\u25EF');
        if (getColor ().equals ("white"))
            System.out.print ('\u2B24');
        if (getColor ().equals ("dotted"))
            System.out.print ('\u25CC');
        else
            System.out.print (" ");
    }

}
