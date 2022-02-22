package com.epam.task1.main;

import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.parser.ArrayParser;
import com.epam.task1.parser.impl.ArrayParserImpl;
import com.epam.task1.reader.ArrayLineReader;
import com.epam.task1.reader.impl.ArrayLineReaderImpl;
import com.epam.task1.validation.ArrayLineValidator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomArrayException {
        System.out.println("------ READING FROM FILE ------");
        ArrayLineReader reader = new ArrayLineReaderImpl();
        List<String> arrayLines = reader.readAllArrayLines(
                "D:\\introduction-to-java\\epam-jwd-task1\\task1\\src\\main\\resources\\arraysFile.txt");
        System.out.println("All valid lines: ");
        for (String str : arrayLines) {
            System.out.println(str);
        }

       /* System.out.println("------ SORTING ------");
       ArraySortService sortService = new ArraySortServiceImpl();
        for (CustomArray arr : array) {
            System.out.println(arr);
            try {
                sortService.selectionSort(arr);
                System.out.println(arr + "\n");
            } catch (CustomArrayException e) {
                System.out.println(e.getClass() + "\n");
            }

        }*/

        System.out.println("------ VALIDATING ------");
        ArrayLineValidator val = new ArrayLineValidator();
        System.out.println(val.isArrayLineCorrect(""));
        System.out.println(val.isArrayLineCorrect("  14; 4   ;      6"));
        System.out.println(val.isArrayLineCorrect("23; 7   ;      32  "));
        System.out.println(val.isArrayLineCorrect("  4; -8; 12  "));
        System.out.println(val.isArrayLineCorrect("1; 2; 3;"));
        System.out.println(val.isArrayLineCorrect(";1; 2; 3"));
        System.out.println(val.isArrayLineCorrect("    "));
        System.out.println(val.isArrayLineCorrect(" ; "));
        System.out.println(val.isArrayLineCorrect("  1; - 2; 3  "));

        System.out.println("------ PARSING ------");
        ArrayParser parser = new ArrayParserImpl();
        System.out.println(Arrays.toString(parser.parse("")));
        System.out.println(Arrays.toString(parser.parse("  14; 4   ;      6")));
        System.out.println(Arrays.toString(parser.parse("14; 4   ;      6  ")));
        System.out.println(Arrays.toString(parser.parse("       -1; 2; 3  ;7")));
        System.out.println(Arrays.toString(parser.parse("       - 1; 2; 3  ;7")));

    }
}
