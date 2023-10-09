import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {


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
                grid[0][6] = symbol;
                break;

            case 5:
                grid[2][0] = symbol;
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
        printGrid(grid);

    }

    public  String checkWinner() {

        // Magic square = ((8, 1, 6), (3, 5, 7), (4, 9, 2))
        // All the columns/rows are ordered in a magic square,
        // which means that if the player or npc fields equal 15 they win.

        List topRow = Arrays.asList(8, 1, 6);
        List midRow = Arrays.asList(3, 5, 7);
        List botRow = Arrays.asList(4, 9, 2);

        List leftCol = Arrays.asList(8, 3, 4);
        List middleCol = Arrays.asList(1, 5, 9);
        List rightCol = Arrays.asList(6, 7, 2);

        List cross1 = Arrays.asList(8, 5, 2);
        List cross2 = Arrays.asList(4, 5, 6);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(middleCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (Main.playerPosition.containsAll(l)) {
                return "You won!";
            } else if (Main.npcPosition.containsAll(l)) {
                return "NPC wins!";
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
