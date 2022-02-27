package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.impl.ArrayFoundServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.testng.Assert.*;

public class ArrayFoundServiceImplTest {
    ArrayFoundServiceImpl foundService = new ArrayFoundServiceImpl();

    @DataProvider(name = "data_for_foundMax")
    public Object[][] createDataForFoundMax() {
        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, 1025, 1, -5, 5, -7000),
                OptionalInt.of(1025)
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                OptionalInt.of(8)
        };
        data[2] = new Object[]{
                new CustomArray(),
                OptionalInt.empty()
        };
        data[3] = new Object[]{
                new CustomArray(0, 8, 20),
                OptionalInt.of(20)
        };
        data[4] = new Object[]{
                new CustomArray(0, 0, 0),
                OptionalInt.of(0)
        };
        return data;
    }

    @DataProvider(name = "data_for_foundMin")
    public Object[][] createDataForFoundMin() {
        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, -1025, 1, -5, 5, 7000),
                OptionalInt.of(-1025)
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                OptionalInt.of(4)
        };
        data[2] = new Object[]{
                new CustomArray(),
                OptionalInt.empty()
        };
        data[3] = new Object[]{
                new CustomArray(0, 8, 20),
                OptionalInt.of(0)
        };
        data[4] = new Object[]{
                new CustomArray(0, 0, 0),
                OptionalInt.of(0)
        };
        return data;
    }

    @DataProvider(name = "data_for_foundSum")
    public Object[][] createDataForFoundSumOfElements() {
        Object[][] data = new Object[2][2];
        data[0] = new Object[]{
                new CustomArray(5, 6, 7, 10, 3),
                OptionalInt.of(31)
        };
        data[1] = new Object[]{
                new CustomArray(),
                OptionalInt.empty()
        };
        return data;
    }

    @DataProvider(name = "data_for_foundNumPositive")
    public Object[][] createDataForFoundNumPositive() {
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

    @DataProvider(name = "data_for_foundNumNegative")
    public Object[][] createDataForFoundNumNegative() {
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

    @DataProvider(name = "data_for_foundAverage")
    public Object[][] createDataForFoundAverage() {
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
                new CustomArray(1,5,9),
                5
        };
        return data;
    }

    @Test(dataProvider = "data_for_foundMax")
    public void testFoundMaxElement(CustomArray array, OptionalInt expected) throws CustomArrayException {
        OptionalInt actual = foundService.foundMax(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_foundMin")
    public void testFoundMinElement(CustomArray array, OptionalInt expected) throws CustomArrayException {
        OptionalInt actual = foundService.foundMin(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_foundSum")
    public void testFoundSumOfElements(CustomArray array, OptionalInt expected) throws CustomArrayException {
        OptionalInt actual = foundService.foundSumOfElements(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data_for_foundNumPositive")
    public void testFoundNumberOfPositive(CustomArray array, int expected) throws CustomArrayException {
        int actual = foundService.foundNumberOfPositive(array);
        assertTrue(expected == actual);
    }

    @Test(dataProvider = "data_for_foundNumNegative")
    public void testFoundNumberOfNegative(CustomArray array, int expected) throws CustomArrayException {
        int actual = foundService.foundNumberOfNegative(array);
        assertTrue(expected == actual);
    }

    @Test(dataProvider = "data_for_foundAverage")
    public void testFoundAverage(CustomArray array, double expected) throws CustomArrayException {
        double actual = foundService.foundAverage(array).getAsDouble();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFoundAverageForEmptyArray() throws CustomArrayException {
        OptionalDouble actual = foundService.foundAverage(new CustomArray());
        assertSame(OptionalDouble.empty(), actual);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundMaxElementException() throws CustomArrayException {
        foundService.foundMax(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundMinElementException() throws CustomArrayException {
        foundService.foundMin(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundSumOfElementsException() throws CustomArrayException {
        foundService.foundSumOfElements(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundNumberOfPositiveException() throws CustomArrayException {
        foundService.foundNumberOfPositive(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundNumberOfNegativeException() throws CustomArrayException {
        foundService.foundNumberOfNegative(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundAverageException() throws CustomArrayException {
        foundService.foundAverage(new CustomArray(null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundMaxElementNull() throws CustomArrayException {
        foundService.foundMax(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundMinElementNull() throws CustomArrayException {
        foundService.foundMin(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundSumOfElementsNull() throws CustomArrayException {
        foundService.foundSumOfElements(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundNumberOfPositiveNull() throws CustomArrayException {
        foundService.foundNumberOfPositive(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundNumberOfNegativeNull() throws CustomArrayException {
        foundService.foundNumberOfNegative(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFoundAverageNull() throws CustomArrayException {
        foundService.foundAverage(null);
    }
}
