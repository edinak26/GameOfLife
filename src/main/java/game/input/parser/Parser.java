package game.input.parser;

import game.input.exceptions.IncorrectInputFileDataException;
import game.input.validator.ValidatedInput;

import java.util.List;
import java.util.stream.Collectors;

import static game.input.exceptions.ExceptionMessages.INCORRECT_INPUT_GRID_SIZE;

public class Parser implements InputParser, ParsedInput {
    private final ValidatedInput input;
    private int parsedHeight;
    private int parsedWidth;
    private int parsedIterations;
    private List<String[]> parsedInputGrid;

    public Parser(ValidatedInput input){
            this.input = input;
    }

    public ParsedInput parse() throws IncorrectInputFileDataException {
        parseInput();
        checkParsedInput();
        return this;
    }

    private void parseInput(){
        parseSize(input.getSizeLine());
        parseIterations(input.getIterationsLine());
        parseInputGrid(input.getInputGridLines());
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

    private void checkParsedInput() throws IncorrectInputFileDataException {//TODO add checks
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
