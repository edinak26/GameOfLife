package game.input.exceptions;

import static game.input.exceptions.ExceptionMessages.DEFAULT_INCORRECT_FILE_FORMAT;

public class IncorrectInputFileFormatException extends Exception{
    public IncorrectInputFileFormatException(String message){
        super(DEFAULT_INCORRECT_FILE_FORMAT+message);
    }
}
