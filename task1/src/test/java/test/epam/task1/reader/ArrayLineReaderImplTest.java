package test.epam.task1.reader;

import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.reader.impl.ArrayLineReaderImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ArrayLineReaderImplTest {
    ArrayLineReaderImpl arrayLineReader = new ArrayLineReaderImpl();

    @DataProvider(name="filesData")
    public Object[][] createData(){
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
                this.getClass().getClassLoader().getResource("testArraysFileWithOnlyCorrectLines.txt").toString().substring(6),
                linesFromFileWithOnlyCorrectLines
        };
        data[1] = new Object[]{
                this.getClass().getClassLoader().getResource("testArraysFileOnlyWithOneCorrectLine.txt").toString().substring(6),
                linesFromFileOnlyWithOneCorrectLine
        };
        data[2] = new Object[]{
                this.getClass().getClassLoader().getResource("testArraysFileWithLastCorrectLine.txt").toString().substring(6),
                linesFromFileWithLastCorrectLine
        };
        data[3] = new Object[]{
                this.getClass().getClassLoader().getResource("testEmptyFile.txt").toString().substring(6),
                emptyList
        };
        data[4] = new Object[]{
                this.getClass().getClassLoader().getResource("testArraysFileWithOnlyIncorrectLines.txt").toString().substring(6),
                emptyList
        };
        return data;
    }

    @Test(dataProvider = "filesData")
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
    public void testReadAllArrayLinesFileNotExists() throws CustomArrayException {
        File file = new File("notExists.txt");
        String fileName = file.getAbsolutePath();
        file.delete();
        arrayLineReader.readAllArrayLines(fileName);
    }
}

