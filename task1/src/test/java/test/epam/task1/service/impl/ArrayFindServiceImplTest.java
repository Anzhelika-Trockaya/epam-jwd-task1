package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.testng.Assert.*;

public class ArrayFindServiceImplTest {
    ArrayFindServiceImpl findService = new ArrayFindServiceImpl();

    @DataProvider(name = "data_for_findMax")
    public Object[][] createDataForFindMax() {
        Object[][] data = new Object[4][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, 1025, 1, -5, 5, -7000),
                1025
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                8
        };
        data[2] = new Object[]{
                new CustomArray(0, 8, 20),
                20
        };
        data[3] = new Object[]{
                new CustomArray(0, 0, 0),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findMin")
    public Object[][] createDataForFindMin() {
        Object[][] data = new Object[4][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, -1025, 1, -5, 5, 7000),
                -1025
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                4
        };
        data[2] = new Object[]{
                new CustomArray(0, 8, 20),
                0
        };
        data[3] = new Object[]{
                new CustomArray(0, 0, 0),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findSum")
    public Object[][] createDataForFindSum() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                new CustomArray(5, 6, 7, 10, 3),
                31
        };
        data[1] = new Object[]{
                new CustomArray(),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findNumPositive")
    public Object[][] createDataForFindNumPositive() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, -1025, 1, -5, 5, 7000),
                6
        };
        data[1] = new Object[]{
                new CustomArray(-8, -7, -6, -5, -4),
                0
        };
        data[2] = new Object[]{
                new CustomArray(),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findNumNegative")
    public Object[][] createDataForFindNumNegative() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(-5, 8, -6, 7, 1025, -1, -5, 5, -7000),
                5
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                0
        };
        data[2] = new Object[]{
                new CustomArray(),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findAverage")
    public Object[][] createDataForFindAverage() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(1, 3, 6, 7, 5, 3),
                4.1667
        };
        data[1] = new Object[]{
                new CustomArray(10),
                10
        };
        data[2] = new Object[]{
                new CustomArray(1, 5, 9),
                5
        };
        return data;
    }

    @DataProvider(name = "data_for_findMaxStream")
    public Object[][] createDataForFindMaxStream() {
        Object[][] data = new Object[4][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, 1025, 1, -5, 5, -7000),
                1025
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                8
        };
        data[2] = new Object[]{
                new CustomArray(0, 8, 20),
                20
        };
        data[3] = new Object[]{
                new CustomArray(0, 0, 0),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findMinStream")
    public Object[][] createDataForFindMinStream() {
        Object[][] data = new Object[4][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, -1025, 1, -5, 5, 7000),
                -1025
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                4
        };
        data[2] = new Object[]{
                new CustomArray(0, 8, 20),
                0
        };
        data[3] = new Object[]{
                new CustomArray(0, 0, 0),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findSumStream")
    public Object[][] createDataForFindSumStream() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                new CustomArray(5, 6, 7, 10, 3),
                31
        };
        data[1] = new Object[]{
                new CustomArray(),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findNumPositiveStream")
    public Object[][] createDataForFindNumPositiveStream() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, -1025, 1, -5, 5, 7000),
                6
        };
        data[1] = new Object[]{
                new CustomArray(-8, -7, -6, -5, -4),
                0
        };
        data[2] = new Object[]{
                new CustomArray(),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findNumNegativeStream")
    public Object[][] createDataForFindNumNegativeStream() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(-5, 8, -6, 7, 1025, -1, -5, 5, -7000),
                5
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                0
        };
        data[2] = new Object[]{
                new CustomArray(),
                0
        };
        return data;
    }

    @DataProvider(name = "data_for_findAverageStream")
    public Object[][] createDataForFindAverageStream() {
        Object[][] data = new Object[3][2];
        data[0] = new Object[]{
                new CustomArray(1, 3, 6, 7, 5, 3),
                4.1667
        };
        data[1] = new Object[]{
                new CustomArray(10),
                10
        };
        data[2] = new Object[]{
                new CustomArray(1, 5, 9),
                5
        };
        return data;
    }

    @Test(dataProvider = "data_for_findMax")
    public void testFindMax(CustomArray array, int expected) throws CustomArrayException {
        OptionalInt actualOptional = findService.findMax(array);
        if (actualOptional.isEmpty()) {
            fail("Optional is empty, expected=" + expected);
        }
        int actual = actualOptional.getAsInt();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findMin")
    public void testFindMin(CustomArray array, int expected) throws CustomArrayException {
        OptionalInt actualOptional = findService.findMin(array);
        if (actualOptional.isEmpty()) {
            fail("OptionalInt is empty, expected=" + expected);
        }
        int actual = actualOptional.getAsInt();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findSum")
    public void testFindSum(CustomArray array, int expected) throws CustomArrayException {
        int actual = findService.findSum(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findNumPositive")
    public void testFindNumberOfPositive(CustomArray array, int expected) throws CustomArrayException {
        int actual = findService.findNumberOfPositive(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findNumNegative")
    public void testFindNumberOfNegative(CustomArray array, int expected) throws CustomArrayException {
        int actual = findService.findNumberOfNegative(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findAverage")
    public void testFindAverage(CustomArray array, double expected) throws CustomArrayException {
        OptionalDouble actualOptional = findService.findAverage(array);
        if (actualOptional.isEmpty()) {
            fail("OptionalDouble is empty, expected=" + expected);
        }
        double actual = actualOptional.getAsDouble();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFindSumOverflow() {
        int[] intArray = new int[]{Integer.MAX_VALUE, 1};
        CustomArray array = new CustomArray(intArray);
        try {
            findService.findSum(array);
            fail("Test for findSum " + array
                    + " should have thrown a CustomArrayException");
        } catch (CustomArrayException exception) {
            String expectedMessage = "sum value is bigger than Integer.MAX_VALUE";
            String actualMessage = exception.getMessage();
            assertEquals(actualMessage, expectedMessage);
        }
    }

    @Test
    public void testFindAverageOverflow() {
        int[] intArray = new int[]{Integer.MAX_VALUE, 1};
        CustomArray array = new CustomArray(intArray);
        try {
            findService.findAverage(array);
            fail("Test for findAverage " + array
                    + " should have thrown a CustomArrayException");
        } catch (CustomArrayException exception) {
            String expectedMessage = "sum value is bigger than Integer.MAX_VALUE";
            String actualMessage = exception.getMessage();
            assertEquals(actualMessage, expectedMessage);
        }
    }

    @Test
    public void testFindMaxForEmptyArray() throws CustomArrayException {
        OptionalInt actual = findService.findMax(new CustomArray());
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindMinForEmptyArray() throws CustomArrayException {
        OptionalInt actual = findService.findMin(new CustomArray());
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindAverageForEmptyArray() throws CustomArrayException {
        OptionalDouble actual = findService.findAverage(new CustomArray());
        assertTrue(actual.isEmpty());
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMaxException() throws CustomArrayException {
        findService.findMax(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMinException() throws CustomArrayException {
        findService.findMin(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindSumException() throws CustomArrayException {
        findService.findSum(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindNumberOfPositiveException() throws CustomArrayException {
        findService.findNumberOfPositive(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindNumberOfNegativeException() throws CustomArrayException {
        findService.findNumberOfNegative(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindAverageException() throws CustomArrayException {
        findService.findAverage(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMaxForNull() throws CustomArrayException {
        findService.findMax(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMinForNull() throws CustomArrayException {
        findService.findMin(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindSumForNull() throws CustomArrayException {
        findService.findSum(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindNumberOfPositiveForNull() throws CustomArrayException {
        findService.findNumberOfPositive(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindNumberOfNegativeForNull() throws CustomArrayException {
        findService.findNumberOfNegative(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindAverageNull() throws CustomArrayException {
        findService.findAverage(null);
    }

    @Test(dataProvider = "data_for_findMaxStream")
    public void testFindMaxStream(CustomArray array, int expected) throws CustomArrayException {
        OptionalInt actualOptional = findService.findMaxStream(array);
        if (actualOptional.isEmpty()) {
            fail("OptionalInt is empty, expected=" + expected);
        }
        int actual = actualOptional.getAsInt();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findMinStream")
    public void testFindMinStream(CustomArray array, int expected) throws CustomArrayException {
        OptionalInt actualOptional = findService.findMinStream(array);
        if (actualOptional.isEmpty()) {
            fail("OptionalInt is empty, expected=" + expected);
        }
        int actual = actualOptional.getAsInt();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findSumStream")
    public void testFindSumOfElementsStream(CustomArray array, int expected) throws CustomArrayException {
        int actual = findService.findSumStream(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findNumPositiveStream")
    public void testFindNumberOfPositiveStream(CustomArray array, int expected) throws CustomArrayException {
        int actual = findService.findNumberOfPositiveStream(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findNumNegativeStream")
    public void testFindNumberOfNegativeStream(CustomArray array, int expected) throws CustomArrayException {
        int actual = findService.findNumberOfNegativeStream(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_findAverageStream")
    public void testFindAverageStream(CustomArray array, double expected) throws CustomArrayException {
        OptionalDouble actualOptional = findService.findAverageStream(array);
        if (actualOptional.isEmpty()) {
            fail("OptionalDouble is empty, expected=" + expected);
        }
        double actual = actualOptional.getAsDouble();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFindAverageStreamForEmptyArray() throws CustomArrayException {
        OptionalDouble actual = findService.findAverageStream(new CustomArray());
        assertSame(OptionalDouble.empty(), actual);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMaxElementStreamException() throws CustomArrayException {
        findService.findMaxStream(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMinElementStreamException() throws CustomArrayException {
        findService.findMinStream(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindSumStreamException() throws CustomArrayException {
        findService.findSumStream(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindNumberOfPositiveStreamException() throws CustomArrayException {
        findService.findNumberOfPositiveStream(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindNumberOfNegativeStreamException() throws CustomArrayException {
        findService.findNumberOfNegativeStream(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindAverageStreamException() throws CustomArrayException {
        findService.findAverageStream(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMaxElementStreamNull() throws CustomArrayException {
        findService.findMaxStream(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMinStreamForNull() throws CustomArrayException {
        findService.findMinStream(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindSumStreamForNull() throws CustomArrayException {
        findService.findSumStream(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindNumberOfPositiveStreamForNull() throws CustomArrayException {
        findService.findNumberOfPositiveStream(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindNumberOfNegativeStreamNull() throws CustomArrayException {
        findService.findNumberOfNegativeStream(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindAverageStreamNull() throws CustomArrayException {
        findService.findAverageStream(null);
    }
}
