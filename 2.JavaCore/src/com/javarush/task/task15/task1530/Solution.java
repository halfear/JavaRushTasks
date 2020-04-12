package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution
{
    public static void main(String[] args)
    {
        DrinkMaker[] maker = new DrinkMaker[2];
        maker[0] = new TeaMaker();
        maker[1] = new LatteMaker();

        for(DrinkMaker m : maker) m.makeDrink();
    }
}
