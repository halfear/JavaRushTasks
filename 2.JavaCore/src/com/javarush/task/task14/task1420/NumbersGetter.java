package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NumbersGetter
{
    private ArrayList<Integer> twoNumbers = new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ArrayList getTwoNumbers() throws IOException
    {
        while (twoNumbers.size() < 2)
        {
            int num;
            num = Integer.parseInt(reader.readLine());
            if(num <= 0) throw new ArithmeticException();
//            try
//            {
//                num = Integer.parseInt(reader.readLine());
//                if(num == 0) throw new ArithmeticException();
//            } catch (NumberFormatException | IOException | ArithmeticException e)
//            {
//                continue;
//            }
            twoNumbers.add(Math.abs(num));
        }
        return twoNumbers;
    }
}
