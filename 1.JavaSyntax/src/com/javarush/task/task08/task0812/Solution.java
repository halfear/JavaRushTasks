package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        List<Integer> list = new ArrayList();

        fillList(list);

        System.out.println(getLongestSequence(list));
    }

    static int getLongestSequence(List list)
    {
        int maxSequenceLenght = 0;
        int sequenceLength = 1;
        int lastNumber = (int) list.get(0);

        for (int i = 1; i < list.size(); i++)
        {
            int currentNumber = (int) list.get(i);
            if(lastNumber == currentNumber)
            {
                sequenceLength++;
            }
            else
            {
                sequenceLength = 1;
            }
            maxSequenceLenght = Math.max(sequenceLength, maxSequenceLenght);
            lastNumber = currentNumber;
        }
        return maxSequenceLenght;
    }

    static void fillList(List list) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
        {
            list.add(Integer.parseInt(reader.readLine()));
        }
        reader.close();
    }
}