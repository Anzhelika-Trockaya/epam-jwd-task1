package test.epam.task1.checker;

import com.epam.task1.entity.CustomArray;

import java.util.Arrays;
import java.util.List;

public class EqualsChecker {
    private static final int DEFAULT_SIZE = -1;

    public boolean areEqualsListsOfArrays(List<int[]> list1, List<int[]> list2) {
        int size1 = list1 != null ? list1.size() : DEFAULT_SIZE;
        int size2 = list2 != null ? list2.size() : DEFAULT_SIZE;
        if (size1 != size2) {
            return false;
        }
        for (int i = 0; i < size1; i++) {
            int[] array1 = list1.get(i);
            int[] array2 = list2.get(i);
            if (!Arrays.equals(array1, array2)) {
                return false;
            }
        }
        return true;
    }

    public boolean areEqualsListsOfCustomArrays(List<CustomArray> list1, List<CustomArray> list2) {
        int size1 = list1 != null ? list1.size() : DEFAULT_SIZE;
        int size2 = list2 != null ? list2.size() : DEFAULT_SIZE;
        if (size1 != size2) {
            return false;
        }
        for (int i = 0; i < size1; i++) {
            CustomArray array1 = list1.get(i);
            CustomArray array2 = list2.get(i);
            if (!array1.equals(array2)) {
                return false;
            }
        }
        return true;
    }

}
