import java.util.Objects;

/**
 * this class is for storing a x and y of a command by changing a command from "I C" to x, y
 *
 * @author Amir Naziri
 * @version 1.0
 */
public class Coordinate
{
    private int x; // X of Coordinate
    private int y; // Y of Coordinate


    /**
     * creates a Coordinate instance with x = -1, y == -1
     */
    public Coordinate ()
    {
        x = -1;
        y = -1;
    }


    /**
     * creates a Coordinate instance with input x, y
     * @param x X of Coordinate
     * @param y Y of Coordinate
     */
    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * sets new value for x, y
     * @param x X of Coordinate
     * @param y Y of Coordinate
     */
    public void setCoordinates (int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Translates a command into x, y
     * @param command input command
     * @return if it was successful return true  OW false
     */
    public boolean translator (String command)
    {
        if (!validCommand (command))
            return false;
        String[] splits = command.trim ().split (" ");
        int y = Integer.parseInt (splits[0]) - 1;
        int x = -1;
        switch (splits[1])
        {
            case "A" : x = 0; break;
            case "B" : x = 1; break;
            case "C" : x = 2; break;
            case "D" : x = 3; break;
            case "E" : x = 4; break;
            case "F" : x = 5; break;
            case "G" : x = 6; break;
            case "H" : x = 7; break;
        }
        setCoordinates (x,y);
        return true;
    }

    /**
     * Translate a x ,y into command
     * @return Command
     */
    public String backTranslator ()
    {
        if (x == -1 || y == -1)
            return null;
        StringBuilder command = new StringBuilder ();
        command.append (y + 1);
        command.append (" ");
        switch (x)
        {
            case 0 : command.append ("A"); break;
            case 1 : command.append ("B"); break;
            case 2 : command.append ("C"); break;
            case 3 : command.append ("D"); break;
            case 4 : command.append ("E"); break;
            case 5 : command.append ("F"); break;
            case 6 : command.append ("G"); break;
            case 7 : command.append ("H"); break;
        }
        return command.toString ();
    }

    /**
     * is input command valid or not ?
     * @param command input command
     * @return if valid returns true   else return false
     */
    private boolean validCommand (String command)
    {
        // command is in format of I C  I is number between 1 , 8 and C is A , H
        if (command != null) {

            char[] parts = command.trim ().toCharArray ();
            if (parts.length != 3)
                return false;
            if (parts[0] != '1' && parts[0] != '2' && parts[0] != '3' && parts[0] != '4' &&
                    parts[0] != '5' && parts[0] != '6' && parts[0] != '7' && parts[0] != '8')
                return false;
            if (parts[1] != ' ')
                return false;
            return parts[2] == 'A' || parts[2] == 'B' || parts[2] == 'C' || parts[2] == 'D' ||
                    parts[2] == 'E' || parts[2] == 'F' || parts[2] == 'G' || parts[2] == 'H';
        }
        else return false;
    }

    /**
     * @return X of Coordination
     */
    public int getX () {
        return x;
    }

    /**
     * @return Y of Coordination
     */
    public int getY () {
        return y;
    }

    /**
     * checks equality of two Coordination by checking x and y
     * @param o input object
     * @return result of equality
     */
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    /**
     * @return hashCode for Coordination
     */
    @Override
    public int hashCode () {
        return Objects.hash (x, y);
    }
}
