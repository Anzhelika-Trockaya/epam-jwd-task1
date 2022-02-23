package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.ArraySortService;
import com.epam.task1.service.impl.ArraySortServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class ArraySortServiceImplTest {
    ArraySortService sortService = new ArraySortServiceImpl();

    @DataProvider(name = "arrays_data")
    public Object[][] createData() {
        Object[][] data = new Object[3][2];
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
        return data;
    }

    @Test(dataProvider = "arrays_data")
    public void bubbleSortTest(CustomArray actual, CustomArray expected) throws CustomArrayException {
        sortService.bubbleSort(actual);
        assertEquals(actual, expected);
    }
}
