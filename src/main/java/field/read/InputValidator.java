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
        validateGreed();
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

    private void validateGreed() {
        List<String> greedLines = getGreedLines();
        validateGreedCharacters(greedLines);
        validateGreedWidth(greedLines);


    }

    private void validateGreedCharacters(List<String> greedLines) {
        for(String greedLine : greedLines){
            if(!greedLine.matches("^[OX]+$")) {
                int greedLineIndex = greedLines.indexOf(greedLine);
                int lineNumber = GREED_FIRST_LINE_NUMBER + greedLineIndex;
                throw new IncorrectInputFileFormatException(ValidateMessages.INCORRECT_GREED_CHARACTERS_IN + lineNumber);
            }
        }
    }

    private void validateGreedWidth(List<String> greedLines) {
        int width = greedLines.get(0).length();
        for(String greedLine : greedLines){
            if(greedLine.length()!=width) {
                int greedLineIndex = greedLines.indexOf(greedLine);
                int lineNumber = GREED_FIRST_LINE_NUMBER + greedLineIndex;
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

    public List<String> getGreedLines(){
        return input.subList(2,input.size());
    }
}
