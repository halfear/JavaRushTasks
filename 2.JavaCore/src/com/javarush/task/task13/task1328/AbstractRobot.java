package com.javarush.task.task13.task1328;

import java.util.Random;

public abstract class AbstractRobot implements Attackable, Defensable
{
    private int hitCount;
    private String name;

    public AbstractRobot(String name)
    {
        this.name = name;
    }

    public BodyPart attack()
    {
        BodyPart attackedBodyPart;
        hitCount = new Random().ints(0, 4).findFirst().getAsInt();


        if (hitCount == 1)
        {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2)
        {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3)
        {
            attackedBodyPart = BodyPart.CHEST;
        } else
        {
            attackedBodyPart = BodyPart.HEAD;
        }
        return attackedBodyPart;
    }

    public BodyPart defense()
    {
        BodyPart defendedBodyPart;
        hitCount = new Random().ints(0, 4).findFirst().getAsInt();

        if (hitCount == 1)
        {
            defendedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2)
        {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3)
        {
            defendedBodyPart = BodyPart.CHEST;
        } else
        {
            defendedBodyPart = BodyPart.HEAD;
        }
        return defendedBodyPart;
    }

    public String getName()
    {
        return name;
    }
}
