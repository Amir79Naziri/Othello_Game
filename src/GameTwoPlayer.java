public class GameTwoPlayer extends difficulty
{

    public GameTwoPlayer (String difficulty)
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
                boolean result = getGameHandling ().chooseATaw (reader.readALine ());
                if (result)
                    changeTurn ();
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
