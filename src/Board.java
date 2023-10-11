import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {


    //Drops the X or 0 symbol into the correct grid positions when called. E.g [2][0] = position 4.
    //Adds the placement into the npcPosition or playerPosition layout, to keep track of what has been filled.
    public void gamePlay(char[][] grid, int placement, String user) {
        char symbol = 'X';

        if (user.equals("player")) {
            symbol = 'X';
            Main.playerPosition.add(placement);

        } else if (user.equals("npc")) {
            symbol = '0';
            Main.npcPosition.add(placement);
        }

        switch (placement) {

            case 1:
                grid[0][0] = symbol;
                break;

            case 2:
                grid[0][2] = symbol;
                break;

            case 3:
                grid[0][4] = symbol;
                break;

            case 4:
                grid[2][0] = symbol;
                break;

            case 5:
                grid[2][2] = symbol;
                break;

            case 6:
                grid[2][4] = symbol;
                break;

            case 7:
                grid[4][0] = symbol;
                break;

            case 8:
                grid[4][2] = symbol;
                break;

            case 9:
                grid[4][4] = symbol;
                break;
        }
        System.out.println(" ");

        //Print the grid after position has been assigned.
        printGrid(grid);

    }


    //Adds each list to the winning Arraylist.
    // Then tracks whether a list has been filled, in which case the player/npc has won. Else prints tie.
    public String checkWinner() {
        
        /* Magic square board
        List topRow = Arrays.asList(4, 9, 2);
        List midRow = Arrays.asList(3, 5, 7);
        List botRow = Arrays.asList(8, 1, 6);

        //Winning columns of the board.
        List leftCol = Arrays.asList(4, 3, 8);
        List middleCol = Arrays.asList(9, 5, 1);
        List rightCol = Arrays.asList(2, 7, 6);

        //Winning across the board.
        List cross1 = Arrays.asList(4, 5, 6);
        List cross2 = Arrays.asList(2, 5, 6);
         */

        //Winning rows of the board.
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        //Winning columns of the board.
        List leftCol = Arrays.asList(1, 4, 7);
        List middleCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        //Winning across the board.
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);


        //ArrayList to keep track of our lists.
        List<List> winning = new ArrayList<List>();


        //Add lists to ArrayList.
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);

        winning.add(leftCol);
        winning.add(middleCol);
        winning.add(rightCol);

        winning.add(cross1);
        winning.add(cross2);


        //Checks if the npc/playerPosition array in Main contains all the numbers of a given list.
        //Player win.
        for (List l : winning) {
            if (Main.playerPosition.containsAll(l)) {
                return "You won!";

              //NPC win
            } else if (Main.npcPosition.containsAll(l)) {
                return "NPC wins!";

                //Checks if the board is full.
            } else if (Main.playerPosition.size() + Main.npcPosition.size() == 9) {
                return "Tie!";
            }
        }
        return "";
    }

    // Draws the grid when called.
    public void printGrid(char[][] grid) {

        //Draw grid in for loop.
        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
