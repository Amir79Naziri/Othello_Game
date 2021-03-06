import java.util.Scanner;

/**
 * this class is for running the program
 *
 * @author Amir Naziri
 * @version 1.0
 */
public class Run
{
    public static void main (String[] args) throws InterruptedException {

        System.out.println ("Othello Game");
        System.out.println ("Please Choose the type of Game  \n1) One Player\n2) Two Player");
        Scanner input = new Scanner (System.in);

        int choose = input.nextInt ();
        // one player
        if (choose == 1)
        {
            Scanner dif = new Scanner (System.in);
            System.out.println ("Please Choose the Difficulty of Game  \n1) Easy\n2) Hard");
            int ch = dif.nextInt ();
            if (ch == 1)
            {
                Game game = new GameOnePlayer ("Easy");
                game.playGame ();
                return;
            }
            if (ch == 2)
            {
                Game game = new GameOnePlayer ("Hard");
                game.playGame ();
            }
            else
            {
                System.out.println ("Wrong input");
            }
            return;
        }
        // two player
        if (choose == 2)
        {
            Game game = new GameTwoPlayer ();
            game.playGame ();
        }
        else
        {
            System.out.println ("Wrong input");
        }
    }
}