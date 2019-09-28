package game.input.validator;

import game.input.exceptions.IncorrectInputFileFormatException;

public interface InputValidator {
    ValidatedInput validate() throws IncorrectInputFileFormatException;
}
