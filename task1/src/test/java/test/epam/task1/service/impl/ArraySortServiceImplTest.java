package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.impl.ArraySortServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySortServiceImplTest {
    ArraySortServiceImpl sortService = new ArraySortServiceImpl();

    @DataProvider(name = "arrays_data")
    public Object[][] createData() {
        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                new CustomArray(5, 8, -6, 7, 1025, 1, -5, 5, 7),
                new CustomArray(-6, -5, 1, 5, 5, 7, 7, 8, 1025)
        };
        data[1] = new Object[]{
                new CustomArray(8, 7, 6, 5, 4),
                new CustomArray(4, 5, 6, 7, 8)
        };
        data[2] = new Object[]{
                new CustomArray(),
                new CustomArray()
        };
        data[3] = new Object[]{
                new CustomArray(20),
                new CustomArray(20)
        };
        data[4] = new Object[]{
                new CustomArray(963, 8),
                new CustomArray(8, 963)
        };
        return data;
    }

    @Test(dataProvider = "arrays_data")
    public void testBubbleSort(CustomArray actual, CustomArray expected) throws CustomArrayException {
        CustomArray actualClone = new CustomArray(actual.getElements());
        sortService.bubbleSort(actualClone);
        assertEquals(actualClone, expected);
    }

    @Test(dataProvider = "arrays_data")
    public void testInsertionSort(CustomArray actual, CustomArray expected) throws CustomArrayException {
        CustomArray actualClone = new CustomArray(actual.getElements());
        sortService.insertionSort(actualClone);
        assertEquals(actualClone, expected);
    }

    @Test(dataProvider = "arrays_data")
    public void testShellSort(CustomArray actual, CustomArray expected) throws CustomArrayException {
        CustomArray actualClone = new CustomArray(actual.getElements());
        sortService.shellSort(actualClone);
        assertEquals(actualClone, expected);
    }

    @Test(dataProvider = "arrays_data")
    public void testStreamSort(CustomArray actual, CustomArray expected) throws CustomArrayException {
        CustomArray actualClone = new CustomArray(actual.getElements());
        sortService.streamSort(actualClone);
        assertEquals(actualClone, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testBubbleSortException() throws CustomArrayException {
        sortService.bubbleSort(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testBubbleSortNull() throws CustomArrayException {
        sortService.bubbleSort(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testInsertionSortException() throws CustomArrayException {
        sortService.insertionSort(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testInsertionSortNull() throws CustomArrayException {
        sortService.insertionSort(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testShellSortException() throws CustomArrayException {
        sortService.shellSort(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testShellSortNull() throws CustomArrayException {
        sortService.shellSort(null);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testStreamSortException() throws CustomArrayException {
        sortService.streamSort(new CustomArray((int[]) null));
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testStreamSortNull() throws CustomArrayException {
        sortService.streamSort(null);
    }
}
