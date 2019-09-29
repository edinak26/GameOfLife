package game.input.parser;

import game.input.exceptions.IncorrectInputFileDataException;
import game.input.exceptions.IncorrectInputFileFormatException;
import game.input.validator.ValidatedInput;
import game.input.validator.Validator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InputParserTest {

    ValidatedInput input;
    InputParser parser;

    public void init(List<String> fileInput) throws IncorrectInputFileFormatException {
        Validator validator = new Validator(fileInput);
        input = validator.validate();
        parser = new Parser(input);
    }

    @Test(expected = NullPointerException.class)
    public void parse_nullInput() throws IncorrectInputFileDataException {
        parser = new Parser(null);
        parser.parse();
    }

    @Test(expected = IncorrectInputFileDataException.class)
    public void parse_incorrectHeight() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        init(Arrays.asList("0 2", "3", "O"));

        parser.parse();
    }

    @Test(expected = IncorrectInputFileDataException.class)
    public void parse_incorrectWidth() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        init(Arrays.asList("1 0", "3", "O"));

        parser.parse();
    }

    @Test(expected = IncorrectInputFileDataException.class)
    public void parse_incorrectSize() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        init(Arrays.asList("0 0", "3", "O"));

        parser.parse();
    }

    @Test(expected = IncorrectInputFileDataException.class)
    public void parse_incorrectInputFieldHeight() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        init(Arrays.asList("2 2", "0", "O", "O", "O"));

        parser.parse();
    }

    @Test(expected = IncorrectInputFileDataException.class)
    public void parse_incorrectInputFieldWidth() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        init(Arrays.asList("2 2", "0", "OOO"));

        parser.parse();
    }

    @Test(expected = IncorrectInputFileDataException.class)
    public void parse_incorrectInputFieldSize() throws IncorrectInputFileFormatException, IncorrectInputFileDataException {
        init(Arrays.asList("1 1", "0", "OOO", "OOO", "OOO", "OOO"));

        parser.parse();
    }
}