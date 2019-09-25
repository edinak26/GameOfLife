import java.util.List;

public class InputValidator {
    private final List<String> input;

    public InputValidator(List<String> input){
        this.input = input;
    }

    public void validate(){
        validateSize();
        validateIterations();
        validateField();
    }

    public String getSizeLine(){
        return input.get(0);
    }

    public String getIterationsLine(){
        return input.get(1);
    }

    public List<String> getFieldLines(){
        return input.subList(2,input.size()-1);
    }

    private void validateSize() {
        String sizeLine = getSizeLine();
        if(!sizeLine.matches("$[0-9]+ [0-9]+^"))
            throw new RuntimeException("Incorrect input file format"); //TODO create special exception
    }

    private void validateIterations() {
        String iterationsLine = getIterationsLine();
        if(!iterationsLine.matches("$[0-9]+^"))
            throw new RuntimeException("Incorrect input file format"); //TODO create special exception
    }

    private void validateField() {
        List<String> fieldLines = getFieldLines();
        validateFieldCharacters(fieldLines);
        validateFieldWidth(fieldLines);


    }

    private void validateFieldCharacters(List<String> fieldLines) {
        for(String fieldLine : fieldLines){
            if(!fieldLine.matches("([OX])+"))
                throw new RuntimeException("Incorrect input file format"); //TODO create special exception
        }
    }

    private void validateFieldWidth(List<String> fieldLines) {
        int width = fieldLines.get(2).length();
        for(String fieldLine : fieldLines){
            if(fieldLine.length()!=width)
                throw new RuntimeException("Incorrect input file format"); //TODO create special exception
        }
    }

}
