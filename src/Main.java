import java.util.*;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> npcPosition = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] grid = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        ArrayList<Integer> winning = new ArrayList<Integer>();


        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose a placement: ");
            int playerPlacement = scan.nextInt();

            while (playerPosition.contains(playerPlacement) || npcPosition.contains(playerPosition)) {
                System.out.println("Position taken.");
                playerPlacement = scan.nextInt();
            }

            gamePlay(grid, playerPlacement, "player");

            String result = Board.checkWinner();

            Random rand = new Random();
            int npcPlacement = rand.nextInt(9) + 1;
            while (playerPosition.contains(playerPlacement) || npcPosition.contains(npcPosition)) {
                System.out.println("Position taken.");
                npcPlacement = scan.nextInt();

            }
            gamePlay(grid, npcPlacement, "npc");
            printGrid(grid);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;

            }
        }
    }


    public static void introduceGame() {

        // Instantiates the scanner terminal input.
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Are you ready to play? \n Yes / No");
        String answer = scanner.nextLine();

        // Checks if the answer is "yes". Ignores case.
        if (answer.equalsIgnoreCase("Yes")) {
            System.out.println("The game will show you three lines of squares, where each square represents a field in which you can place your brick.");
            System.out.println("To place your brick, write the number of one of the given fields.");


            // Checks if no. If answer equals no, then exit the game.
        } else if (answer.equalsIgnoreCase("No")) {
            System.out.println("The game will now exit.");
            System.exit(0);

            //Catches wrong input.
        } else {
            System.out.println("It seems like you mistyped. Please answer either yes or no.");
        }
    }
}














