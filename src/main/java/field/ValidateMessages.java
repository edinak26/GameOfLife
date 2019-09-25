package field;

public interface ValidateMessages {
    String DEFAULT_INCORRECT_FILE_FORMAT = "\nIncorrect format of input.txt ";
    String INCORRECT_SIZE_LINE_FORMAT = "size line format (only two numbers)";
    String INCORRECT_ITERATIONS_LINE_FORMAT = "iterations line format (only one number)";
    String INCORRECT_FIELD_CHARACTERS_IN = "field characters (only X or O) in line ";
    String INCORRECT_FIELD_WIDTH_IN = "field width (all lines must have same width) in line ";
}
