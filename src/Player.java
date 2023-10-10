import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player {

    // Variables are declared as static, as there will only be one player at a time,
    // and therefore both the methods and variables effectively belong to the player class.

    private static String playerName;
    private static int gameWins;
    private static int totalGames;

    static String gameSaveFile = "src/GameSave.txt";


    Player(String playerName, int gameWins, int totalGames) {
        this.playerName = playerName;
        this.gameWins = gameWins;
        this.totalGames = totalGames;
    }


    //Used for introducing the player and their save, on game start/restart.
    public static String greetPlayer() {
        int winLossRatio = gameWins / totalGames;   //Calculates the player win loss ratio.

        return "Player: " + playerName +
                " played a total amount of games " + totalGames +
                "with a win ratio of: " + winLossRatio + "% .";
    }

    // Writes the player save file.
    // Returns the username when file has been written successfully.
    public static String editGameSave(String userName) throws IOException {

        try {
            FileWriter writer = new FileWriter(gameSaveFile, true);
            writer.write(System.lineSeparator() + userName);
            writer.close();

            System.out.println("User: " + userName + "created successfully.");

        } catch (IOException e) {
            System.out.println("The file can't be found and/or parsed.");

        }
        return userName;
    }


    // Asks the player whether they have a save.
    // If yes, looks for the save. If no, asks whether they wish to create one.
    public static void doesGameSaveExist() throws FileNotFoundException {

        // Instantiating scanner to find user in gameSave.
        Scanner scanner = new Scanner(System.in);

        // Holding the user that we're getting from scanner.
        String searchText = "Search Text";

        // Checks yes or no.
        System.out.println("Do you have a user? \n Yes / No");
        String answer = scanner.nextLine();

        // Checks if the answer is "yes". Ignores case.
        if (answer.equalsIgnoreCase("Yes")) {
            System.out.println("What's the name of the user?");
            searchText = scanner.nextLine();

            try {
                // Instantiating the gameSave file and scanner.
                Scanner gameSave = new Scanner(new File(gameSaveFile));

                while (gameSave.hasNextLine()) {

                    //Overwrites the answer String to check each line.
                    answer = gameSave.nextLine();

                    // Checks if the line in GameSave contains the username we're given in searchText.
                    if (answer.contains(searchText)) {
                        greetPlayer();

                        // If a user couldn't be found.
                    } else {
                        System.out.println("User could not be found. Do you wish to create a new save? \n Yes / No");
                        answer = scanner.nextLine();

                        // Create new user if answer equals yes. Else continue.
                        if (answer.equalsIgnoreCase("Yes")) {
                            answer = scanner.nextLine();
                            editGameSave(answer);
                        }
                    }
                }
                gameSave.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

