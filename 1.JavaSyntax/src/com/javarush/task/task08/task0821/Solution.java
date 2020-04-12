package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap()
    {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Сергей", "Иванов");
        map.put("Сергей", "Петров");
        map.put("Сергей", "Сидоров");
        map.put("Егор", "Иванов");
        map.put("Егор", "Петров");
        map.put("Егор", "Сидоров");
        map.put("Павел", "Иванов");
        map.put("Павел", "Петров");
        map.put("Павел", "Сидоров");
        map.put("Иван", "Кузьмин");

        return map;
    }

    public static void printPeopleMap(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
