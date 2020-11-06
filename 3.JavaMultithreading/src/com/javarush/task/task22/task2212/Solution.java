package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null || telNumber.isEmpty()) {
            return false;
        }
        return telNumber.matches("(^\\+(\\d-?){11}\\d)" +
                "|(^\\+\\d\\(\\d{3}\\)(\\d-?){7}\\d)" +
                "|(^\\+\\d{2}\\(\\d{3}\\)(\\d-?){6}\\d)" +
                "|(^\\d(\\d-?){8}\\d)" +
                "|(^\\d\\(\\d{3}\\)(\\d-?){5}\\d)" +
                "|(^\\d{2}\\(\\d{3}\\)(\\d-?){4}\\d)" +
                "|(^\\(\\d{3}\\)(\\d-?){6}\\d)")
                && telNumber.replaceAll("[^-]", "").length() <= 2;
    }

    public static void main(String[] args) {

    }
}
