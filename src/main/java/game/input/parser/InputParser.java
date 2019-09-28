package game.input.parser;

import game.input.exceptions.IncorrectInputFileDataException;

public interface InputParser {
    ParsedInput parse() throws IncorrectInputFileDataException;
}
