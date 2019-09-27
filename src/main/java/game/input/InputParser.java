package game.input;

import game.input.exceptions.IncorrectInputFileDataException;
import game.input.exceptions.IncorrectInputFileFormatException;

import java.util.List;
import java.util.stream.Collectors;

import static game.input.exceptions.ExceptionMessages.INCORRECT_INPUT_GRID_SIZE;

public class InputParser implements ParsedInput{
    private InputValidator validator;
    private int parsedHeight;
    private int parsedWidth;
    private int parsedIterations;
    private List<String[]> parsedInputGrid;

    public InputParser(List<String> input){
            validator = new InputValidator(input);
    }

    public ParsedInput parse() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        validator.validate();
        parseSize(validator.getSizeLine());
        parseIterations(validator.getIterationsLine());
        parseInputGrid(validator.getGridLines());
        checkSize();
        return this;
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
        boolean isInputGridFitInitialGrid = inputGridHeight<=parsedHeight && inputGridWidth<=parsedWidth;
        if(!isInputGridFitInitialGrid)
            throw new IncorrectInputFileDataException(INCORRECT_INPUT_GRID_SIZE);
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
