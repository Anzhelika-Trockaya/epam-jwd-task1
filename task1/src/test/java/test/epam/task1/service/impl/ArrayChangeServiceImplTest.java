package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.impl.ArrayChangeServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayChangeServiceImplTest {
    ArrayChangeServiceImpl changeService = new ArrayChangeServiceImpl();

    @DataProvider(name = "dataForReplaceAll")
    public Object[][] createData() {
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

    @Test(dataProvider="dataForReplaceAll")
    public void testReplaceAll(CustomArray actual, int value, int replacement, CustomArray expected) throws CustomArrayException {
        changeService.replaceAll(actual, value, replacement);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllNull() throws CustomArrayException{
        changeService.replaceAll(null, 12, 100);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReplaceAllException() throws CustomArrayException{
        changeService.replaceAll(new CustomArray(null), 12, 100);
    }
}
