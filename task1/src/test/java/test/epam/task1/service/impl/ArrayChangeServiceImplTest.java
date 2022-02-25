package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.impl.ArrayChangeServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayChangeServiceImplTest {
    ArrayChangeServiceImpl changeService = new ArrayChangeServiceImpl();

    @DataProvider(name = "dataForReplaceAll")
    public Object[][] createDataForReplaceAll() {
        Object[][] data = new Object[4][4];
        data[0] = new Object[]{
                new CustomArray(1, 2, -9, 8),
                2,
                888,
                new CustomArray(1, 888, -9, 8)
        };
        data[1] = new Object[]{
                new CustomArray(1, 2, -9, 1),
                1,
                1000,
                new CustomArray(1000, 2, -9, 1000)
        };
        data[2] = new Object[]{
                new CustomArray(),
                1,
                1000,
                new CustomArray()
        };
        data[3] = new Object[]{
                new CustomArray(2, 2, 2, 2),
                1,
                1000,
                new CustomArray(2, 2, 2, 2)
        };
        return data;
    }

    @DataProvider(name = "dataForReplaceAllGreater")
    public Object[][] createDataForReplaceAllGreaterThanValue() {
        Object[][] data = new Object[4][4];
        data[0] = new Object[]{
                new CustomArray(1, 2, -9, 8),
                -9,
                888,
                new CustomArray(888, 888, -9, 888)
        };
        data[1] = new Object[]{
                new CustomArray(1, 2, -9, 1),
                10,
                1000,
                new CustomArray(1, 2, -9, 1)
        };
        data[2] = new Object[]{
                new CustomArray(),
                1,
                1000,
                new CustomArray()
        };
        data[3] = new Object[]{
                new CustomArray(2, 2, 2, 1),
                1,
                77,
                new CustomArray(77, 77, 77, 1)
        };
        return data;
    }

    @DataProvider(name = "dataForReplaceAllLess")
    public Object[][] createDataForReplaceAllLessThanValue() {
        Object[][] data = new Object[3][4];
        data[0] = new Object[]{
                new CustomArray(1, 2, -9, 8),
                -9,
                888,
                new CustomArray(1, 2, -9, 8)
        };
        data[1] = new Object[]{
                new CustomArray(1, 2, 20, -9, 1),
                10,
                1000,
                new CustomArray(1000, 1000, 20, 1000, 1000)
        };
        data[2] = new Object[]{
                new CustomArray(),
                1,
                1000,
                new CustomArray()
        };
        return data;
    }

    @DataProvider(name = "dataForReplaceAllNegative")
    public Object[][] createDataForReplaceNegative() {
        Object[][] data = new Object[3][3];
        data[0] = new Object[]{
                new CustomArray(-125, 2, -9, -89),
                0,
                new CustomArray(0, 2, 0, 0)
        };
        data[1] = new Object[]{
                new CustomArray(0, 0, 0, -874, 0),
                1000,
                new CustomArray(0, 0, 0, 1000, 0)
        };
        data[2] = new Object[]{
                new CustomArray(),
                1000,
                new CustomArray()
        };
        return data;
    }

    @DataProvider(name = "dataForReplaceAllInInterval")
    public Object[][] createDataForReplaceAllInInterval() {
        Object[][] data = new Object[3][5];
        data[0] = new Object[]{
                new CustomArray(1, 2, 3, 4),
                1,
                2,
                999,
                new CustomArray(1, 999, 999, 4)
        };
        data[1] = new Object[]{
                new CustomArray(1, 2, 3, 4, 5),
                0,
                5,
                1000,
                new CustomArray(1000, 1000, 1000, 1000, 1000)
        };
        data[2] = new Object[]{
                new CustomArray(),
                0,
                0,
                888,
                new CustomArray()
        };
        return data;
    }

    @Test(dataProvider = "dataForReplaceAll")
    public void testReplaceAll(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAll(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForReplaceAllGreater")
    public void testReplaceAllGreaterThanValue(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllGreaterThanValue(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForReplaceAllLess")
    public void testReplaceAllLessThanValue(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllLessThanValue(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForReplaceAllNegative")
    public void testReplaceAllNegative(CustomArray actual, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllNegative(actual, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForReplaceAllInInterval")
    public void testReplaceAllInInterval(CustomArray actual, int startIndex, int intervalLength, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllInInterval(actual, startIndex, intervalLength, replacement);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNull() throws CustomArrayException {
        changeService.replaceAll(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllException() throws CustomArrayException {
        changeService.replaceAll(new CustomArray(null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueNull() throws CustomArrayException {
        changeService.replaceAllGreaterThanValue(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueException() throws CustomArrayException {
        changeService.replaceAllGreaterThanValue(new CustomArray(null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueNull() throws CustomArrayException {
        changeService.replaceAllLessThanValue(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueException() throws CustomArrayException {
        changeService.replaceAllLessThanValue(new CustomArray(null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeNull() throws CustomArrayException {
        changeService.replaceAllNegative(null, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeException() throws CustomArrayException {
        changeService.replaceAllNegative(new CustomArray(null), 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllInIntervalNull() throws CustomArrayException {
        changeService.replaceAllInInterval(null, 0, 0,  100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllInIntervalException() throws CustomArrayException {
        changeService.replaceAllInInterval(new CustomArray(null), 0, 0, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllInIntervalNegativeStartIndex() throws CustomArrayException {
        changeService.replaceAllInInterval(new CustomArray(1, 2, 3, 4), -1, 2, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllInIntervalNegativeIntervalLengthIndex() throws CustomArrayException {
        changeService.replaceAllInInterval(new CustomArray(1, 2, 3, 4), 1, -1, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllInIntervalTooMuchIntervalLength() throws CustomArrayException {
        changeService.replaceAllInInterval(new CustomArray(1, 2, 3, 4), 1, 4, 100);
    }
}
