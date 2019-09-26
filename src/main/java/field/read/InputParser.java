package field.read;

import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private InputValidator validator;
    private int parsedHeight;
    private int parsedWidth;
    private int parsedIterations;
    private List<String[]> parsedInputGreed;

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
        parsedHeight = Integer.parseInt(size[0]);
        parsedWidth = Integer.parseInt(size[1]);
    }

    private void parseIterations(String iterationsLine){
        parsedIterations = Integer.parseInt(iterationsLine);
    }

    private void parseInputGreed(List<String> greedLines){
        parsedInputGreed = greedLines.stream()
                .map(line->line.split(""))
                .collect(Collectors.toList());
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

    public List<String[]> getInputGreed() {
        return parsedInputGreed;
    }
}
