package field.read;

import java.util.List;
import java.util.stream.Collectors;

public class InputParser implements ParsedInput{
    private InputValidator validator;
    private int parsedHeight;
    private int parsedWidth;
    private int parsedIterations;
    private List<String[]> parsedInputGrid;

    public InputParser(List<String> input){
            validator = new InputValidator(input);
    }

    public void parse() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        validator.validate();
        parseSize(validator.getSizeLine());
        parseIterations(validator.getIterationsLine());
        parseInputGrid(validator.getGridLines());
        checkSize();
    }

    private void parseSize(String sizeLine) {
        String[] size = sizeLine.split(" ");
        parsedHeight = Integer.parseInt(size[0]);
        parsedWidth = Integer.parseInt(size[1]);
    }

    private void parseIterations(String iterationsLine){
        parsedIterations = Integer.parseInt(iterationsLine);
    }

    private void parseInputGrid(List<String> gridLines){
        parsedInputGrid = gridLines.stream()
                .map(line->line.split(""))
                .collect(Collectors.toList());
    }

    private void checkSize() throws IncorrectInputFileDataException {
        int inputGridHeight = parsedInputGrid.size();
        int inputGridWidth = parsedInputGrid.get(0).length;
        boolean isInputGridFitResultGrid = inputGridHeight<=parsedHeight && inputGridWidth<=parsedWidth;
        if(!isInputGridFitResultGrid)
            throw new IncorrectInputFileDataException();//TODO add message
    }

    public int getHeight() {
        return parsedHeight;
    }

    public int getWidth() {
        return parsedWidth;
    }

    public int getIterations() {
        return parsedIterations;
    }

    public List<String[]> getInputGrid() {
        return parsedInputGrid;
    }
}
