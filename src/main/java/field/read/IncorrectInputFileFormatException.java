package field.read;

import field.read.ValidateMessages;

public class IncorrectInputFileFormatException extends Exception implements ValidateMessages {
    public IncorrectInputFileFormatException(String message){
        super(DEFAULT_INCORRECT_FILE_FORMAT+message);
    }
}
