package field;

import field.ValidateMessages;

public class IncorrectInputFileFormatException extends RuntimeException implements ValidateMessages {
    public IncorrectInputFileFormatException(String message){
        super(DEFAULT_INCORRECT_FILE_FORMAT+message);
    }
}
