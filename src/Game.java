public abstract class Game
{
    private Player player1;
    private Player player2;


    public Game ()
    {
        player1 = new Player ();
        player2 = new Player ();
        startPlay ();
    }

    public Player getPlayer1 () {
        return player1;
    }

    public Player getPlayer2 () {
        return player2;
    }

    protected void startPlay ()
    {
        RandomGame randomGame = new RandomGame ();
        randomGame.startRandomGame (player1,player2);
    }


    protected boolean stopPlay (boolean doublePassed)
    {

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
