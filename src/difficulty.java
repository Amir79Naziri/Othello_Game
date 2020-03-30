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
        HashMap<Coordinate,Integer> paths = new HashMap<> ();
        for (HashMap<Coordinate,HashSet<Coordinate>> sug : getGameHandling ().suggestions ())
            for (Coordinate key : sug.keySet ())
                for (Coordinate end : sug.get (key))
                    paths.put (end,getGameHandling ().findBegins (end).size ());

    if (difficulty.equals ("Easy"))
        return findLessBegins (paths);
    else
        return findBiggerBegins (paths);
    }

    private  Coordinate findLessBegins (HashMap<Coordinate,Integer> paths)
    {
        int min = 0;
        int counter = 0;
        for (Coordinate end : paths.keySet ()) {
            if (counter == 0)
                min = paths.get (end);
            else if (paths.get (end) < min)
                    min = paths.get (end);
            counter++;
        }

        for (Coordinate end : paths.keySet ())
            if (paths.get (end).equals (min))
                return end;
        return null;
    }

    private Coordinate findBiggerBegins (HashMap<Coordinate,Integer> paths)
    {
        int max = 0;
        int counter = 0;
        for (Coordinate end : paths.keySet ()) {
            if (counter == 0)
                max = paths.get (end);
            else if (paths.get (end) > max)
                max = paths.get (end);
            counter++;
        }

        for (Coordinate end : paths.keySet ())
            if (paths.get (end).equals (max))
                return end;
        return null;
    }

}
