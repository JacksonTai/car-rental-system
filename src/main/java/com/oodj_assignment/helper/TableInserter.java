/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.helper;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 * Helper class for inserting column and row to specifed JTable.
 */
public class TableInserter {
    
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
