package field;

import java.util.List;

public class InputParser {
    private InputValidator validator;
    private int height;
    private int width;
    private int iterations;
    private Cell[][] startGreed;

    public InputParser(List<String> input){
            validator = new InputValidator(input);
    }

    public void parse(){
        validator.validate();
        parseSize(validator.getSizeLine());
        parseIterations(validator.getIterationsLine());
        parseStartField(validator.getFieldLines());
    }

    private void parseSize(String sizeLine) {
        String[] size = sizeLine.split(" ");
        height = Integer.parseInt(size[0]);
        width = Integer.parseInt(size[1]);
    }

    private void parseIterations(String iterationsLine){
        iterations = Integer.parseInt(iterationsLine);
    }

    private void parseStartField(List<String> fieldLines){
        int height = fieldLines.size();
        int width = fieldLines.get(0).length();
        Cell[][] startGreed = new Cell[height][width];

        for(int i = 0; i<height;i++){
            String[] cells = fieldLines.get(i).split("");
            for(int j = 0; j<width;j++){
                startGreed[i][j] = Cell.valueOfCharacter(cells[j]);
            }
        }
        this.startGreed=startGreed;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getIterations() {
        return iterations;
    }

    public Cell[][] getStartGreed() {
        return startGreed;
    }
}
