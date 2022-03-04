package com.epam.task1.parser;

import java.util.List;

public interface ArrayParser {
    int[] parse(String line);

    List<int[]> parseAll(List<String> lines);

    int[] parseStream(String line);

    List<int[]> parseAllStream(List<String> lines);
}
