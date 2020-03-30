import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public abstract class difficulty extends Game
{
    private String difficulty;


    public difficulty (String difficulty)
    {
        super();
        this.difficulty = difficulty;
    }


    abstract public void playGame ();

    public String chooseCommandForMachine (HashSet<HashMap<Coordinate, HashSet<Coordinate>>> suggestions,
                                         String difficulty)
    {
        HashMap<Coordinate,Integer> paths = new HashMap<> ();
        for (HashMap<Coordinate,HashSet<Coordinate>> sug : suggestions)
            for (Coordinate key : sug.keySet ())
                for (Coordinate end : sug.get (key))
                    paths.put (end,getGameHandling ().findBegins (end).size ());


    }

    public Coordinate findLessBegins (HashMap<Coordinate,Integer> paths)
    {
        int min = 0;
        int counter = 0;
        for (Coordinate end : paths.keySet ())
        {
            if (counter == 0)
                min = paths.get (end);
            else
            {
                if (paths.get (end) < min)
                    min = paths.get (end);
            }
            counter++;
        }
    }

}
