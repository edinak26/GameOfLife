import field.read.FileReader;
import field.read.InputParser;

public class Main {
    public static void main(String[] args){
        //field.read.InputValidator validator = new field.read.InputValidator(field.read.FileReader.readInputFile());
        InputParser parser = new InputParser(FileReader.readInputFile());
        parser.parse();
        //new GameField(parser.getHeight(),parser.getWidth(),parser.getInputGrid());
        //validator.validate();
    }
}
