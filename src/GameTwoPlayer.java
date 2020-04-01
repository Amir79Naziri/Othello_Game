/**
 * this class represents a new Two player game
 *
 * @author Amir Naziri
 * @version 1.0
 */
public class GameTwoPlayer extends Game
{

    /**
     * create a new two player game
     */
    public GameTwoPlayer ()
    {
        super();
    }


    /**
     * play a game
     */
    public void playGame ()
    {
        Reader reader = new Reader ();
        int numOfPassed = 0;
        boolean doublePassed = false;
        while (stopPlay (doublePassed))
        {
            if (getGameHandling ().hasAnySuggestions ())
            {
                getGameHandling ().showMap (true);
                boolean result = getGameHandling ().chooseATaw (reader.readALine ());
                if (result)
                    changeTurn ();
                numOfPassed = 0;
            }
            else
            {
                getGameHandling ().showMap (true);
                System.out.println ("passed");
                numOfPassed++;
                changeTurn ();
            }
            if (numOfPassed >= 2)
                doublePassed = true;
        }
    }

}
