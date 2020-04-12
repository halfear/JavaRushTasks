package com.javarush.task.task14.task1408;

class MoldovanHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 15;
    }

    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
