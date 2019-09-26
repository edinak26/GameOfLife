import field.read.FileReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void readFileByPath() {
        List<String> actual = FileReader.read("src/test/resources/reader/test.txt");

        List<String> expected = Arrays.asList("test","text");

        assertEquals(actual,expected);
    }

    @Test
    public void readUndefinedFile(){
        List<String> actual = FileReader.read("someUndefinedFile.txt");

        assertNull(actual);
    }

    @Test
    public void readIncorrectPathFile(){
        List<String> actual = FileReader.read("!@#$%^&*(");

        assertNull(actual);
    }
}