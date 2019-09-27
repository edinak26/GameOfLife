package game.output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;

public class Writer {
    private static final String OUTPUT_FILE_PATH = "src\\main\\resources\\output.txt";

    public static void writeOutputFile(List<String> grid) throws IOException {
        write(OUTPUT_FILE_PATH, grid);
    }

    public static void write(String fileName, List<String> grid) throws IOException {
        if (Files.exists(Paths.get(fileName))) {
            Files.delete(Paths.get(fileName));
        }
        Files.write(Paths.get(fileName), grid, CREATE);
    }
}
