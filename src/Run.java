import javax.swing.*;
import java.util.Scanner;

public class Run
{
    public static void main (String[] args) {

        System.out.println ("Othello Game");
        System.out.println ("Please Choose the type of Game  \n1) One Player\n2) Two Player");
        Scanner input = new Scanner (System.in);

        int choose = input.nextInt ();

        if (choose == 1)
        {
            Scanner dif = new Scanner (System.in);
            System.out.println ("Please Choose the Difficulty of Game  \n1) Easy\n2) Hard");
            int ch = dif.nextInt ();
            if (ch == 1)
            {
                Game game = new GameOnePlayer ("Easy");
                game.playGame ();
            }
            if (ch == 2)
            {
                Game game = new GameOnePlayer ("Hard");
                game.playGame ();
            }
            else
            {
                System.out.println ("Wrong input");
                return;
            }
        }
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