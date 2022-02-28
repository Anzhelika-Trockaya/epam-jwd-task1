package com.epam.task1.repository;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.specification.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private static Repository instance;
    private List<CustomArray> customArrays;

    private Repository() {
        customArrays = new ArrayList<>();
    }

    public static Repository getInstance(){
        if(instance==null){
            instance=new Repository();
        }
        return instance;
    }

    public Repository(List<CustomArray> customArrays) {
        this.customArrays = customArrays;
    }

    public boolean add(CustomArray customArray) {
        return customArrays.add(customArray);
    }

    public boolean addAll(Collection<CustomArray> collection) {
        return customArrays.addAll(collection);
    }

    public boolean remove(CustomArray customArray) {
        return customArrays.remove(customArray);
    }

    public boolean removeAll(Collection<CustomArray> collection) {
        return customArrays.removeAll(collection);
    }

    public CustomArray get(int index) {
        return customArrays.get(index);
    }

    public CustomArray set(int index, CustomArray customArray) {
        return customArrays.set(index, customArray);
    }

    public List<CustomArray> getAll() {
        return customArrays;
    }

    public List<CustomArray> query(Specification specification) {
        List<CustomArray> list = customArrays.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return list;
    }

}
