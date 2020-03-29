import java.util.Scanner;

public class Reader
{
    private Scanner line;

    public Reader ()
    {
        line = new Scanner (System.in);
    }


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
