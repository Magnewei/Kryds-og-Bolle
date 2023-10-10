import java.io.FileNotFoundException;
import java.util.*;


/*
Some variables and functions may not have been implemented, as I intend to continue building on the project.
 */


class Main {

    //Our board and player objects and arraylists where we keep track of the player and npc moves.
    static Board board = new Board();
    static Player player = new Player("Magnus", 18, 26);
    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> npcPosition = new ArrayList<Integer>();
    static char[][] grid = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public static void main(String[] args) throws FileNotFoundException {

        String playerFileName = ""; //Loading name of the player in file.
        int playerFileWins = 0;  // Loading the player wins.
        int playerTotalGames = 0;  //Loading the player games.

        //  player.doesGameSaveExist();  Loads the player game save.

        System.out.println("The goal of the game is to get a row of your designated symbol. The player is always playing as X while the NPC is 0");
        System.out.println("You place your symbol by writing a number from 1-9, where 1 is the top left and 9 is the bottom right. The grid looks like this:");
        board.printGrid(grid);



        while (true) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Choose a placement: ");
            int playerPlacement = scan.nextInt();

            while (playerPosition.contains(playerPlacement) || npcPosition.contains(playerPosition)) {
                System.out.println("Position taken.");
                playerPlacement = scan.nextInt();
            }

            board.gamePlay(grid, playerPlacement, "player");

            String result;

            Random rand = new Random();
            int npcPlacement = rand.nextInt(9) + 1;
            while (playerPosition.contains(npcPlacement) || npcPosition.contains(npcPosition)) {
                System.out.println("Position taken.");
                npcPlacement = rand.nextInt(9) + 1;

            }
            board.gamePlay(grid, npcPlacement, "npc");
            System.out.println(" ");  //Creating a line between grids.

            //Checks if there's a winner.
            // Prints the winner as soon as the returned string from checkWinner() is 0> and break; from the game.
            result = board.checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;

            }
        }
    }
}














