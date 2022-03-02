package com.epam.task1.util;

public class IdGeneratorUtil {
    private static int currentId = 0;

    private IdGeneratorUtil() {
    }

    public static int generate() {
        return ++currentId;
    }
}
