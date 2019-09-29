package game.input.exceptions;

import static game.GameConstants.*;
import static game.input.validator.Constants.MINIMAL_INPUT_FILE_LINES_NUMBER;

public interface ExceptionMessages {
    String DEFAULT_INCORRECT_FILE_FORMAT = "\nIncorrect format in input.txt ";
    String NULL_INPUT_FILE = "input file does not exist";
    String INCORRECT_FILE_LINES_NUMBER = "minimal number of lines in input.txt is " + MINIMAL_INPUT_FILE_LINES_NUMBER;
    String INCORRECT_SIZE_LINE_FORMAT = "size line format (only two numbers)";
    String INCORRECT_ITERATIONS_LINE_FORMAT = "iterations line format (only one number)";
    String INCORRECT_GRID_CHARACTERS_IN = "grid characters (only "+DEAD_CELL_CHARACTER+" or "+LIVE_CELL_CHARACTER+") in line ";
    String INCORRECT_GRID_WIDTH_IN = "grid width (all lines must have same width) in line ";

    String DEFAULT_INCORRECT_FILE_DATA = "\nIncorrect data in input.txt ";
    String INCORRECT_HEIGHT_VALUE = "height must be positive number";
    String INCORRECT_WIDTH_VALUE = "height must be positive number";
    String INCORRECT_INPUT_GRID_SIZE = "input grid must fir result grid";
}
