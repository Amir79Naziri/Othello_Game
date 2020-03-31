import java.util.Random;

/**
 * this class bring random start for Game
 *
 * @author Amir Naziri
 * @version 1.0
 */
public class RandomGame
{

    /**
     * makes a random integer number between [1, 2]
     * @return random number
     */
    private int randomMaker ()
    {
        Random random = new Random();
        return random.nextInt (2) + 1;
    }

    /**
     * give random turn to players (who start game)
     * @param player1 player1
     * @param player2 player2
     */
    private void randomStarter (Player player1, Player player2)
    {
        if (randomMaker () == 1)
            player1.makeTurn ();
        else
            player2.makeTurn ();
    }

    /**
     * give random color to players
     * @param player1 player1
     * @param player2 player2
     */
    private void randomColor (Player player1, Player player2)
    {
        if (randomMaker () == 1) {
            player1.setTawColor ("black");
            player2.setTawColor ("white");
        } else {
            player1.setTawColor ("white");
            player2.setTawColor ("black");
        }
    }

    /**
     * this method is for one player game and choose a player randomly for machine
     * @param player1 player1
     * @param player2 player2
     */
    private void randomMachine (Player player1, Player player2)
    {
        if (randomMaker () == 1) {
            player1.changeToMachine ();
            player2.makeTurn ();
        }
        else
        {
            player2.changeToMachine ();
            player1.makeTurn ();
        }
    }

    /**
     * this method is for two player game and gives a random color and turn to player
     * @param player1 player1
     * @param player2 player2
     */
    public void startRandomGame (Player player1 ,Player player2)
    {
        randomColor (player1,player2);
        randomStarter (player1,player2);
    }

    /**
     * this method is for one player game and gives a random color to palyers
     * and sets a player for machine
     * @param player1 player1
     * @param player2 player2
     */
    public void startRandomGameWithMachine (Player player1 ,Player player2)
    {
        randomColor (player1,player2);
        randomMachine (player1,player2);
    }
}
