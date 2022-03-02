package com.epam.task1.creator;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.repository.Repository;

import java.util.List;

public interface RepositoryCreator {
    Repository createRepository(List<CustomArray> arrays);
}
