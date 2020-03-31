import java.util.Scanner;

/**
 * this class is for reading from console
 *
 * @author Amir Naziri
 * @version 1.0
 */
public class Reader
{
    private Scanner line;


    /**
     * creates a new Reader instance
     */
    public Reader ()
    {
        line = new Scanner (System.in);
    }


    /**
     * read a line a change command to Coordinate
     * @return Coordinate of Choosing Taw
     */
    public Coordinate readALine ()
    {
        System.out.println ("Enter Command : ");
        String command = line.nextLine ();
        Coordinate coordinate = new Coordinate ();
        if (coordinate.translator (command))
            return coordinate;
        else
            return readALine ();
    }

}
