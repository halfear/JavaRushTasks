package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(result.getClass().getSimpleName());
        if(result instanceof Plane) System.out.println(((Plane) result).getPassengersAmount());
    }

    static
    {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset()
    {
        //add your code here - добавьте код тут
        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            input = reader.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        switch(input)
        {
            case "helicopter":
                result = new Helicopter();
                break;
            case "plane":
                try
                {
                    result = new Plane(Integer.parseInt(reader.readLine()));
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            default:
                result = null;
                break;
        }

        try
        {
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
