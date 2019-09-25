import field.Cell;
import field.FileReader;
import field.InputValidator;

import java.util.List;

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


    /*
    public GameField construct(){
        InputValidator validator = new InputValidator(FileReader.readInputFile());
        validator.validate();
        String[] sizeLine = validator.getSizeLine().split(" ");
        int height = Integer.parseInt(sizeLine[0]);
        int width = Integer.parseInt(sizeLine[1]);
        greed = new int[height][width];
        String iterationsLine = validator.getIterationsLine();
        int iterations = Integer.parseInt(iterationsLine);
        List<String> startingField = validator.getFieldLines();
        return null;
    }*/
}
