package game.input.parser;

import java.util.List;

public interface ParsedInput {
    List<String[]> getInputGrid();
    int getHeight();
    int getWidth();
    int getIterations();
}
