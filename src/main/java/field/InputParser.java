package field;

import java.util.List;

public class InputParser {
    private InputValidator validator;
    private int height;
    private int width;
    private int iterations;
    private Cell[][] inputGreed;

    public InputParser(List<String> input){
            validator = new InputValidator(input);
    }

    public void parse(){
        validator.validate();
        parseSize(validator.getSizeLine());
        parseIterations(validator.getIterationsLine());
        parseInputGreed(validator.getGreedLines());
    }

    private void parseSize(String sizeLine) {
        String[] size = sizeLine.split(" ");
        height = Integer.parseInt(size[0]);
        width = Integer.parseInt(size[1]);
    }

    private void parseIterations(String iterationsLine){
        iterations = Integer.parseInt(iterationsLine);
    }

    private void parseInputGreed(List<String> greedLines){
        int height = greedLines.size();
        int width = greedLines.get(0).length();
        Cell[][] inputGreed = new Cell[height][width];

        for(int i = 0; i<height;i++){
            String[] cells = greedLines.get(i).split("");
            for(int j = 0; j<width;j++){
                inputGreed[i][j] = Cell.valueOfCharacter(cells[j]);
            }
        }
        this.inputGreed = inputGreed;
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

    public Cell[][] getInputGreed() {
        return inputGreed;
    }
}
