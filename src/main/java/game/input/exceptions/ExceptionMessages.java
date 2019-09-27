package game.input.exceptions;

public interface ExceptionMessages {
    String DEFAULT_INCORRECT_FILE_FORMAT = "\nIncorrect format in input.txt ";
    String INCORRECT_SIZE_LINE_FORMAT = "size line format (only two numbers)";
    String INCORRECT_ITERATIONS_LINE_FORMAT = "iterations line format (only one number)";
    String INCORRECT_GRID_CHARACTERS_IN = "grid characters (only X or O) in line ";
    String INCORRECT_GRID_WIDTH_IN = "grid width (all lines must have same width) in line ";

    String DEFAULT_INCORRECT_FILE_DATA = "\nIncorrect data in input.txt ";
    String INCORRECT_INPUT_GRID_SIZE = "input grid must fir result grid";
}
