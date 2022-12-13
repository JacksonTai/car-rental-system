package com.oodj_assignment.helper.UI;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 * UI Helper class for inserting column or row to specifed JTable.
 */
public class JTableInserter {
    
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
