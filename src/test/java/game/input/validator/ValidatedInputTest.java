package game.input.validator;

import game.input.exceptions.IncorrectInputFileFormatException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ValidatedInputTest {
    private ValidatedInput validatedInput;

    @Before
    public void initValidatedInput() throws IncorrectInputFileFormatException {
        List<String> input = Arrays.asList("1 2", "3", "OXO", "XOX");

        InputValidator validator = new Validator(input);
        validatedInput = validator.validate();
    }

    @Test
    public void getInputGridLines() {
        String expected = "1 2";

        String actual = validatedInput.getSizeLine();

        assertEquals(expected, actual);
    }

    @Test
    public void getSizeLine() {
        String expected = "3";

        String actual = validatedInput.getIterationsLine();

        assertEquals(expected, actual);
    }

    @Test
    public void getIterationsLine() {
        List<String> expected = Arrays.asList("OXO", "XOX");

        List<String> actual = validatedInput.getInputGridLines();

        assertEquals(expected, actual);
    }
}