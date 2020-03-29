public class Game
{
    private Player player1;
    private Player player2;
    private GameHandling gameHandling;



    public Game ()
    {
        player1 = new Player ();
        player2 = new Player ();
        startPlay ();
        gameHandling = new GameHandling (player1,player2);
    }


    private void startPlay ()
    {
        RandomGame randomGame = new RandomGame ();
        randomGame.startRandomGame (player1,player2);
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

    private boolean stopPlay (boolean doublePassed)
    {
        gameHandling.pointCalculator ();

        if (player1.getPoints () + player2.getPoints () == 64 || doublePassed)
        {
            if (player1.getPoints () > player2.getPoints ())
            {
                System.out.println ("player1 Won");
            }
            if (player1.getPoints () < player2.getPoints ())
            {
                System.out.println ("player2 Won");
            }
            else
            {
                System.out.println ("Draw");
            }
            return false;
        }
        return true;
    }

    private void changeTurn ()
    {
        if (player1.isTurn ())
        {
            player1.doneTurn ();
            player2.makeTurn ();
        }
        else
        {
            player2.doneTurn ();
            player1.makeTurn ();
        }
    }
}
