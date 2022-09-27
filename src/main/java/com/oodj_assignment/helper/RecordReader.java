/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Helper class for reading records from text file.
 */
public class RecordReader {
    
    /**
     * Read records in text file and return multidimensional array.
     */
    public static String[][] readFile(String fileName) {
        try {
            // Count the total lines of file.
            Path file = Paths.get(fileName);
            long lineCount = Files.lines(file).count();

            // Create array in which the size is based on the file's total lines.
            String [][] records = new String[(int) lineCount][];

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String [] rows = line.split("\\n");
                for (String row : rows) {
                    String [] record = row.split("\\|");
                    records[counter] = record;
                }
                counter++;
            }
            return records;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
