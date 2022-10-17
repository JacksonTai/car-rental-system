/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Helper class for writing records into text file.
 */
public class RecordWriter {
    
    /**
     * Write records to specified text file.
     * @param records records to store in text file.
     * @param fileName text file in which the records will be stored.
     */
    public static void write(String[] records, String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            for (String record : records) {
                bw.write(record + "|");
            }
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Write records to specified text file.
     * @param records records to overwrite to the text file.
     * @param fileName text file in which the records will be stored.
     */
    public static void write(String[][] records, String fileName) {
        write(records, fileName, false);
    }
    
    /**
     * Write records to specified text file.
     * @param records records to store in text file.
     * @param fileName text file in which the records will be stored.
     * @param overwrite true = replace all existing records with the records.
     */
    public static void write(String[][] records, String fileName, boolean overwrite) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, !overwrite));
            for (String [] record : records) {
                for (String field : record) {
                    bw.write(field + "|");
                }
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
