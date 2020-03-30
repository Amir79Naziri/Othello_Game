public class GameTwoPlayer extends Game
{

    private GameHandling gameHandling;



    public GameTwoPlayer ()
    {
        super();
        gameHandling = new GameHandling (getPlayer1 (),getPlayer2 ());
    }



    public void playGame ()
    {
        Reader reader = new Reader ();
        int numOfPassed = 0;
        boolean doublePassed = false;
        while (stopPlay (doublePassed))
        {
            if (gameHandling.hasAnySuggestions ())
            {
                gameHandling.showMap ();
                boolean result = gameHandling.chooseATaw (reader.readALine ());
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

    public boolean stopPlay (boolean doublePassed)
    {
        gameHandling.pointCalculator ();
        return super.stopPlay (doublePassed);
    }

}
