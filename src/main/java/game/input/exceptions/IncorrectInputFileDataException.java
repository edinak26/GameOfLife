package game.input.exceptions;

import static game.input.exceptions.ExceptionMessages.DEFAULT_INCORRECT_FILE_DATA;

public class IncorrectInputFileDataException extends Exception{
    public IncorrectInputFileDataException(String message){
        super(DEFAULT_INCORRECT_FILE_DATA+message);
    }
}
