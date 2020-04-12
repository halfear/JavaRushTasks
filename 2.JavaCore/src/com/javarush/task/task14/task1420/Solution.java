package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.ArrayList;

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        ArrayList twoNumbers = new NumbersGetter().getTwoNumbers();
        int GCD = new GCDFinder((int) twoNumbers.get(0), (int) twoNumbers.get(1)).getGCD();
        System.out.println(GCD);
    }
}
