import game.GameController;

public class Main {
    public static void main(String[] args) throws Exception {
        GameController controller = new GameController();
        controller.calcOutputGrid();
        controller.saveResult();
    }
}
