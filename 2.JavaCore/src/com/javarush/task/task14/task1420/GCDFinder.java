package com.javarush.task.task14.task1420;

import java.util.ArrayList;

public class GCDFinder
{
    private int GCD;

    public GCDFinder(int number1, int number2)
    {
        this.GCD = findGCD(number1, number2);
    }

    private int findGCD(int number1, int number2)
    {
        ArrayList<Integer> num1Mult = new MultipliersFinder(number1).getMultipliers();
        ArrayList<Integer> num2Mult = new MultipliersFinder(number2).getMultipliers();
        ArrayList<Integer> commonMult = new ArrayList();

        for(int i = 0; i < num1Mult.size();)
        {
            Integer currentNumber = num1Mult.get(i);
            if(num2Mult.contains(currentNumber))
            {
                commonMult.add(currentNumber);
                num1Mult.remove(currentNumber);
                num2Mult.remove(currentNumber);
            }
            else
            {
                i++;
            }
        }

        return commonMult.stream().reduce((x1, x2) -> x1 * x2).get();
    }

    public int getGCD()
    {
        return GCD;
    }
}
