package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        String rightNumber;
        int radix;
        if (s.startsWith("0x")) {
            rightNumber = s.substring(2);
            radix = 16;
        } else if (s.startsWith("0b")) {
            rightNumber = s.substring(2);
            radix = 2;
        } else if (s.startsWith("0")) {
            rightNumber = s.substring(1);
            radix = 8;
        } else {
            rightNumber = s;
            radix = 10;
        }

        Integer src = Integer.parseInt(rightNumber, radix);
        return Integer.toString(src);
    }
}
