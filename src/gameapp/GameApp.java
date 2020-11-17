package gameapp;


import controllers.GameController;

/**
 *
 * @author mga
 */
public class GameApp {

    public static void run() {
        System.out.println("Game App\n" + "========\n\n");

        GameController gameController = new GameController();

        gameController.run();

        System.out.println("Thank you for using Game App. Good bye.\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameApp gameApp = new GameApp();
        gameApp.run();
    }

}
