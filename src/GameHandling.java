import java.util.HashMap;
import java.util.HashSet;

public class GameHandling
{
    Player player1;
    Player player2;
    Taw [][] taws;

    public GameHandling (Player player1, Player player2)
    {
        taws = new Taw[8][8];
        this.player1 = player1;
        this.player2 = player2;
        makeAllTaws ();
    }

    private void makeAllTaws ()
    {
        for (int y = 0; y < 8; y++)
            for (int x = 0; x < 8; x++)
            {
                taws[y][x] = new Taw ();
                if ((x == 3 && y == 3) || (x == 4 && y == 4))
                    taws[y][x].setColor (player1.getTawColor ());
                if ((x == 3 && y == 4) || (x == 4 && y == 3))
                    taws[y][x].setColor (player2.getTawColor ());
            }
    }



    private HashSet<HashMap<Coordinate,HashSet<Coordinate>>> suggestions ()
    {
        HashSet<HashMap<Coordinate,HashSet<Coordinate>>> totalSuggestion = new HashSet<> ();
        String sameColor;
        String oppositeColor;
        if (player1.isTurn ())
        {
            oppositeColor = player2.getTawColor ();
            sameColor = player1.getTawColor ();
        }
        else
        {
            oppositeColor = player1.getTawColor ();
            sameColor = player2.getTawColor ();
        }

        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                if (taws[y][x] != null && taws[y][x].getColor ().equals (sameColor))
                {
                    totalSuggestion.add(makeSuggestionsForaTaw (new Coordinate (x,y),oppositeColor));
                }
            }
        }
        return totalSuggestion;
    }

    private HashMap<Coordinate, HashSet<Coordinate>> makeSuggestionsForaTaw (Coordinate begin,
                                                                             String oppositeColor)
    {
        int x = begin.getX ();
        int y = begin.getY ();
        HashMap<Coordinate,HashSet<Coordinate>> suggestions = new HashMap<> ();
        HashSet<Coordinate> sug = new HashSet<> ();
        if (x - 1 >= 0 && y - 1 >= 0 && taws[y - 1][x - 1] != null &&
                taws[y - 1][x - 1].getColor ().equals (oppositeColor))
        {
            Coordinate coordinate = checkInDir (begin,1,false,"non-color"
            ,null);
            if (coordinate != null)
                sug.add (coordinate);
        }
        if ( y - 1 >= 0 && taws[y - 1][x] != null &&
                taws[y - 1][x].getColor ().equals (oppositeColor))
        {
            Coordinate coordinate = checkInDir (begin,2,false,"non-color"
            ,null);
            if (coordinate != null)
                sug.add (coordinate);
        }
        if (y - 1 >= 0 && x + 1 < 8 && taws[y - 1][x + 1] != null &&
                taws[y - 1][x + 1].getColor ().equals (oppositeColor))
        {
            Coordinate coordinate = checkInDir (begin,3,false,"non-color"
            ,null);
            if (coordinate != null)
                sug.add (coordinate);
        }
        if ( x - 1 >= 0 && taws[y][x - 1] != null &&
                taws[y][x - 1].getColor ().equals (oppositeColor))
        {
            Coordinate coordinate = checkInDir (begin,4,false,"non-color",
                    null);
            if (coordinate != null)
                sug.add (coordinate);
        }
        if (x + 1 < 8 && taws[y][x + 1] != null &&
                taws[y][x + 1].getColor ().equals (oppositeColor))
        {
            Coordinate coordinate = checkInDir (begin,5,false,"non-color",
                    null);
            if (coordinate != null)
                sug.add (coordinate);
        }
        if (y + 1 < 8 && x - 1 >= 0 && taws[y + 1][x - 1] != null &&
                taws[y + 1][x - 1].getColor ().equals (oppositeColor))
        {
            Coordinate coordinate = checkInDir (begin,6,false,"non-color",
                    null);
            if (coordinate != null)
                sug.add (coordinate);
        }
        if (y + 1 < 8 && taws[y + 1][x] != null &&
                taws[y + 1][x].getColor ().equals (oppositeColor))
        {
            Coordinate coordinate = checkInDir (begin,7,false,"non-color",
                    null);
            if (coordinate != null)
                sug.add (coordinate);
        }
        if (y + 1 < 8 && x + 1 < 8 &&taws[y + 1][x + 1] != null &&
                taws[y + 1][x + 1].getColor ().equals (oppositeColor))
        {
            Coordinate coordinate = checkInDir (begin,8,false,"non-color",
                    null);
            if (coordinate != null)
                sug.add (coordinate);
        }

        suggestions.put (begin,sug);
        return suggestions;
    }
    private Coordinate checkInDir (Coordinate begin, int dir,boolean makeChanges,String colorToStop,
                                   Coordinate end)
    {
        int x = begin.getX ();
        int y = begin.getY ();

        while (true)
        {
            switch (dir)
            {
                case 1 : x--; y--;
                    if (x < 0 || y < 0)
                        return null;
                    break;
                case 2 : y--;
                    if (y < 0)
                        return null;
                    break;
                case 3 : x++; y--;
                    if (x > 7 || y < 0)
                        return null;
                    break;
                case 4 : x--;
                    if (x < 0)
                        return null;
                    break;
                case 5 : x++;
                    if (x > 7)
                        return null;
                    break;
                case 6 : x--; y++;
                    if (x < 0 || y > 7)
                        return null;
                    break;
                case 7 : y++;
                    if (y > 7)
                        return null;
                    break;
                case 8 : x++; y++;
                    if (x > 7 || y > 7)
                        return null;
                    break;
            }

            if (taws[y][x].getColor ().equals (taws[begin.getY ()][begin.getX ()].getColor ()))
                break;

            if (end == null && taws[y][x].getColor ().equals (colorToStop) ||
                    taws[y][x].getColor ().equals ("dotted"))
                return new Coordinate (x,y);

            if (makeChanges)
                taws[y][x].setColor (colorToStop);

            if (end != null && end.getX () == x && end.getY () == y)
                return end;
        }
        return null;
    }

    public boolean hasAnySuggestions ()
    {
        for (HashMap<Coordinate, HashSet<Coordinate>> maps : suggestions ())
            for (Coordinate coordinate : maps.keySet ())
            {
                if (maps.get (coordinate).size () != 0)
                    return true;
            }
        return false;
    }

    private void showSuggestionsColor ()
    {
        for (HashMap<Coordinate, HashSet<Coordinate>> maps : suggestions ())
            for (Coordinate coordinate : maps.keySet ())
                for (Coordinate suggestion : maps.get (coordinate))
                {
                    taws[suggestion.getY ()][suggestion.getX ()].setColor ("dotted");
                }
    }

    private void clearSuggestionsColor ()
    {
        for (HashMap<Coordinate, HashSet<Coordinate>> maps : suggestions ())
            for (Coordinate coordinate : maps.keySet ())
                for (Coordinate suggestion : maps.get (coordinate))
                {
                    taws[suggestion.getY ()][suggestion.getX ()].setColor ("non-color");
                }
    }

    public HashSet<Coordinate> findBegins (Coordinate end)
    {
        HashSet<Coordinate> begins = new HashSet<> ();
        for (HashMap<Coordinate,HashSet<Coordinate>> maps : suggestions ())
            for (Coordinate key : maps.keySet ())
            {
                if (maps.get (key).contains (end))
                    begins.add (key);
            }
        return begins;
    }

    private void colorPath (Coordinate end, HashSet<Coordinate> begins)
    {
        String sameColor;
        if (player1.isTurn ())
            sameColor = player1.getTawColor ();
        else
            sameColor = player2.getTawColor ();

        for (Coordinate begin : begins)
        {
            if (begin.getX () == end.getX ())
            {
                if (begin.getY () < end.getY ())
                {
                    checkInDir (begin,7,true,
                            sameColor,end);
                } else {
                    checkInDir (begin,2,true,
                            sameColor,end);
                }
            }
            else if (begin.getY () == end.getY ())
            {
                if (begin.getX () < end.getX ())
                {
                    checkInDir (begin,5,true,
                            sameColor,end);
                } else {
                    checkInDir (begin,4,true,
                            sameColor,end);
                }
            }
            else
            {
                if (begin.getX () < end.getX ())
                {
                    if (begin.getY () < end.getY ())
                    {
                        checkInDir (begin,8,true,
                                sameColor,end);
                    }
                    else
                    {
                        checkInDir (begin,3,true,
                                sameColor,end);
                    }
                }
                else
                {
                    if (begin.getY () < end.getY ())
                    {
                        checkInDir (begin,6,true,
                                sameColor,end);
                    }
                    else
                    {
                        checkInDir (begin,1,true,
                                sameColor,end);
                    }
                }
            }
        }
    }

    public boolean chooseATaw (Coordinate end)
    {
        HashSet<Coordinate> begins = findBegins (end);
        if (begins.size () == 0 || end == null)
            return false;

        colorPath (end,begins);
        return true;
    }

    public void showMap ()
    {
        showSuggestionsColor ();
        if (player1.isTurn ())
            System.out.println ("player1 " + "( " + player1.getTawColor () + " )" + " turn");
        else
            System.out.println ("player2 " + "( " + player2.getTawColor () + " )" + " turn");
        System.out.println ("\n");
        System.out.println ("     A     B     C     D     E     F     G     H  ");
        System.out.println ("   _______________________________________________");

        for (int y = 0; y < 8; y++)
        {
            System.out.print (y+1 + " |");
            for (int x = 0; x < 8; x++)
            {
                if (taws[y][x].getColor ().equals ("non-color") ||
                        taws[y][x].getColor ().equals ("dotted"))
                {
                    System.out.print ("  ");
                    taws[y][x].printTaw ();
                    System.out.print ("  |");
                }
                else
                {
                    System.out.print ("  ");
                    taws[y][x].printTaw ();
                    System.out.print (" |");
                }
            }
            System.out.println ();
            System.out.println ("   _______________________________________________");
        }

        clearSuggestionsColor ();
    }

    public void pointCalculator ()
    {
        int numOfWhite = 0;
        int numOfBlack = 0;

        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                if (taws[y][x].getColor ().equals ("black"))
                    numOfBlack++;
                if (taws[y][x].getColor ().equals ("white"))
                    numOfWhite++;
            }
        }

        if (player1.getTawColor ().equals ("black"))
        {
            player1.setPoints (numOfBlack);
            player2.setPoints (numOfWhite);
        }
        else
        {
            player2.setPoints (numOfBlack);
            player1.setPoints (numOfWhite);
        }
    }
}
