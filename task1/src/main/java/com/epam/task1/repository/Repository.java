package com.epam.task1.repository;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.repository.specification.Specification;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public interface Repository {
    boolean add(CustomArray customArray);

    boolean addAll(Collection<CustomArray> collection);

    boolean remove(CustomArray customArray);

    boolean removeAll(Collection<CustomArray> collection);

    CustomArray get(int index);

    CustomArray set(int index, CustomArray customArray);

    List<CustomArray> getAll();

    void forEach(Consumer<? super CustomArray> action);

    List<CustomArray> query(Specification specification);

    List<CustomArray> sort(Comparator<CustomArray> comparator);
}
