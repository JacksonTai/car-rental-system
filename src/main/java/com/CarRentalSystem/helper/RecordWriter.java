package com.CarRentalSystem.helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper class for writing records into text file.
 */
public class RecordWriter {
    
    /**
     * Write array of string records to specified text file.
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
            Logger.getLogger(RecordWriter.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Write multidimensional array of string records to specified text file.
     * @param records records to overwrite to the text file.
     * @param fileName text file in which the records will be stored.
     */
    public static void write(String[][] records, String fileName) {
        write(records, fileName, false);
    }
    
    /**
     * Write array of string records to specified text file.
     * @param records records to store in text file.
     * @param fileName text file in which the records will be stored.
     * @param overwrite true = replace all existing records with the records.
     */
    public static void write(String[][] records, String fileName, boolean overwrite){
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
            Logger.getLogger(RecordWriter.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
