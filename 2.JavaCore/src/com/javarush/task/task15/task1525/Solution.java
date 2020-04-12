package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution
{
    public static List<String> lines = new ArrayList<String>();

    static
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
            String line = reader.readLine();

            while(line != null)
            {
                lines.add(line);
                line = reader.readLine();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Файл не найден");
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(lines);
    }



}
