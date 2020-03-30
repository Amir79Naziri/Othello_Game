public class GameOnePlayer extends difficulty
{

    public GameOnePlayer (String difficulty)
    {
        super(difficulty);
    }


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
                    if (getPlayer1 ().isMachine)
                    {
                        boolean result = getGameHandling ().chooseATaw (chooseEndForMachine ());
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
                if (getPlayer2 ().isTurn ())
                {
                    if (getPlayer2 ().isMachine)
                    {
                        boolean result = getGameHandling ().chooseATaw (chooseEndForMachine ());
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
