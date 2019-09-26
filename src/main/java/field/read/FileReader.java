package field.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private static final String INPUT_FILE_PATH = "src\\main\\resources\\input.txt";
    private static final String OUTPUT_FILE_PATH = "src\\main\\resources\\output.txt";

    public static List<String> readInputFile(){
        return read(INPUT_FILE_PATH);
    }

    public static List<String> read(String path){
        try {
            return readFile(path);
        } catch (IOException | InvalidPathException e) {
            return null;
        }
    }

    private static List<String> readFile(String path) throws IOException, InvalidPathException {
        return Files.readAllLines(Paths.get(path));
    }
}
