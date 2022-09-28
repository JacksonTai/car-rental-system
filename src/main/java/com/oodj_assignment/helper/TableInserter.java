/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.helper;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 * Helper class for inserting column or row to specifed JTable.
 */
public class TableInserter {
    
    /**
    * Insert columns and rows to specified JTable.
    * @param columns group of cells aligned vertically in table
    * @param rows group of cells aligned horizontally in table
    * @param table table in which the columns and rows will be added
    */
    public static void insert (String[] columns, String[][] rows, JTable table) {
        DefaultTableModel tableModel = new DefaultTableModel();
        for (String column : columns) {
            tableModel.addColumn(column);
        }
        for (String[] row : rows) {
            tableModel.addRow(row);  
        }
        table.setModel(tableModel);
    }
    
}
