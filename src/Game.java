/**
 * this class is for implementing the game process such as start and finishing a game
 *
 * @author Amir Naziri
 * @version 1.0
 */
public abstract class Game
{
    private Player player1; // player 1
    private Player player2; // player 2
    private GameHandling gameHandling; // Game Handler


    /**
     * creates a new Game
     */
    public Game ()
    {
        player1 = new Player ();
        player2 = new Player ();
        startPlay ();
        gameHandling = new GameHandling (player1,player2);
    }


    /**
     * @return player1
     */
    public Player getPlayer1 () {
        return player1;
    }

    /**
     * @return player2
     */
    public Player getPlayer2 () {
        return player2;
    }

    /**
     * @return gameHandler
     */
    public GameHandling getGameHandling () {
        return gameHandling;
    }

    /**
     * starts a play with choosing turn and color for each player randomly
     */
    public void startPlay ()
    {
        RandomGame randomGame = new RandomGame ();
        randomGame.startRandomGame (player1,player2);
    }

    /**
     * checks conditions for finishing the program
     * @param doublePassed is seen double pass
     * @return can program continues ?
     */
    public boolean stopPlay (boolean doublePassed)
    {
        gameHandling.pointCalculator ();
        if (player1.getPoints () + player2.getPoints () == 64 || doublePassed ||
                player1.getPoints () == 0 || player2.getPoints () == 0)
        {
            if (player1.getPoints () > player2.getPoints ())
            {
                getGameHandling ().showMap (false);
                System.out.println (gameHandling.stringToShape (player1.getTawColor ()) + " Won");
                return false;

            }
            if (player1.getPoints () < player2.getPoints ())
            {
                getGameHandling ().showMap (false);
                System.out.println (gameHandling.stringToShape (player2.getTawColor ()) + " Won");
            }
            else
            {
                getGameHandling ().showMap (false);
                System.out.println ("Draw");
            }
            return false;
        }
        return true;
    }

    /**
     * change turn of players
     */
    public void changeTurn ()
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

    /**
     * play Game
     * @throws InterruptedException for wasting time for machine choose
     */
    abstract public void playGame () throws InterruptedException;
}
