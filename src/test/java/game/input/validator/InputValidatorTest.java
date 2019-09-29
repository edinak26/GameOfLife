package game.input.validator;

import game.input.exceptions.IncorrectInputFileFormatException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputValidatorTest {
    private InputValidator validator;

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_nullList() throws IncorrectInputFileFormatException {
        validator = new Validator(null);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_emptyList() throws IncorrectInputFileFormatException {
        List<String> emptyList = new ArrayList<>();

        validator = new Validator(emptyList);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_smallList() throws IncorrectInputFileFormatException {
        List<String> smallList = Arrays.asList("1","2");

        validator = new Validator(smallList);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_incorrectSizeLine_empty() throws IncorrectInputFileFormatException {
        List<String> inputList = Arrays.asList("","2","O");

        validator = new Validator(inputList);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_incorrectSizeLine_character() throws IncorrectInputFileFormatException {
        List<String> inputList = Arrays.asList("******","2","O");

        validator = new Validator(inputList);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_incorrectSizeLine_negative() throws IncorrectInputFileFormatException {
        List<String> inputList = Arrays.asList("-1 2","2","O");

        validator = new Validator(inputList);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_incorrectIterationsLine_empty() throws IncorrectInputFileFormatException {
        List<String> inputList = Arrays.asList("1 2","","O");

        validator = new Validator(inputList);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_incorrectIterationsLine() throws IncorrectInputFileFormatException {
        List<String> inputList = Arrays.asList("1 2","******","O");

        validator = new Validator(inputList);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_incorrectGridLines_characters() throws IncorrectInputFileFormatException {
        List<String> inputList = Arrays.asList("1 2","2","******");

        validator = new Validator(inputList);
        validator.validate();
    }

    @Test(expected = IncorrectInputFileFormatException.class)
    public void validate_incorrectGridLines_linesLength() throws IncorrectInputFileFormatException {
        List<String> inputList = Arrays.asList("1 2","2","OO","O");

        validator = new Validator(inputList);
        validator.validate();
    }
}