package com.javarush.task.task15.task1529;

public class Plane implements CanFly
{
    private int passengersAmount;

    public Plane(int passengersAmount)
    {
        this.passengersAmount = passengersAmount;
    }

    @Override
    public void fly()
    {

    }

    public int getPassengersAmount()
    {
        return passengersAmount;
    }
}
