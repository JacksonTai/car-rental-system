package com.oodj_assignment.helper;

import java.util.Arrays;

/**
 * Helper class for reading records from text file.
 */
public class RecordUpdater {
    
    /**
     * Update records in text file based on given index.
     * @param record the updating record.
     * @param index the criteria for matching the record. (default - 0)
     * @param fileName the file in which the records will be updated.
     */
    public static void update(String[] record, int index, String fileName){
        String[][] records = RecordReader.readFile(fileName);
        for (int i = 0; i < records.length; i++) {
            if (records[i][index].equals(record[index])) {
                records[i] = record;
                break;
            }
        }
        RecordWriter.write(records, fileName);
    }
 
    /**
     * Update records in text file based on the first item in array.
     * @param record the updating record.
     * @param fileName the file in which the records will be updated.
     */
    public static void update(String[] record, String fileName){
        update(record, 0, fileName);
    }
    
}
