package field;

public enum Cell {
    LIVE("O", 1),
    DEAD("X", 0);
    private String character;
    private int value;

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
}
