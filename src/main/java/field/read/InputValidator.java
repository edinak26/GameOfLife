package field.read;

import java.util.List;

public class InputValidator implements ValidateMessages {
    private static int GREED_FIRST_LINE_NUMBER = 3;

    private final List<String> input;

    public InputValidator(List<String> input){
        this.input = input;
    }

    public void validate(){
        validateSize();
        validateIterations();
        validateGrid();
    }

    private void validateSize() {
        String sizeLine = getSizeLine();
        if(!sizeLine.matches("^[0-9]+ [0-9]+$"))
            throw new IncorrectInputFileFormatException(ValidateMessages.INCORRECT_SIZE_LINE_FORMAT);
    }

    private void validateIterations() {
        String iterationsLine = getIterationsLine();
        if(!iterationsLine.matches("^[0-9]+$"))
            throw new IncorrectInputFileFormatException(ValidateMessages.INCORRECT_ITERATIONS_LINE_FORMAT);
    }

    private void validateGrid() {
        List<String> gridLines = getGridLines();
        validateGridCharacters(gridLines);
        validateGridWidth(gridLines);


    }

    private void validateGridCharacters(List<String> gridLines) {
        for(String gridLine : gridLines){
            if(!gridLine.matches("^[OX]+$")) {
                int gridLineIndex = gridLines.indexOf(gridLine);
                int lineNumber = GREED_FIRST_LINE_NUMBER + gridLineIndex;
                throw new IncorrectInputFileFormatException(ValidateMessages.INCORRECT_GREED_CHARACTERS_IN + lineNumber);
            }
        }
    }

    private void validateGridWidth(List<String> gridLines) {
        int width = gridLines.get(0).length();
        for(String gridLine : gridLines){
            if(gridLine.length()!=width) {
                int gridLineIndex = gridLines.indexOf(gridLine);
                int lineNumber = GREED_FIRST_LINE_NUMBER + gridLineIndex;
                throw new IncorrectInputFileFormatException(ValidateMessages.INCORRECT_GREED_WIDTH_IN + lineNumber);
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
