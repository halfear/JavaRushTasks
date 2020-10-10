package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null) throw new TooShortStringException();

        int start = string.indexOf(" ") + 1;
        int end = 0;
        int spacePos = 0;
        int count = 0;

        while((spacePos = string.indexOf(" ", end + 1)) >= 0) {
            end = spacePos;
            count++;
            if(count == 5) break;
        }
        if(count == 5) return string.substring(start, end);
        else if(count == 4) return string.substring(start);
        else throw new TooShortStringException();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
