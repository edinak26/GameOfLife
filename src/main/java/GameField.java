import field.Cell;

import static field.Cell.DEAD;

public class GameField {
    private Cell[][] grid;
    GameField(int height, int width, Cell[][] startGrid){
        grid = new Cell[height][width];
        int startGridBeginX = (height-startGrid.length)/2;
        int startGridBeginY = (width-startGrid[0].length)/2;
        for(int i = 0; i<height;i++){
            for(int j = 0; j<width;j++){
                grid[i][j] = DEAD;
            }
        }

        for(int i = 0;i<startGrid.length;i++){
            for(int j = 0; j<startGrid[0].length;j++){
                grid[i+startGridBeginX][j+startGridBeginY] = startGrid[i][j];
            }
        }

        for(int i = 0; i<height;i++){
            for(int j = 0; j<width;j++){
                System.out.print(grid[i][j].getValue());
            }
            System.out.println();
        }
    }
}
