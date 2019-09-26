package field;

import java.util.List;

import static field.Cell.DEAD;

public class Grid {
    Cell[][] grid;

    public Grid(int height, int width) {
        createEmptyGrid(height, width);
        fillGridByDeadCells();
    }

    private void createEmptyGrid(int height, int width) {
        grid = new Cell[height][width];
    }

    private void fillGridByDeadCells() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                grid[i][j] = DEAD;
            }
        }
    }

    public Grid(List<String[]> inputGrid) {
        int height = inputGrid.size();
        int width = inputGrid.get(0).length;
        createEmptyGrid(height, width);
        fillGridByInputGrid(inputGrid);
    }

    private void fillGridByInputGrid(List<String[]> inputGrid) {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                grid[i][j] = Cell.valueOf(inputGrid.get(i)[j]);
            }
        }
    }

    public Grid(Grid copyGrid, int height, int width) {
        createEmptyGrid(height, width);
        fillGridByDeadCells();
        copyInCenter(copyGrid);
    }

    private void copyInCenter(Grid copyGrid) {
        int centerStartI = (getHeight() - copyGrid.getHeight()) / 2;
        int centerStartJ = (getWidth() - copyGrid.getWidth()) / 2;
        for (int i = 0; i < copyGrid.getHeight(); i++) {
            for (int j = 0; j < copyGrid.getWidth(); j++) {
                grid[i+centerStartI][j+centerStartJ] = copyGrid.grid[i][j];
            }
        }
    }

    public int getHeight() {
        return grid.length;
    }

    public int getWidth() {
        return grid[0].length;
    }
}
