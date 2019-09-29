package game;

import game.entities.Grid;
import game.input.parser.InputParser;
import game.input.parser.Parser;
import game.input.parser.ParsedInput;
import game.input.validator.InputValidator;
import game.input.validator.Validator;
import game.input.validator.ValidatedInput;
import game.output.Writer;
import game.input.*;
import game.input.exceptions.IncorrectInputFileDataException;
import game.input.exceptions.IncorrectInputFileFormatException;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Collections;
import java.util.List;

public class GameController {
    private final Game game;

    public GameController() throws Exception {
        List<String> input = readInput();
        ParsedInput parsedInput = parseInput(input);
        this.game = initGame(parsedInput);
    }

    private List<String> readInput() throws Exception {
        try {
            return FileReader.readInputFile();
        } catch (IOException | InvalidPathException e) {
            writeMessageToOutputFile(e.getMessage());
            throw e;
        }
    }

    private ParsedInput parseInput(List<String> input) throws Exception {
        try {
            return getParsedInput(input);
        } catch (IncorrectInputFileFormatException | IncorrectInputFileDataException e) {
            writeMessageToOutputFile(e.getMessage());
            throw e;
        }
    }

    private ParsedInput getParsedInput(List<String> input) throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        InputValidator validator = new Validator(input);
        ValidatedInput validatedInput = validator.validate();
        InputParser parser = new Parser(validatedInput);
        return parser.parse();
    }

    private Game initGame(ParsedInput parsedInput) {
        Grid inputGrid = new Grid(parsedInput.getInputGrid());
        Grid initialGrid = new Grid(inputGrid, parsedInput.getHeight(), parsedInput.getWidth());
        return new Game(initialGrid, parsedInput.getIterations());
    }





    public GameController(String inputFilePath) throws Exception {
        List<String> input = read(inputFilePath);
        ParsedInput parsedInput = parseInput(input);
        this.game = initGame(parsedInput);
    }

    private List<String> read(String path) throws Exception {
        try {
            return FileReader.read(path);
        } catch (IOException | InvalidPathException e) {
            writeMessageToOutputFile(e.getMessage());
            throw e;
        }
    }



    public void calcResultGrid(){
        game.calcResultGrid();
    }

    public void saveGrid() throws IOException {
        writeGridToOutputFile(game.getGrid());
    }

    private void writeGridToOutputFile(Grid grid) throws IOException {
        Writer.writeOutputFile(grid.toStringList());
    }

    private void writeMessageToOutputFile(String message) throws IOException {
        Writer.writeOutputFile(Collections.singletonList(message));
    }

    public List<String> getGrid(){
        return game.getGrid().toStringList();
    }
}
