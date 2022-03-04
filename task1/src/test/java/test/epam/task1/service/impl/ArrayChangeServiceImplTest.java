package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.impl.ArrayChangeServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayChangeServiceImplTest {
    public static final ArrayChangeServiceImpl CHANGE_SERVICE = new ArrayChangeServiceImpl();

    @DataProvider(name = "data_for_replaceAll")
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

    @DataProvider(name = "data_for_replaceAllGreater")
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

    @DataProvider(name = "data_for_replaceAllLess")
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

    @DataProvider(name = "data_for_replaceAllNegative")
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

    @DataProvider(name = "data_for_replaceAllStream")
    public Object[][] createDataForReplaceAllStream() {
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

    @DataProvider(name = "data_for_replaceAllGreaterStream")
    public Object[][] createDataForReplaceAllGreaterThanValueStream() {
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

    @DataProvider(name = "data_for_replaceAllLessStream")
    public Object[][] createDataForReplaceAllLessThanValueStream() {
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

    @DataProvider(name = "data_for_replaceAllNegativeStream")
    public Object[][] createDataForReplaceNegativeStream() {
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

    @Test(dataProvider = "data_for_replaceAll")
    public void testReplaceAll(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        CHANGE_SERVICE.replaceAll(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllGreater")
    public void testReplaceAllGreaterThanValue(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        CHANGE_SERVICE.replaceAllGreaterThanValue(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllLess")
    public void testReplaceAllLessThanValue(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        CHANGE_SERVICE.replaceAllLessThanValue(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllNegative")
    public void testReplaceAllNegative(CustomArray actual, int replacement, CustomArray expected) throws CustomArrayException {
        CHANGE_SERVICE.replaceAllNegative(actual, replacement);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNull() throws CustomArrayException {
        CHANGE_SERVICE.replaceAll(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllException() throws CustomArrayException {
        CHANGE_SERVICE.replaceAll(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueNull() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllGreaterThanValue(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueException() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllGreaterThanValue(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueNull() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllLessThanValue(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueException() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllLessThanValue(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeNull() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllNegative(null, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeException() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllNegative(new CustomArray((int[]) null), 100);
    }

    @Test(dataProvider = "data_for_replaceAllStream")
    public void testReplaceAllStream(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        CHANGE_SERVICE.replaceAll(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllGreaterStream")
    public void testReplaceAllGreaterThanValueStream(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        CHANGE_SERVICE.replaceAllGreaterThanValueStream(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllLessStream")
    public void testReplaceAllLessThanValueStream(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        CHANGE_SERVICE.replaceAllLessThanValueStream(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllNegativeStream")
    public void testReplaceAllNegativeStream(CustomArray actual, int replacement, CustomArray expected) throws CustomArrayException {
        CHANGE_SERVICE.replaceAllNegativeStream(actual, replacement);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllStreamNull() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllStream(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllStreamException() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllStream(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueStreamNull() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllGreaterThanValueStream(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueStreamException() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllGreaterThanValueStream(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueStreamNull() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllLessThanValueStream(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueStreamException() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllLessThanValueStream(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeStreamNull() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllNegativeStream(null, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeStreamException() throws CustomArrayException {
        CHANGE_SERVICE.replaceAllNegativeStream(new CustomArray((int[]) null), 100);
    }
}
