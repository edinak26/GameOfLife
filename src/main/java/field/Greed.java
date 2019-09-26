package field;

import java.util.List;

import static field.Cell.DEAD;

public class Greed {
    Cell[][] greed;

    public Greed(int height, int width) {
        createEmptyGreed(height, width);
        fillGreedByDeadCells();
    }

    private void createEmptyGreed(int height, int width) {
        greed = new Cell[height][width];
    }

    private void fillGreedByDeadCells() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                greed[i][j] = DEAD;
            }
        }
    }

    public Greed(List<String[]> inputGreed) {
        int height = inputGreed.size();
        int width = inputGreed.get(0).length;
        createEmptyGreed(height, width);
        fillGreedByInputGreed(inputGreed);
    }

    private void fillGreedByInputGreed(List<String[]> inputGreed) {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                greed[i][j] = Cell.valueOf(inputGreed.get(i)[j]);
            }
        }
    }

    public Greed(Greed copyGreed, int height, int width) {
        createEmptyGreed(height, width);
        fillGreedByDeadCells();
        copyInCenter(copyGreed);
    }

    private void copyInCenter(Greed copyGreed) {
        int centerStartI = (getHeight() - copyGreed.getHeight()) / 2;
        int centerStartJ = (getWidth() - copyGreed.getWidth()) / 2;
        for (int i = 0; i < copyGreed.getHeight(); i++) {
            for (int j = 0; j < copyGreed.getWidth(); j++) {
                greed[i+centerStartI][j+centerStartJ] = copyGreed.greed[i][j];
            }
        }
    }

    public int getHeight() {
        return greed.length;
    }

    public int getWidth() {
        return greed[0].length;
    }
}
