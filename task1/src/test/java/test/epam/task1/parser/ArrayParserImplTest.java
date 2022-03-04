package test.epam.task1.parser;

import com.epam.task1.parser.impl.ArrayParserImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.epam.task1.checker.EqualsChecker;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ArrayParserImplTest {
    public static final ArrayParserImpl PARSER = new ArrayParserImpl();

    @DataProvider(name = "parse_data")
    public Object[][] createParseData() {
        Object[][] data = new Object[6][2];
        data[0] = new Object[]{
                "4; -5; -3; 14; 4",
                new int[]{4, -5, -3, 14, 4}
        };
        data[1] = new Object[]{
                "   14 ; -  100   ; 0    ",
                new int[]{14, -100, 0}
        };
        data[2] = new Object[]{
                "- 78",
                new int[]{-78}
        };
        data[3] = new Object[]{
                "44",
                new int[]{44}
        };
        data[4] = new Object[]{
                "",
                new int[0]
        };
        data[5] = new Object[]{
                "      ",
                new int[0]
        };
        return data;
    }

    @DataProvider(name = "parseAll_data")
    public Object[][] createParseAllData() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                createLinesList(),
                createArraysList()
        };
        data[1] = new Object[]{
                new ArrayList<String>(),
                new ArrayList<int[]>()
        };
        return data;
    }

    @DataProvider(name = "parse_data_for_stream")
    public Object[][] createParseDataForStream() {
        Object[][] data = new Object[6][2];
        data[0] = new Object[]{
                "4; -5; -3; 14; 4",
                new int[]{4, -5, -3, 14, 4}
        };
        data[1] = new Object[]{
                "   14 ; -  100   ; 0    ",
                new int[]{14, -100, 0}
        };
        data[2] = new Object[]{
                "- 78",
                new int[]{-78}
        };
        data[3] = new Object[]{
                "44",
                new int[]{44}
        };
        data[4] = new Object[]{
                "",
                new int[0]
        };
        data[5] = new Object[]{
                "      ",
                new int[0]
        };
        return data;
    }

    @DataProvider(name = "parseAllStream_data")
    public Object[][] createParseAllStreamData() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                createLinesList(),
                createArraysList()
        };
        data[1] = new Object[]{
                new ArrayList<String>(),
                new ArrayList<int[]>()
        };
        return data;
    }

    public List<String> createLinesList() {
        List<String> lines = new ArrayList<>();
        lines.add("4; -5; -3; 14; 4");
        lines.add("   14 ; -  100   ; 0    ");
        lines.add("- 78");
        lines.add("44");
        lines.add("");
        lines.add("      ");
        return lines;
    }

    public List<int[]> createArraysList() {
        List<int[]> arrays = new ArrayList<>();
        arrays.add(new int[]{4, -5, -3, 14, 4});
        arrays.add(new int[]{14, -100, 0});
        arrays.add(new int[]{-78});
        arrays.add(new int[]{44});
        arrays.add(new int[0]);
        arrays.add(new int[0]);
        return arrays;
    }

    @Test(dataProvider = "parse_data")
    public void testParse(String line, int[] expected) {
        int[] actual = PARSER.parse(line);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "parseAll_data")
    public void testParseAll(List<String> lines, List<int[]> expected) {
        List<int[]> actual = PARSER.parseAll(lines);
        EqualsChecker comparator = new EqualsChecker();
        assertTrue(comparator.areEqualsListsOfArrays(expected, actual));
    }

    @Test(dataProvider = "parse_data_for_stream")
    public void testParseStream(String line, int[] expected) {
        int[] actual = PARSER.parseStream(line);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "parseAllStream_data")
    public void testParseAllStream(List<String> lines, List<int[]> expected) {
        List<int[]> actual = PARSER.parseAllStream(lines);
        EqualsChecker comparator = new EqualsChecker();
        assertTrue(comparator.areEqualsListsOfArrays(expected, actual));
    }

}
