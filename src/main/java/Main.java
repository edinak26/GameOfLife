import field.Grid;
import field.Writer;
import field.read.FileReader;
import field.read.InputParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        InputParser parser = new InputParser(FileReader.readInputFile());
        parser.parse();
        Grid inputGrid = new Grid(parser.getInputGrid());
        Grid grid = new Grid(inputGrid,parser.getHeight(),parser.getWidth());
        grid.print();
        Game field = new Game(grid,parser.getIterations());
        Grid resultGrid = field.calcResultGrid();
        System.out.println();
        resultGrid.print();

    }
}
