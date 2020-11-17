package controllers;

import Model.Player;
import Model.SocialMediaPlayer;
import repositories.Repository;
import helpers.InputHelper;

import java.util.Collections;

/**
 *
 * @author mga
 */
public class GameController {
    private final Repository repository;

    /**
     *
     */

    public GameController() {
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Player File (Y/N)");
        if(c== 'Y' || c== 'y'){
            String fileName = inputHelper.readString("Enter filename");
            this.repository = new Repository(fileName);
        }
        else{
            this.repository = new Repository();
        }

    }

    /**
     *
     */
    public void run() {
        boolean finished = false;

        do {

            char choice = displayGameMenu();
            switch (choice) {
                case 'A':
                    addPlayer();
                    listPlayers();
                    break;
                case 'B':
                    listPlayersInPointsOrder();
                    break;
                case 'C':
                    updatePlayer();
                    listPlayers();
                    break;
                case 'Q':
                    InputHelper inputHelper = new InputHelper();
                    String filename = inputHelper.readString("Enter filename");
                    repository.store(filename);
                    finished = true;
            }
        } while (!finished);
    }

    private char displayGameMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Player");
        System.out.print("\tB. List Players");
        System.out.print("\tC. Update Player");
        System.out.print("\tQ. Quit\n");
        return inputHelper.readCharacter("Enter choice", "ABCDQ");
    }

    private void addPlayer() {
        System.out.format("\033[31m%s\033[0m%n", "Add Player");
        System.out.format("\033[31m%s\033[0m%n", "==========");
        InputHelper inputHelper = new InputHelper();
        char registerOption = inputHelper.readCharacter("Want to register using the a social media App or App itself (S/A)");
        String playerName = inputHelper.readString("What's your name ");
        Player player;
        if(registerOption == 'S'){
            String socialMediaApp = inputHelper.readString("the name of the social media app");
            String socialMediaIdentifier = inputHelper.readString("Social media identifer");
            player = new SocialMediaPlayer(playerName, socialMediaApp, socialMediaIdentifier);

        }else{
            player = new Player(playerName);
        }
        repository.add(player);
    }

    private void listPlayers() {
        System.out.format("\033[31m%s\033[0m%n", "Players");
        System.out.format("\033[31m%s\033[0m%n", "=======");
        System.out.println(this.repository.getItems());

    }

    private void listPlayersInPointsOrder() {
        System.out.format("\033[31m%s\033[0m%n", "Players");
        System.out.format("\033[31m%s\033[0m%n", "=======");
         Collections.sort(repository.getItems(), Player.pointsEarnedComparator);
         System.out.println(repository.getItems());



    }


    private void updatePlayer() {
        System.out.format("\033[31m%s\033[0m%n", "Update Player");
        System.out.format("\033[31m%s\033[0m%n", "=============");
        InputHelper inputHelper = new InputHelper();
        String playerName = inputHelper.readString("The player name");
        for(Player item: repository.getItems()){
            if(item.getPlayerName().toLowerCase().equals(playerName.toLowerCase()) ){
                int currentLevel = item.getCurrentLevel();
                item.setCurrentLevel(currentLevel + 1);
                int pointsEarned = item.getPointsEarned();
                item.setPointsEarned(pointsEarned + 5);

            }
        }
    }

}
