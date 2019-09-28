package game.entities;

import static game.GameConstants.DEAD_CELL_CHARACTER;
import static game.GameConstants.LIVE_CELL_CHARACTER;

public enum Cell {
    LIVE(LIVE_CELL_CHARACTER, 1),
    DEAD(DEAD_CELL_CHARACTER, 0);
    private final String character;
    private final int value;

    Cell(String character, int value) {
        this.character = character;
        this.value = value;
    }

    public static Cell valueOfCharacter(String character) {
        for (Cell cell : values()) {
            if (cell.character.equals(character))
                return cell;
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return this.character;
    }
}
