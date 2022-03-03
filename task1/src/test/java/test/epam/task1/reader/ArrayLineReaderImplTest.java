package test.epam.task1.reader;

import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.reader.impl.ArrayLineReaderImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ArrayLineReaderImplTest {
    public static final String FILE_WITH_ONLY_CORRECT_LINES_NAME;
    public static final String FILE_ONLY_WITH_ONE_CORRECT_LINE_NAME;
    public static final String FILE_WITH_LAST_CORRECT_LINE_NAME;
    public static final String EMPTY_FILE_NAME;
    public static final String FILE_WITH_ONLY_INCORRECT_LINES_NAME;

    ArrayLineReaderImpl arrayLineReader = new ArrayLineReaderImpl();

    static {
        ClassLoader loader = ArrayLineReaderImplTest.class.getClassLoader();
        URL currentURL = loader.getResource("testArraysFileWithOnlyCorrectLines.txt");
        if (currentURL == null) {
            fail("Test file URL equals null");
        }
        FILE_WITH_ONLY_CORRECT_LINES_NAME = currentURL.toString().substring(6);
        currentURL = loader.getResource("testArraysFileOnlyWithOneCorrectLine.txt");
        if (currentURL == null) {
            fail("Test file URL equals null");
        }
        FILE_ONLY_WITH_ONE_CORRECT_LINE_NAME = currentURL.toString().substring(6);
        currentURL = loader.getResource("testArraysFileWithLastCorrectLine.txt");
        if (currentURL == null) {
            fail("Test file URL equals null");
        }
        FILE_WITH_LAST_CORRECT_LINE_NAME = currentURL.toString().substring(6);
        currentURL = loader.getResource("testEmptyFile.txt");
        if (currentURL == null) {
            fail("Test file URL equals null");
        }
        EMPTY_FILE_NAME = currentURL.toString().substring(6);
        currentURL = loader.getResource("testArraysFileWithOnlyIncorrectLines.txt");
        if (currentURL == null) {
            fail("Test file URL equals null");
        }
        FILE_WITH_ONLY_INCORRECT_LINES_NAME = currentURL.toString().substring(6);

    }

    @DataProvider(name = "files_data")
    public Object[][] createData() {
        List<String> linesFromFileWithOnlyCorrectLines = new ArrayList<>();
        linesFromFileWithOnlyCorrectLines.add("4; 63; 98; 74");
        linesFromFileWithOnlyCorrectLines.add("1");
        linesFromFileWithOnlyCorrectLines.add("");
        linesFromFileWithOnlyCorrectLines.add("");
        linesFromFileWithOnlyCorrectLines.add("987; 452    ; 1;         0");
        linesFromFileWithOnlyCorrectLines.add("- 5; -   7;  -10");
        List<String> linesFromFileOnlyWithOneCorrectLine = new ArrayList<>();
        linesFromFileOnlyWithOneCorrectLine.add("1 ; -5;    4; 6");
        List<String> linesFromFileWithLastCorrectLine = new ArrayList<>();
        linesFromFileWithLastCorrectLine.add("1; 2; 3; 4; 5");
        List<String> emptyList = new ArrayList<>();

        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                FILE_WITH_ONLY_CORRECT_LINES_NAME,
                linesFromFileWithOnlyCorrectLines
        };
        data[1] = new Object[]{
                FILE_ONLY_WITH_ONE_CORRECT_LINE_NAME,
                linesFromFileOnlyWithOneCorrectLine
        };
        data[2] = new Object[]{
                FILE_WITH_LAST_CORRECT_LINE_NAME,
                linesFromFileWithLastCorrectLine
        };
        data[3] = new Object[]{
                EMPTY_FILE_NAME,
                emptyList
        };
        data[4] = new Object[]{
                FILE_WITH_ONLY_INCORRECT_LINES_NAME,
                emptyList
        };
        return data;
    }

    @DataProvider(name = "files_data_stream")
    public Object[][] createDataStream() {
        List<String> linesFromFileWithOnlyCorrectLines = new ArrayList<>();
        linesFromFileWithOnlyCorrectLines.add("4; 63; 98; 74");
        linesFromFileWithOnlyCorrectLines.add("1");
        linesFromFileWithOnlyCorrectLines.add("");
        linesFromFileWithOnlyCorrectLines.add("");
        linesFromFileWithOnlyCorrectLines.add("987; 452    ; 1;         0");
        linesFromFileWithOnlyCorrectLines.add("- 5; -   7;  -10");
        List<String> linesFromFileOnlyWithOneCorrectLine = new ArrayList<>();
        linesFromFileOnlyWithOneCorrectLine.add("1 ; -5;    4; 6");
        List<String> linesFromFileWithLastCorrectLine = new ArrayList<>();
        linesFromFileWithLastCorrectLine.add("1; 2; 3; 4; 5");
        List<String> emptyList = new ArrayList<>();

        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                FILE_WITH_ONLY_CORRECT_LINES_NAME,
                linesFromFileWithOnlyCorrectLines
        };
        data[1] = new Object[]{
                FILE_ONLY_WITH_ONE_CORRECT_LINE_NAME,
                linesFromFileOnlyWithOneCorrectLine
        };
        data[2] = new Object[]{
                FILE_WITH_LAST_CORRECT_LINE_NAME,
                linesFromFileWithLastCorrectLine
        };
        data[3] = new Object[]{
                EMPTY_FILE_NAME,
                emptyList
        };
        data[4] = new Object[]{
                FILE_WITH_ONLY_INCORRECT_LINES_NAME,
                emptyList
        };
        return data;
    }

    @Test(dataProvider = "files_data")
    public void testReadAllArrayLines(String fileName, List<String> expected) throws CustomArrayException {
        List<String> actual = arrayLineReader.readAllArrayLines(fileName);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadAllArrayLinesEmptyFileName() throws CustomArrayException {
        arrayLineReader.readAllArrayLines("");
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadAllArrayLinesNullFileName() throws CustomArrayException {
        arrayLineReader.readAllArrayLines(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadAllArrayLinesFileNotExists() throws CustomArrayException, IOException {
        File file = Files.createTempFile("notExists", ".txt").toFile();
        String fileName = file.getAbsolutePath();
        assertTrue(file.delete());
        arrayLineReader.readAllArrayLines(fileName);
    }

    @Test(dataProvider = "files_data_stream")
    public void testReadAllArrayLinesStream(String fileName, List<String> expected) throws CustomArrayException {
        List<String> actual = arrayLineReader.readAllArrayLinesStream(fileName);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadAllArrayLinesStreamEmptyFileName() throws CustomArrayException {
        arrayLineReader.readAllArrayLinesStream("");
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadAllArrayLinesStreamNullFileName() throws CustomArrayException {
        arrayLineReader.readAllArrayLinesStream(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadAllArrayLinesStreamFileNotExists() throws CustomArrayException, IOException {
        File file = Files.createTempFile("notExists", ".txt").toFile();
        String fileName = file.getAbsolutePath();
        assertTrue(file.delete());
        arrayLineReader.readAllArrayLinesStream(fileName);
    }
}

