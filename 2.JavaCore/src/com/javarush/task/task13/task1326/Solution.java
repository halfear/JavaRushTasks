package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        List<Integer> numbers = new ArrayList<>();

        String line;
        while ((line = fileReader.readLine()) != null)
        {
            numbers.add(Integer.parseInt(line));
        }

        reader.close();
        fileReader.close();
        numbers.stream().filter(x -> x % 2 == 0 && x != 0).sorted().forEach(System.out::println);
    }
}
