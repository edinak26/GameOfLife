import game.GameController;

public class Main {
    public static void main(String[] args){
        runGame();
    }

    private static void runGame() {
        try {
            GameController controller = new GameController();
            controller.calcResultGrid();
            controller.saveGrid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
