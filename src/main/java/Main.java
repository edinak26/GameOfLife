import field.FileReader;
import field.InputParser;

public class Main {
    public static void main(String[] args){
        //field.InputValidator validator = new field.InputValidator(field.FileReader.readInputFile());
        InputParser parser = new InputParser(FileReader.readInputFile());
        parser.parse();
        //validator.validate();
    }
}
