package com.oodj_assignment.helper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class for array.
 */
public class ArrayUtils {
    
    /**
    * Remove element(array) from multidimensional array.
    * @param multiArray multidimensional array in which element(array) will be removed from.
    * @param array removing element(array)
    * @return String[][] manipulated multidimensional array or remain same for invalid 
    *                    multidimensional array
    */
    public static String[][] removeElement(String[][] multiArray, String[] array) {
        if (null == multiArray || multiArray.length == 0) {
            return multiArray;
        }
        List<String[]> list = new LinkedList<>(Arrays.asList(multiArray));
        list.remove(array);
        return list.toArray(new String[0][]);
    }
    
    /**
    * Remove element from array.
    * @param array array in which element will be removed from.
    * @param element removing element
    * @return String[] manipulated array or remain same for invalid array
    */
    public static String[] removeElement(String[] array, String element) {
        if (null == array || array.length == 0) {
            return array;
        }
        List<String> list = new LinkedList<>(Arrays.asList(array));
        list.remove(element);
        return list.toArray(new String[0]);
    }
    
}

