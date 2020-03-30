import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public abstract class difficulty extends Game
{
    private String difficulty;


    public difficulty (String difficulty)
    {
        super();
        this.difficulty = difficulty;
    }


    abstract public void playGame ();


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

    private  Coordinate findLessLength (HashMap<Coordinate,Integer> mapOfEndToNumOfBegins)
    {
        int min = Collections.min (mapOfEndToNumOfBegins.values ());
        for (Coordinate end : mapOfEndToNumOfBegins.keySet ())
            if (mapOfEndToNumOfBegins.get (end).equals (min))
                return end;
        return null;
    }

    private Coordinate findBiggerLength (HashMap<Coordinate,Integer> mapOfEndToNumOfBegins)
    {
        int max = Collections.max (mapOfEndToNumOfBegins.values ());
        for (Coordinate end : mapOfEndToNumOfBegins.keySet ())
            if (mapOfEndToNumOfBegins.get (end).equals (max))
                return end;
        return null;
    }

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
