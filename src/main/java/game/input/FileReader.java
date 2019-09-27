package game.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private static final String INPUT_FILE_PATH = "src\\main\\resources\\input.txt";

    public static List<String> readInputFile() throws IOException {
        return read(INPUT_FILE_PATH);
    }

    public static List<String> read(String path) throws IOException {
        return readFile(path);
    }

    private static List<String> readFile(String path) throws IOException{
        return Files.readAllLines(Paths.get(path));
    }
}
