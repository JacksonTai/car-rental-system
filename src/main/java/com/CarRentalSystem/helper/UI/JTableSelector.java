package com.CarRentalSystem.helper.UI;

import javax.swing.JTable;

/**
 * UI Helper class for returning the selected records of JTable.
 */
public class JTableSelector {

    /**
    * Get the selected row and return its record in an array.
    * @param table table to be selected
    * @return String[] - selected row
    */
   public static String[] selectRow(JTable table) {
        try {
            int columnCount = table.getColumnCount();
            String[] row = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = table.getValueAt(table.getSelectedRow(), i).toString();
            }
            return row;
        } catch (ArrayIndexOutOfBoundsException e) {
           throw e;
        }     
   }
    
}
