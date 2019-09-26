import field.Cell;

import static field.Cell.DEAD;

public class GameField {
    private Cell[][] greed;
    GameField(int height, int width, Cell[][] startGreed){
        greed = new Cell[height][width];
        int startGreedBeginX = (height-startGreed.length)/2;
        int startGreedBeginY = (width-startGreed[0].length)/2;
        for(int i = 0; i<height;i++){
            for(int j = 0; j<width;j++){
                greed[i][j] = DEAD;
            }
        }

        for(int i = 0;i<startGreed.length;i++){
            for(int j = 0; j<startGreed[0].length;j++){
                greed[i+startGreedBeginX][j+startGreedBeginY] = startGreed[i][j];
            }
        }

        for(int i = 0; i<height;i++){
            for(int j = 0; j<width;j++){
                System.out.print(greed[i][j].getValue());
            }
            System.out.println();
        }
    }
}
