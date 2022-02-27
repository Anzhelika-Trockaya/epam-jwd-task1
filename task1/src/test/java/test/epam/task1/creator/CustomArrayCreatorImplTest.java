package test.epam.task1.creator;

import com.epam.task1.creator.impl.CustomArrayCreatorImpl;
import com.epam.task1.entity.CustomArray;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.epam.task1.comparator.ListComparator;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomArrayCreatorImplTest {
    CustomArrayCreatorImpl creator = new CustomArrayCreatorImpl();

    @DataProvider(name = "create_array_data")
    public Object[][] createDataForCreateOneArray() {
        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                new int[]{4, -5, -3, 14, 4},
                new CustomArray(4, -5, -3, 14, 4)
        };
        data[1] = new Object[]{
                new int[]{14, -100, 0},
                new CustomArray(14, -100, 0)
        };
        data[2] = new Object[]{
                new int[]{0},
                new CustomArray(0)
        };
        data[3] = new Object[]{
                new int[0],
                new CustomArray()
        };
        data[4] = new Object[]{
                null,
                new CustomArray()
        };
        return data;
    }

    @DataProvider(name = "create_arrays_data")
    public Object[][] createDataForCreateListOfArrays() {
        List<int[]> listOfIntArrays = createListOfIntArrays();
        List<CustomArray> listOfCustomArrays = createListOfCustomArrays();
        Object[][] data = new Object[1][2];
        data[0] = new Object[]{
                listOfIntArrays,
                listOfCustomArrays
        };
        return data;
    }

    public List<int[]> createListOfIntArrays() {
        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{4, -5, -3, 14, 4});
        listOfArrays.add(new int[]{14, -100, 0});
        listOfArrays.add(new int[]{0});
        listOfArrays.add(new int[0]);
        listOfArrays.add(null);
        return listOfArrays;
    }

    public List<CustomArray> createListOfCustomArrays() {
        List<CustomArray> listOfArrays = new ArrayList<>();
        listOfArrays.add(new CustomArray(4, -5, -3, 14, 4));
        listOfArrays.add(new CustomArray(14, -100, 0));
        listOfArrays.add(new CustomArray(0));
        listOfArrays.add(new CustomArray());
        listOfArrays.add(new CustomArray());
        return listOfArrays;
    }

    @Test
    public void testCreateDefaultCustomArray() {
        assertEquals(new CustomArray(), creator.createCustomArray());
    }

    @Test(dataProvider = "create_array_data")
    public void testCreateOneCustomArrayWithParam(int[] elements, CustomArray expected) {
        CustomArray actual = creator.createCustomArray(elements);
        assertEquals(expected, actual);
    }

    @Test(dataProvider = "create_arrays_data")
    public void testCreateListOfCustomArrays(List<int[]> elementsList, List<CustomArray> expected) {
        List<CustomArray> actual = creator.createCustomArrays(elementsList);
        ListComparator comparator = new ListComparator();
        assertTrue(comparator.areEqualsListsOfCustomArrays(expected, actual));
    }
}
