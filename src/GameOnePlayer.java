/**
 * this class represents a one player Game
 *
 * @author Amir Naziri
 * @version 1.0
 */
public class GameOnePlayer extends difficulty
{

    /**
     * creates a new One player Game
     * @param difficulty input difficulty Easy or Hard
     */
    public GameOnePlayer (String difficulty)
    {
        super(difficulty);
    }


    /**
     * starts a new play with choosing color of players and who is machine
     */
    public void startPlay ()
    {
        RandomGame randomGame = new RandomGame ();
        randomGame.startRandomGameWithMachine (getPlayer1 (),getPlayer2 ());
    }

    /**
     * play Game
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
                getGameHandling ().showMap ();
                if (getPlayer1 ().isTurn ())
                {
                    if (getPlayer1 ().isMachine ())
                    {
                        Coordinate end = chooseEndForMachine ();
                        System.out.println ();
                        System.out.println (end.backTranslator ());
                        boolean result = getGameHandling ().chooseATaw (end);
                        if (result)
                            changeTurn ();
                    }
                    else
                    {
                        boolean result = getGameHandling ().chooseATaw (reader.readALine ());
                        if (result)
                            changeTurn ();
                    }
                }
                else
                {
                    if (getPlayer2 ().isMachine ())
                    {
                        Coordinate end = chooseEndForMachine ();
                        System.out.println ();
                        System.out.println (end.backTranslator ());
                        boolean result = getGameHandling ().chooseATaw (end);
                        if (result)
                            changeTurn ();
                    }
                    else
                    {
                        boolean result = getGameHandling ().chooseATaw (reader.readALine ());
                        if (result)
                            changeTurn ();
                    }
                }
                numOfPassed = 0;
            }
            else
            {
                System.out.println ("passed");
                numOfPassed++;
                changeTurn ();
            }
            if (numOfPassed >= 2)
                doublePassed = true;
        }
    }
}
