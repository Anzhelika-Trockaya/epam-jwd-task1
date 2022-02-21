package com.epam.jwd.task1.main;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.CustomArrayParseException;
import com.epam.jwd.task1.exception.CustomArrayReaderException;
import com.epam.jwd.task1.exception.FileNotExistsException;
import com.epam.jwd.task1.exception.ServiceException;
import com.epam.jwd.task1.parser.CustomArrayParser;
import com.epam.jwd.task1.reader.CustomArrayReader;
import com.epam.jwd.task1.service.ArraySortService;
import com.epam.jwd.task1.service.impl.ArraySortServiceImpl;
import com.epam.jwd.task1.validation.CustomArrayLineValidator;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CustomArrayReaderException, IOException, FileNotExistsException, CustomArrayParseException {
        CustomArrayReader reader = new CustomArrayReader("D:\\introduction-to-java\\epam-jwd-task1\\task1\\src\\main\\resources\\arraysFile.txt");
        while (reader.hasNext()) {
            CustomArray arr = reader.readNext();
            System.out.println(Arrays.toString(arr.getElements()));
        }

        CustomArray[] array = new CustomArray[10];
        array[0] = new CustomArray(new int[10]);
        array[1] = new CustomArray(new int[0]);
        array[2] = new CustomArray(new int[] { 0 });
        array[3] = new CustomArray(2, 1);
        array[4] = new CustomArray(new int[] { 0, 5, 0, -9 });
        array[5] = new CustomArray(new int[] { 7, 5, 0, -9 });
        array[6] = new CustomArray(new int[] { 7, -12, 5, 0, -9 });
        array[7] = new CustomArray(null);
        array[8] = null;
        array[9] = new CustomArray();

        ArraySortService sortService = new ArraySortServiceImpl();
        for (CustomArray arr : array) {
            System.out.println(arr);
            try {
                sortService.selectionSort(arr);
                System.out.println(arr + "\n");
            } catch (ServiceException e) {
                System.out.println(e.getClass() + "\n");
            }

        }

         CustomArrayLineValidator val = new CustomArrayLineValidator();
         System.out.println(val.isCustomArrayLineCorrect(""));
         System.out.println(val.isCustomArrayLineCorrect("  14; 4   ;      6"));
         System.out.println(val.isCustomArrayLineCorrect("14; 4   ;      6  "));
         System.out.println(val.isCustomArrayLineCorrect("  1; 2; 3  "));
         System.out.println(val.isCustomArrayLineCorrect("1; 2; 3;"));
         System.out.println(val.isCustomArrayLineCorrect(";1; 2; 3"));
         System.out.println(val.isCustomArrayLineCorrect("    "));
         System.out.println(val.isCustomArrayLineCorrect(" ; "));
         System.out.println(val.isCustomArrayLineCorrect("  1; - 2; 3  "));

         CustomArrayParser parser = new CustomArrayParser();
         System.out.println(parser.parse(""));
         System.out.println(parser.parse("  14; 4   ;      6"));
         System.out.println(parser.parse("14; 4   ;      6  "));
         System.out.println(parser.parse("       -1; 2; 3  ;7"));



    }
}
