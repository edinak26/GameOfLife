package game;

import game.entities.Grid;
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
            InputParser parser = new InputParser(input);
            return parser.parse();
        } catch (IncorrectInputFileFormatException | IncorrectInputFileDataException e) {
            writeMessageToOutputFile(e.getMessage());
            throw e;
        }
    }

    private Game initGame(ParsedInput parsedInput) {
        Grid inputGrid = new Grid(parsedInput.getInputGrid());
        Grid initialGrid = new Grid(inputGrid, parsedInput.getHeight(), parsedInput.getWidth());
        return new Game(initialGrid, parsedInput.getIterations());
    }

    public void calcOutputGrid(){
        game.calcResultGrid();
    }

    public void saveResult() throws IOException {
        writeGridToOutputFile(game.getGrid());
    }

    private void writeGridToOutputFile(Grid grid) throws IOException {
        Writer.writeOutputFile(grid.toStringList());
    }

    private void writeMessageToOutputFile(String message) throws IOException {
        Writer.writeOutputFile(Collections.singletonList(message));
    }
}
