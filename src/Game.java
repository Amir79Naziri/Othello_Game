public abstract class Game
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


    public Player getPlayer1 () {
        return player1;
    }

    public Player getPlayer2 () {
        return player2;
    }

    public GameHandling getGameHandling () {
        return gameHandling;
    }


    protected void startPlay ()
    {
        RandomGame randomGame = new RandomGame ();
        randomGame.startRandomGame (player1,player2);
    }

    protected boolean stopPlay (boolean doublePassed)
    {
        gameHandling.pointCalculator ();
        if (player1.getPoints () + player2.getPoints () == 64 || doublePassed ||
                player1.getPoints () == 0 || player2.getPoints () == 0)
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

    protected void changeTurn ()
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

    abstract public void playGame ();
}
