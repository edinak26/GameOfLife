package game.input.validator;

import static game.GameConstants.DEAD_CELL_CHARACTER;
import static game.GameConstants.LIVE_CELL_CHARACTER;

interface Constants {
    String SIZE_LINE_REGEX = "^[0-9]+ [0-9]+$";
    String ITERATIONS_LINE_REGEX = "^[0-9]+$";
    String FILED_LINE_REGEX = "^[" + LIVE_CELL_CHARACTER + DEAD_CELL_CHARACTER + "]+$";

    int GREED_FIRST_LINE_NUMBER = 3;
}
