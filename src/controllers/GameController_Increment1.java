package controllers;

import repositories.Repository;
import helpers.InputHelper;



/**
 *
 * @author mga
 */
public class GameController_Increment1 {
    private final Repository repository;

    /**
     *
     */

    public GameController_Increment1() {
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Player File (Y/N)");
        if(c== 'Y' || c== 'y'){
            String fileName = inputHelper.readString("Enter filename");
            this.repository = new Repository(fileName);
        }
        else{
            this.repository = new Repository();
        }
        listPlayers();
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


    }

    private void listPlayers() {
        System.out.format("\033[31m%s\033[0m%n", "Players");
        System.out.format("\033[31m%s\033[0m%n", "=======");
        System.out.println(this.repository.getItems());

    }

    private void listPlayersInPointsOrder() {
        System.out.format("\033[31m%s\033[0m%n", "Players");
        System.out.format("\033[31m%s\033[0m%n", "=======");
    }


    private void updatePlayer() {
        System.out.format("\033[31m%s\033[0m%n", "Update Player");
        System.out.format("\033[31m%s\033[0m%n", "=============");
    }

}

