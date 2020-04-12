package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution
{
    public static Map<String, String> createMap()
    {
        //напишите тут ваш код
        Map<String, String> fullNameBase = new HashMap<>();

        while (fullNameBase.size() < 10)
        {
            fullNameBase.put(generateName("Lastname"), generateName("Firstname"));
        }

        return fullNameBase;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name)
    {
        //напишите тут ваш код
        int matches = 0;
        for (String firstNameFromMap : map.values())
        {
            if (firstNameFromMap.equals(name))
            {
                matches++;
            }
        }

        return matches;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int matches = 0;
        for (String lastNameFromMap : map.keySet())
        {
            if (lastNameFromMap.equals(lastName))
            {
                matches++;
            }
        }

        return matches;
    }

    public static void main(String[] args)
    {
        String lastnameToFind = generateName("Lastname");
        String firstnameToFind = generateName("Firstname");

        Map base = createMap();

        getCountTheSameFirstName(base, firstnameToFind);
        getCountTheSameLastName(base, lastnameToFind);
    }

    public static String generateName(String namePrefix)
    {
        int index = (int) (Math.random() * 30);

        String generatedName = namePrefix + index;

        return generatedName;
    }
}
