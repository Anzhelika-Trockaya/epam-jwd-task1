package test.epam.task1.comparator;

import com.epam.task1.entity.CustomArray;

import java.util.Arrays;
import java.util.List;

public class ListComparator {
    public boolean areEqualsListsOfArrays(List<int[]> list1, List<int[]> list2) {
        if ((list1 == null && list2 != null) || (list2 == null && list1 != null) || (list1.size() != list2.size())) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            int[] array1 = list1.get(i);
            int[] array2 = list2.get(i);
            if (!Arrays.equals(array1, array2)) {
                return false;
            }
        }
        return true;
    }

    public boolean areEqualsListsOfCustomArrays(List<CustomArray> list1, List<CustomArray> list2) {
        if ((list1 == null && list2 != null) || (list2 == null && list1 != null) || (list1.size() != list2.size())) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            CustomArray array1 = list1.get(i);
            CustomArray array2 = list2.get(i);
            if (!array1.equals(array2)) {
                return false;
            }
        }
        return true;
    }

}
