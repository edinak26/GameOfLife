import field.Grid;
import field.read.FileReader;
import field.read.InputParser;

public class Main {
    public static void main(String[] args){
        InputParser parser = new InputParser(FileReader.readInputFile());
        parser.parse();
        Grid inputGrid = new Grid(parser.getInputGrid());
        Grid grid = new Grid(inputGrid,parser.getHeight(),parser.getWidth());
        grid.print();
        GameField field = new GameField(grid,1);
        Grid nextGrid = field.getNextIterationGrid();
        System.out.println();
        nextGrid.print();
    }
}
