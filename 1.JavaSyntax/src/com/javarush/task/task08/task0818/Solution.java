package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution
{
    public static Map<String, Integer> createMap()
    {
        //напишите тут ваш код
        Map<String, Integer> payroll = new HashMap<>();

        int index = 1;
        while (payroll.size() < 10)
        {
            int wage = ((int) (Math.random() * 400)) + 300;
            payroll.put("Name" + index, wage);
            index++;
        }

        return payroll;
    }

    public static void removeItemFromMap(Map<String, Integer> map)
    {
        //напишите тут ваш код
        Map<String, Integer> tempMap = new HashMap<>(map);
        for (Map.Entry entry : tempMap.entrySet())
        {
            if ((int) entry.getValue() < 500)
            {
                String key = (String) entry.getKey();
                map.remove(key);
            }
        }
    }

    public static void main(String[] args)
    {
        Map map = createMap();
        removeItemFromMap(map);
    }
}