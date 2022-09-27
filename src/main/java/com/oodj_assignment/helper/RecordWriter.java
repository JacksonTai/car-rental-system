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
    
    public static void write(String[][] records, String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
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
