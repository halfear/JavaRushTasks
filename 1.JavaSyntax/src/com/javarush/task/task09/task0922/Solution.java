package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dateAsText = reader.readLine();

        String[] dateAsArray = dateAsText.split("-");

        Date date = new Date(Integer.parseInt(dateAsArray[0]) - 1900,
                Integer.parseInt(dateAsArray[1]) - 1,
                Integer.parseInt(dateAsArray[2]));

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, y", Locale.ENGLISH);

        System.out.println(dateFormat.format(date).toUpperCase());
    }
}
