package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* 
Номер месяца
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        String[] monthsNames = new String[] {"January", "February", "March", "April", "May", "June", "July", "August",
                                                "September", "October", "November", "December"};
        List<String> year = new ArrayList<>(Arrays.asList(monthsNames));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        if (year.contains(month))
        {
            int monthNumber = year.indexOf(month) + 1;
            System.out.println(month + " is the " + monthNumber + " month");
        }
    }
}
