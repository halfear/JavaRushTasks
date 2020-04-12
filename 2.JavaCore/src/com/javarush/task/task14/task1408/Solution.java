package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution
{
    public static void main(String[] args)
    {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
//        System.out.println(hen.getDescription());
    }

    static class HenFactory
    {

        static Hen getHen(String country)
        {
            Hen hen = null;
            //напишите тут ваш код
            switch (country)
            {
                case (Hen.RUSSIA):
                    hen = new RussianHen();
                    break;

                case (Hen.BELARUS):
                    hen = new BelarusianHen();
                    break;

                case (Hen.MOLDOVA):
                    hen = new MoldovanHen();
                    break;

                case (Hen.UKRAINE):
                    hen = new UkrainianHen();
                    break;
            }

            return hen;
        }
    }
}
