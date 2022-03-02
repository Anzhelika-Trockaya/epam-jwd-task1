package com.epam.task1.comparator;

import com.epam.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayFirstElementComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        int result;
        if(o1.length()!=0 || o2.length()!=0){
            int o1FirstElement = o1.getElements()[0];
            int o2FirstElement = o2.getElements()[0];
            result=Integer.compare(o1FirstElement, o2FirstElement);
        } else{
            result=Integer.compare(o1.length(),o2.length());
        }
        return result;
    }
}
