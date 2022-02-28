package test.epam.task1.parser;

import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.parser.impl.ArrayParserImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.epam.task1.checker.EqualsChecker;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ArrayParserImplTest {
    ArrayParserImpl parser = new ArrayParserImpl();

    @DataProvider(name = "correct_parse_data")
    public Object[][] createCorrectParseData() {
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

    @DataProvider(name = "incorrect_parse_data")
    public Object[][] createIncorrectParseData() {
        Object[][] data = new Object[6][1];
        data[0] = new Object[]{
                "4; -5; -3; 1o4; 4"
        };
        data[1] = new Object[]{
                "14 -100 0"
        };
        data[2] = new Object[]{
                "-- 78"
        };
        data[3] = new Object[]{
                "+44"
        };
        data[4] = new Object[]{
                "8-"
        };
        data[5] = new Object[]{
                ",      "
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

    @DataProvider(name = "correct_parse_data_for_stream")
    public Object[][] createCorrectParseDataForStream() {
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

    @DataProvider(name = "incorrect_parse_data_for_stream")
    public Object[][] createIncorrectParseDataForStream() {
        Object[][] data = new Object[6][1];
        data[0] = new Object[]{
                "4; -5; -3; 1o4; 4"
        };
        data[1] = new Object[]{
                "14 -100 0"
        };
        data[2] = new Object[]{
                "-- 78"
        };
        data[3] = new Object[]{
                "+44"
        };
        data[4] = new Object[]{
                "8-"
        };
        data[5] = new Object[]{
                ",      "
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

    public List<String> createLineListWithIncorrectData() {
        List<String> lines = new ArrayList<>();
        lines.add("4; -5; -3; 14; 4");
        lines.add("   14 ; -  ; 0    ");
        lines.add("- 78");
        return lines;
    }

    @Test(dataProvider = "correct_parse_data")
    public void testParse(String line, int[] expected) throws CustomArrayException {
        int[] actual = parser.parse(line);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "incorrect_parse_data", expectedExceptions = CustomArrayException.class)
    public void testParseIncorrectLine(String line) throws CustomArrayException {
        parser.parse(line);
    }

    @Test(dataProvider = "parseAll_data")
    public void testParseAll(List<String> lines, List<int[]> expected) throws CustomArrayException {
        List<int[]> actual = parser.parseAll(lines);
        EqualsChecker comparator = new EqualsChecker();
        assertTrue(comparator.areEqualsListsOfArrays(expected, actual));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testParseAllListWithIncorrectLine() throws CustomArrayException {
        parser.parseAll(createLineListWithIncorrectData());
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testParseNull() throws CustomArrayException {
        parser.parse(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testParseAllNull() throws CustomArrayException {
        parser.parseAll(null);
    }

    @Test(dataProvider = "correct_parse_data_for_stream")
    public void testParseStream(String line, int[] expected) throws CustomArrayException {
        int[] actual = parser.parseStream(line);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "incorrect_parse_data_for_stream", expectedExceptions = CustomArrayException.class)
    public void testParseIncorrectLineStream(String line) throws CustomArrayException {
        parser.parseStream(line);
    }

    @Test(dataProvider = "parseAllStream_data")
    public void testParseAllStream(List<String> lines, List<int[]> expected) throws CustomArrayException {
        List<int[]> actual = parser.parseAllStream(lines);
        EqualsChecker comparator = new EqualsChecker();
        assertTrue(comparator.areEqualsListsOfArrays(expected, actual));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testParseAllListWithIncorrectLineStream() throws CustomArrayException {
        parser.parseAllStream(createLineListWithIncorrectData());
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testParseStreamNull() throws CustomArrayException {
        parser.parseStream(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testParseAllStreamNull() throws CustomArrayException {
        parser.parseAllStream(null);
    }

}
