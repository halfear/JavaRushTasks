package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.lang.reflect.Array;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Map<String, String> fruits = new HashMap<>();
        fruits.put("арбуз", "ягода");
        fruits.put("банан", "трава");
        fruits.put("вишня", "ягода");
        fruits.put("груша", "фрукт");
        fruits.put("дыня", "овощ");
        fruits.put("ежевика", "куст");
        fruits.put("жень-шень", "корень");
        fruits.put("земляника", "ягода");
        fruits.put("ирис", "цветок");
        fruits.put("картофель", "клубень");

        Set<String> keys = new HashSet<>(fruits.keySet());
        for (String e: keys) System.out.println(e + " - " + fruits.get(e));
    }
}
