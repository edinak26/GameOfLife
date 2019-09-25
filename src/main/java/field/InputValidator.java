package field;

import java.util.List;

public class InputValidator implements ValidateMessages {
    private static int FIELD_FIRST_LINE_NUMBER = 3;

    private final List<String> input;

    public InputValidator(List<String> input){
        this.input = input;
    }

    public void validate(){
        validateSize();
        validateIterations();
        validateField();
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

    private void validateField() {
        List<String> fieldLines = getFieldLines();
        validateFieldCharacters(fieldLines);
        validateFieldWidth(fieldLines);


    }

    private void validateFieldCharacters(List<String> fieldLines) {
        for(String fieldLine : fieldLines){
            if(!fieldLine.matches("^[OX]+$")) {
                int fieldLineIndex = fieldLines.indexOf(fieldLine);
                int lineNumber = FIELD_FIRST_LINE_NUMBER + fieldLineIndex;
                throw new IncorrectInputFileFormatException(ValidateMessages.INCORRECT_FIELD_CHARACTERS_IN + lineNumber);
            }
        }
    }

    private void validateFieldWidth(List<String> fieldLines) {
        int width = fieldLines.get(0).length();
        for(String fieldLine : fieldLines){
            if(fieldLine.length()!=width) {
                int fieldLineIndex = fieldLines.indexOf(fieldLine);
                int lineNumber = FIELD_FIRST_LINE_NUMBER + fieldLineIndex;
                throw new IncorrectInputFileFormatException(ValidateMessages.INCORRECT_FIELD_WIDTH_IN + lineNumber);
            }
        }
    }

    public String getSizeLine(){
        return input.get(0);
    }

    public String getIterationsLine(){
        return input.get(1);
    }

    public List<String> getFieldLines(){
        return input.subList(2,input.size());
    }
}
