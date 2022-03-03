package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.impl.ArrayChangeServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayChangeServiceImplTest {
    ArrayChangeServiceImpl changeService = new ArrayChangeServiceImpl();

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
        changeService.replaceAll(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllGreater")
    public void testReplaceAllGreaterThanValue(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllGreaterThanValue(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllLess")
    public void testReplaceAllLessThanValue(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllLessThanValue(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllNegative")
    public void testReplaceAllNegative(CustomArray actual, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllNegative(actual, replacement);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNull() throws CustomArrayException {
        changeService.replaceAll(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllException() throws CustomArrayException {
        changeService.replaceAll(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueNull() throws CustomArrayException {
        changeService.replaceAllGreaterThanValue(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueException() throws CustomArrayException {
        changeService.replaceAllGreaterThanValue(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueNull() throws CustomArrayException {
        changeService.replaceAllLessThanValue(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueException() throws CustomArrayException {
        changeService.replaceAllLessThanValue(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeNull() throws CustomArrayException {
        changeService.replaceAllNegative(null, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeException() throws CustomArrayException {
        changeService.replaceAllNegative(new CustomArray((int[]) null), 100);
    }

    @Test(dataProvider = "data_for_replaceAllStream")
    public void testReplaceAllStream(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAll(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllGreaterStream")
    public void testReplaceAllGreaterThanValueStream(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllGreaterThanValueStream(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllLessStream")
    public void testReplaceAllLessThanValueStream(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllLessThanValueStream(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_replaceAllNegativeStream")
    public void testReplaceAllNegativeStream(CustomArray actual, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAllNegativeStream(actual, replacement);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllStreamNull() throws CustomArrayException {
        changeService.replaceAllStream(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllStreamException() throws CustomArrayException {
        changeService.replaceAllStream(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueStreamNull() throws CustomArrayException {
        changeService.replaceAllGreaterThanValueStream(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllGreaterThanValueStreamException() throws CustomArrayException {
        changeService.replaceAllGreaterThanValueStream(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueStreamNull() throws CustomArrayException {
        changeService.replaceAllLessThanValueStream(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllLessThanValueStreamException() throws CustomArrayException {
        changeService.replaceAllLessThanValueStream(new CustomArray((int[]) null), 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeStreamNull() throws CustomArrayException {
        changeService.replaceAllNegativeStream(null, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNegativeStreamException() throws CustomArrayException {
        changeService.replaceAllNegativeStream(new CustomArray((int[]) null), 100);
    }
}
