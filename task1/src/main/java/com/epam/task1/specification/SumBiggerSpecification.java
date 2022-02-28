package com.epam.task1.specification;

import com.epam.task1.entity.CustomArray;

public class SumBiggerSpecification implements Specification{
    private int sum;
    public SumBiggerSpecification(int sum){
        this.sum=sum;
    }
    @Override
    public boolean specify(CustomArray customArray){
//fixme
        return false;
    }
}
