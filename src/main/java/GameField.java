import field.Cell;
import field.Grid;

import static field.Cell.DEAD;
import static field.Cell.LIVE;

public class GameField {
    private Grid grid;
    private int iterations;

    GameField(Grid startGrid, int iterations) {
        this.grid = startGrid;
        this.iterations = iterations;
    }

    public Grid getNextIterationGrid(){
        int height = grid.getHeight();
        int width = grid.getWidth();
        Grid nextGrid = new Grid(height,width);
        for(int i = 0; i< height;i++){
            for(int j = 0; j<width;j++){
                Cell oldCell = grid.getCell(i,j);
                int neighbourValue = grid.getNeighbourValue(i,j);
                Cell nextCell = getNextCell(oldCell,neighbourValue);
                nextGrid.setCell(i,j,nextCell);
            }
        }
        return nextGrid;
    }

    private Cell getNextCell(Cell oldCell, int neighbourValue){
        if(neighbourValue == 3) {
            return LIVE;
        } else if(neighbourValue == 2){
            return oldCell;
        } else {
            return DEAD;
        }
    }
}
