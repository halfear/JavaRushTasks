package com.javarush.task.task14.task1420;

import java.util.ArrayList;

public class MultipliersFinder
{
    private ArrayList<Integer> multipliers;

    public MultipliersFinder(int number)
    {
        this.multipliers = findMultipliers(number);
    }

    private ArrayList findMultipliers(int number)
    {
        ArrayList<Integer> multipliers = new ArrayList<>();
        int currentNumber = number;

        multipliers.add(1);
        while(currentNumber > 1)
        {
            for(int currentDivider = 2; currentDivider <= currentNumber; currentDivider++)
            {
                if(currentNumber % currentDivider == 0)
                {
                    multipliers.add(currentDivider);
                    currentNumber /= currentDivider;
                    break;
                }
            }
        }
        multipliers.add(number);

        return multipliers;
    }

    public ArrayList<Integer> getMultipliers()
    {
        return multipliers;
    }
}
