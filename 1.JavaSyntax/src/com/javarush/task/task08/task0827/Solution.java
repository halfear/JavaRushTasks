package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Работа с датой
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        Calendar calendar = new GregorianCalendar();

        String[] dateArray = date.split(" ");
        dateArray[0] = dateArray[0].substring(0, 1) + dateArray[0].substring(1).toLowerCase();
        String rightFormattedDate = dateArray[0] + " " + dateArray[1] + " " + dateArray[2];

        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date today = dateFormat.parse(rightFormattedDate);

        calendar.setTime(today);

        int day = calendar.get(Calendar.DAY_OF_YEAR);
        if (day % 2 == 0)
        {
            return false;
        } else return true;
    }
}
