/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.helper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jackson
 */
public class ArrayUtils {
    
    public static String[][] removeElement(String[][] multiArray, String[] array) {
        if (null == multiArray || multiArray.length == 0) {
            return multiArray;
        }
        List<String[]> list = new LinkedList<>(Arrays.asList(multiArray));
        list.remove(array);
        return list.toArray(new String[0][]);
    }
    
    public static String[] removeElement(String[] array, String element) {
        if (null == array || array.length == 0) {
            return array;
        }
        List<String> list = new LinkedList<>(Arrays.asList(array));
        list.remove(element);
        return list.toArray(new String[0]);
    }
    
}

