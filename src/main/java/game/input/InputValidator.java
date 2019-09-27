package game.input;

import game.input.exceptions.ExceptionMessages;
import game.input.exceptions.IncorrectInputFileFormatException;

import java.util.List;

import static game.GameConstants.DEAD_CELL_CHARACTER;
import static game.GameConstants.LIVE_CELL_CHARACTER;

public class InputValidator implements ExceptionMessages {
    private static final String SIZE_LINE_REGEX = "^[0-9]+ [0-9]+$";
    private static final String ITERATIONS_LINE_REGEX = "^[0-9]+$";
    private static final String FILED_LINE_REGEX = "^["+LIVE_CELL_CHARACTER+DEAD_CELL_CHARACTER+"]+$";

    private static int GREED_FIRST_LINE_NUMBER = 3;

    private final List<String> input;

    public InputValidator(List<String> input){
        this.input = input;
    }

    public void validate() throws IncorrectInputFileFormatException {
        validateSize();
        validateIterations();
        validateGrid();
    }

    private void validateSize() throws IncorrectInputFileFormatException {
        String sizeLine = getSizeLine();
        if(!sizeLine.matches(SIZE_LINE_REGEX))
            throw new IncorrectInputFileFormatException(ExceptionMessages.INCORRECT_SIZE_LINE_FORMAT);
    }

    private void validateIterations() throws IncorrectInputFileFormatException {
        String iterationsLine = getIterationsLine();
        if(!iterationsLine.matches(ITERATIONS_LINE_REGEX))
            throw new IncorrectInputFileFormatException(ExceptionMessages.INCORRECT_ITERATIONS_LINE_FORMAT);
    }

    private void validateGrid() throws IncorrectInputFileFormatException {
        List<String> gridLines = getGridLines();
        validateGridCharacters(gridLines);
        validateGridWidth(gridLines);


    }

    private void validateGridCharacters(List<String> gridLines) throws IncorrectInputFileFormatException {
        for(String gridLine : gridLines){
            if(!gridLine.matches(FILED_LINE_REGEX)) {
                int gridLineIndex = gridLines.indexOf(gridLine);
                int lineNumber = GREED_FIRST_LINE_NUMBER + gridLineIndex;
                throw new IncorrectInputFileFormatException(ExceptionMessages.INCORRECT_GRID_CHARACTERS_IN + lineNumber);
            }
        }
    }

    private void validateGridWidth(List<String> gridLines) throws IncorrectInputFileFormatException {
        int width = gridLines.get(0).length();
        for(String gridLine : gridLines){
            if(gridLine.length()!=width) {
                int gridLineIndex = gridLines.indexOf(gridLine);
                int lineNumber = GREED_FIRST_LINE_NUMBER + gridLineIndex;
                throw new IncorrectInputFileFormatException(ExceptionMessages.INCORRECT_GRID_WIDTH_IN + lineNumber);
            }
        }
    }

    public String getSizeLine(){
        return input.get(0);
    }

    public String getIterationsLine(){
        return input.get(1);
    }

    public List<String> getGridLines(){
        return input.subList(2,input.size());
    }
}
