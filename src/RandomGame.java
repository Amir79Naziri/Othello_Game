import java.util.Random;

public class RandomGame
{

    private int randomMaker ()
    {
        Random random = new Random();
        return random.nextInt (2) + 1;
    }

    private void randomStarter (Player player1, Player player2)
    {
        if (randomMaker () == 1)
            player1.makeTurn ();
        else
            player2.makeTurn ();
    }

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

    public void startRandomGame (Player player1 ,Player player2)
    {
        randomColor (player1,player2);
        randomStarter (player1,player2);
    }

}
