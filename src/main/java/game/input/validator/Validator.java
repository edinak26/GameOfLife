package game.input.validator;

import game.input.exceptions.ExceptionMessages;
import game.input.exceptions.IncorrectInputFileFormatException;

import java.util.List;

import static game.input.validator.Constants.*;

public class Validator implements InputValidator, ValidatedInput{

    private final List<String> input;

    public Validator(List<String> input) {
        this.input = input;
    }

    public ValidatedInput validate() throws IncorrectInputFileFormatException {
        validateSize();
        validateIterations();
        validateGrid();
        return this;
    }

    private void validateSize() throws IncorrectInputFileFormatException {
        String sizeLine = getSizeLine();
        if (!sizeLine.matches(SIZE_LINE_REGEX))
            throw new IncorrectInputFileFormatException(ExceptionMessages.INCORRECT_SIZE_LINE_FORMAT);
    }

    private void validateIterations() throws IncorrectInputFileFormatException {
        String iterationsLine = getIterationsLine();
        if (!iterationsLine.matches(ITERATIONS_LINE_REGEX))
            throw new IncorrectInputFileFormatException(ExceptionMessages.INCORRECT_ITERATIONS_LINE_FORMAT);
    }

    private void validateGrid() throws IncorrectInputFileFormatException {
        List<String> gridLines = getInputGridLines();
        validateGridCharacters(gridLines);
        validateGridWidth(gridLines);
    }

    private void validateGridCharacters(List<String> gridLines) throws IncorrectInputFileFormatException {
        for (String gridLine : gridLines) {
            if (!gridLine.matches(FILED_LINE_REGEX)) {
                int gridLineIndex = gridLines.indexOf(gridLine);
                int lineNumber = GREED_FIRST_LINE_NUMBER + gridLineIndex;
                throw new IncorrectInputFileFormatException(ExceptionMessages.INCORRECT_GRID_CHARACTERS_IN + lineNumber);
            }
        }
    }

    private void validateGridWidth(List<String> gridLines) throws IncorrectInputFileFormatException {
        int width = gridLines.get(0).length();
        for (String gridLine : gridLines) {
            if (gridLine.length() != width) {
                int gridLineIndex = gridLines.indexOf(gridLine);
                int lineNumber = GREED_FIRST_LINE_NUMBER + gridLineIndex;
                throw new IncorrectInputFileFormatException(ExceptionMessages.INCORRECT_GRID_WIDTH_IN + lineNumber);
            }
        }
    }

    public String getSizeLine() {
        return input.get(0);
    }

    public String getIterationsLine() {
        return input.get(1);
    }

    public List<String> getInputGridLines() {
        return input.subList(2, input.size());
    }
}
