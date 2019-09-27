package game.entities;

import java.util.LinkedList;
import java.util.List;

import static game.entities.Cell.DEAD;

public class Grid {
    private static final int GRID_OUT_CELL_VALUE = 0;

    private Cell[][] grid;

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
                grid[i][j] = Cell.valueOfCharacter(inputGrid.get(i)[j]);
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
                grid[i + centerStartI][j + centerStartJ] = copyGrid.grid[i][j];
            }
        }
    }

    public int getHeight() {
        return grid.length;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public void print() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public void setCell(int x, int y, Cell cell) {
        grid[x][y] = cell;
    }

    public int getNeighbourValue(int x, int y) {
        int neighbourValue = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                neighbourValue += getCellValue(i + x, j + y);
            }
        }
        return neighbourValue - grid[x][y].getValue();
    }

    private int getCellValue(int x, int y) {
        boolean isXCordInsideGrid = x >= 0 && x < getHeight();
        boolean isYCordInsideGrid = y >= 0 && y < getWidth();
        boolean isCellInsideGrid = isXCordInsideGrid && isYCordInsideGrid;
        if (isCellInsideGrid)
            return grid[x][y].getValue();
        else
            return GRID_OUT_CELL_VALUE;
    }

    public List<String> toStringList(){
        List<String> result = new LinkedList<>();
        for(int i = 0; i<getHeight();i++){
            StringBuilder builder = new StringBuilder();
            for(int j=0;j<getWidth();j++){
                builder.append(grid[i][j]);
            }
            result.add(builder.toString());
        }
        return result;
    }
}