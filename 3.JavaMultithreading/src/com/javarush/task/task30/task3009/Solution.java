package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> radixes = new HashSet<>();
        for (int i = 2; i <= 36; i++) {
            try {
                Integer num = Integer.parseInt(number, 10);
                if(isPaly(Integer.toString(num, i)))
                    radixes.add(i);
            } catch (NumberFormatException e) {
            }
        }

        return radixes;
    }

    private static boolean isPaly(String s) {
        char[] chars = s.toCharArray();
        boolean result = true;
        int length = chars.length;

        for (int i = 0; i < chars.length / 2; i++) {
            if(chars[i] != chars[length - 1 - i]) {
                result = false;
                break;
            }
        }

        return result;
    }
}