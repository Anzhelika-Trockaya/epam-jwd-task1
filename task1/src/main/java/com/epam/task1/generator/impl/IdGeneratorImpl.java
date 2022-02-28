package com.epam.task1.generator.impl;

import com.epam.task1.generator.IdGenerator;

public class IdGeneratorImpl implements IdGenerator {
    private static long currentId;

    public IdGeneratorImpl() {
        currentId = 0;
    }

    @Override
    public long generateNextId() {
        currentId++;
        return currentId;
    }
}
