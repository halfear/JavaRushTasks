package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        FileInputStream file = new FileInputStream(filename);
        while(file.available() > 0)
        {
            int symbol = file.read();
            char letter = (char) symbol;
            System.out.print(letter);
        }

        file.close();
        reader.close();
    }
}