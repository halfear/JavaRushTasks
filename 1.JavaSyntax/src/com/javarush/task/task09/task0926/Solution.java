package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();

        list.add(new int[]{50, 51, 52, 53, 54});
        list.add(new int[]{20, 21});
        list.add(new int[]{40, 41, 42, 43});
        list.add(new int[]{70, 71, 72, 73, 74, 75, 76});
        list.add(new int[0]);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array : list)
        {
            for (int x : array)
            {
                System.out.println(x);
            }
        }
    }
}
