package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename));

        while(true)
        {
            String input = consoleReader.readLine();
            if(input.equals("exit"))
            {
                fileWriter.write(input);
                fileWriter.close();
                consoleReader.close();
                break;
            }
            else
            {
                fileWriter.write(input);
                fileWriter.newLine();
            }
        }
    }
}
