import field.Grid;
import field.Writer;
import field.read.*;

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
            writeMessage(e.getMessage());
            throw e;
        }
    }

    private ParsedInput parseInput(List<String> input) throws Exception {
        InputParser parser = new InputParser(input);
        try {
            parser.parse();
        } catch (IncorrectInputFileFormatException | IncorrectInputFileDataException e) {
            writeMessage(e.getMessage());
            throw e;
        }
        return parser;
    }

    private Game initGame(ParsedInput parsedInput) {
        Grid inputGrid = new Grid(parsedInput.getInputGrid());
        Grid initialGrid = new Grid(inputGrid, parsedInput.getHeight(), parsedInput.getWidth());
        return new Game(initialGrid, parsedInput.getIterations());
    }

    public void saveGrid(Grid grid) throws IOException {
        Writer.writeOutputFile(grid.toStringList());
    }

    private void writeMessage(String message) throws IOException {
        Writer.writeOutputFile(Collections.singletonList(message));
    }
}
