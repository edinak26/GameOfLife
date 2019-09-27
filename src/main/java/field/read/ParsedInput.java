package field.read;

import java.util.List;

public interface ParsedInput {
    List<String[]> getInputGrid();
    int getHeight();
    int getWidth();
    int getIterations();
}
