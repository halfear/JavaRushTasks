package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution
{
    public static Map<String, Date> createMap() throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Кот", dateFormat.parse("JUNE 1 2012"));
        map.put("Слон", dateFormat.parse("JULY 1 2012"));
        map.put("Тигр", dateFormat.parse("AUGUST 1 2012"));
        map.put("Конь", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Лев", dateFormat.parse("NOVEMBER 1 2012"));
        map.put("Заяц", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Цапля", dateFormat.parse("JANUARY 1 2012"));
        map.put("Собака", dateFormat.parse("FEBRUARY 1 2012"));
        map.put("Петух", dateFormat.parse("MARCH 1 2012"));

        //напишите тут ваш код

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map)
    {
        //напишите тут ваш код
        Map<String, Date> tempMap = new HashMap(map);
        for (Map.Entry entry : tempMap.entrySet())
        {
            Date date = (Date) entry.getValue();
            if (date.getMonth() >= 5 && date.getMonth() <=7)
            {
                String key = (String) entry.getKey();
                map.remove(key);
            }
        }
    }

    public static void main(String[] args) throws ParseException
    {
        Map pupil = createMap();
        removeAllSummerPeople(pupil);
    }
}
