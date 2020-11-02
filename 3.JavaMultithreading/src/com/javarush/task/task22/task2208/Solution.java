package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
*/


public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();

        long i = 0;
        for(Map.Entry entry : params.entrySet()) {
            if(entry.getValue() != null) {
                if(i > 0 && i < params.size()) {
                    builder.append(" and ");
                }
                builder.append(String.format("%s = '%s'", entry.getKey(), entry.getValue()));
                i++;
            }
        }
        return builder.toString();
    }
}
