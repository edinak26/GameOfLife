package game;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class GameControllerTest {
    private static final String PATTERNS_PATH = "src/test/resources/game/patterns/";

    public List<String> calcResult(String path) throws Exception {
        GameController controller = new GameController(path);
        controller.calcResultGrid();
        return controller.getGrid();
    }

    public List<String> getAllLines(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    @Test
    public void block_4_4_i1() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "static/block/input 4-4 i1.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "static/block/output 4-4.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void block_4_4_i10() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "static/block/input 4-4 i10.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "static/block/output 4-4.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void block_5_5_i1() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "static/block/input 5-5 i1.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "static/block/output 5-5.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void block_5_5_i10() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "static/block/input 5-5 i10.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "static/block/output 5-5.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void beehive_5_6_i1() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "static/beehive/input 5-6 i1.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "static/beehive/output 5-6.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void beehive_5_6_i10() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "static/beehive/input 5-6 i10.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "static/beehive/output 5-6.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void blinker_3_3_i1() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "oscillators/blinker/input 3-3 i1.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "oscillators/blinker/output 3-3 i1.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void blinker_3_3_i2() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "oscillators/blinker/input 3-3 i2.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "oscillators/blinker/output 3-3 i2.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void blinker_3_6_i10() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "oscillators/blinker/input 3-6 i10.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "oscillators/blinker/output 3-6 i10.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void pentadecathlon_9_16_i0() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "oscillators/pentadecathlon/input 9-16 i0.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "oscillators/pentadecathlon/output 9-16 i0.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void pentadecathlon_9_16_i1() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "oscillators/pentadecathlon/input 9-16 i1.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "oscillators/pentadecathlon/output 9-16 i1.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void pentadecathlon_9_16_i9() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "oscillators/pentadecathlon/input 9-16 i9.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "oscillators/pentadecathlon/output 9-16 i9.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void pentadecathlon_9_16_i15() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "oscillators/pentadecathlon/input 9-16 i15.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "oscillators/pentadecathlon/output 9-16 i15.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void glider_5_5_i1() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "spaceships/glider/input 5-5 i1.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "spaceships/glider/output 5-5 i1.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void glider_5_5_i2() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "spaceships/glider/input 5-5 i2.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "spaceships/glider/output 5-5 i2.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void glider_5_5_i4() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "spaceships/glider/input 5-5 i4.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "spaceships/glider/output 5-5 i4.txt");

        assertEquals(actual, existed);
    }

    @Test
    public void glider_5_5_i20() throws Exception {
        List<String> actual = calcResult(PATTERNS_PATH + "spaceships/glider/input 5-5 i20.txt");

        List<String> existed = getAllLines(PATTERNS_PATH + "spaceships/glider/output 5-5 i20.txt");

        assertEquals(actual, existed);
    }
}