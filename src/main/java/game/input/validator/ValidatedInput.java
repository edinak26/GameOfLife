package game.input.validator;

import java.util.List;

public interface ValidatedInput {
    List<String> getInputGridLines();
    String getSizeLine();
    String getIterationsLine();
}
