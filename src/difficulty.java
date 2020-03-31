import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * this class is for having difficultyLevel in onePlayer game
 *
 * @author Amir Naziri
 * @version 1.0
 */
public abstract class difficulty extends Game
{
    private String difficulty; // type of difficulty Easy or Hard


    /**
     * creates a new difficulty instance
     * @param difficulty input difficulty Easy or Hard
     */
    public difficulty (String difficulty)
    {
        super();
        this.difficulty = difficulty;
    }


    /**
     * play Game
     */
    abstract public void playGame ();

    /**
     * finds the chosen Taw coordination related to difficulty
     * @return Coordinate of chosen Taw
     */
    public Coordinate chooseEndForMachine ()
    {
        HashMap<Coordinate, Integer> mapOfEndToLength = new HashMap<> ();
        for (HashMap<Coordinate, HashSet<Coordinate>> sug : getGameHandling ().suggestions ())
            for (Coordinate key : sug.keySet ())
                for (Coordinate end : sug.get (key)) {
                    mapOfEndToLength.put (end, findLength (end, getGameHandling ().findBegins (end)));
                }
        if (difficulty.equals ("Easy"))
            return findLessLength (mapOfEndToLength);
        else
            return findBiggerLength (mapOfEndToLength);
    }

    /**
     * finds the minimum of number of taw in path of one end to begins
     * @param mapOfEndToLength map of ends to number of taws to begins
     * @return coordinate of end which has less number of taws to it's begins
     */
    private  Coordinate findLessLength (HashMap<Coordinate,Integer> mapOfEndToLength)
    {
        int min = Collections.min (mapOfEndToLength.values ());
        for (Coordinate end : mapOfEndToLength.keySet ())
            if (mapOfEndToLength.get (end).equals (min))
                return end;
        return null;
    }

    /**
     * finds the maximum of number of taw in path of one end to begins
     * @param mapOfEndToLength map of ends to number of taws to begins
     * @return coordinate of end which has more number of taws to it's begins
     */
    private Coordinate findBiggerLength (HashMap<Coordinate,Integer> mapOfEndToLength)
    {
        int max = Collections.max (mapOfEndToLength.values ());
        for (Coordinate end : mapOfEndToLength.keySet ())
            if (mapOfEndToLength.get (end).equals (max))
                return end;
        return null;
    }

    /**
     * find the number of taws in path of end to it's begins
     * @param end chosen end
     * @param begins set of begins
     * @return number of Taws
     */
    private int findLength (Coordinate end, HashSet<Coordinate> begins)
    {
        int sum = 0;
        for (Coordinate begin : begins)
        {
            int x = Math.abs (end.getX () - begin.getX ());
            int y = Math.abs (end.getY () - begin.getY ());

            if (x == 0)
                sum += y;
            else
                sum += x;
        }
        return sum;
    }
}
