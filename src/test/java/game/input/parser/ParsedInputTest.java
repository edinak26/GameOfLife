package game.input.parser;

import game.input.exceptions.IncorrectInputFileDataException;
import game.input.exceptions.IncorrectInputFileFormatException;
import game.input.validator.ValidatedInput;
import game.input.validator.Validator;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ParsedInputTest {
    private ParsedInput parsedInput;

    @Before
    public void initValidatedInput() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        List<String> fileInput = Arrays.asList("3 4", "100", "XX", "XO", "OO");

        Validator validator = new Validator(fileInput);
        ValidatedInput input = validator.validate();
        InputParser parser = new Parser(input);
        parsedInput = parser.parse();
    }

    @Test
    public void getHeight() {
        int actual = parsedInput.getHeight();

        int expected = 3;

        assertEquals(actual,expected);
    }

    @Test
    public void getWidth() {
        int actual = parsedInput.getWidth();

        int expected = 4;

        assertEquals(actual,expected);
    }

    @Test
    public void getIterations() {
        int actual = parsedInput.getIterations();

        int expected = 100;

        assertEquals(actual,expected);
    }

    @Test
    public void getInputGrid() {
        List<String[]> actual = parsedInput.getInputGrid();

        List<String[]> expected = Arrays.asList(
                new String[]{"X","X"},
                new String[]{"X","O"},
                new String[]{"O","O"}
                );

        for(int i = 0; i<expected.size();i++){
            for(int j = 0; j<expected.get(0).length;j++){
                assertEquals(expected.get(i)[j],actual.get(i)[j]);
            }
        }
    }




}