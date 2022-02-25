package test.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.impl.ArrayFoundServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalInt;

import static org.testng.Assert.*;

public class ArrayFoundServiceImplTest {
    ArrayFoundServiceImpl foundService = new ArrayFoundServiceImpl();

    @DataProvider(name = "data_for_foundMax")
    public Object[][] createData() {
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

    @Test(dataProvider = "data_for_foundMax")
    public void testFoundMaxElement(CustomArray array, OptionalInt expected) throws CustomArrayException {
        OptionalInt actual = foundService.foundMax(array);
        assertTrue(expected.equals(actual));
    }


}
