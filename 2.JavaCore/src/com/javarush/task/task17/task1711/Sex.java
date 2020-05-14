package com.javarush.task.task17.task1711;

public enum Sex {
    MALE,
    FEMALE;


    @Override
    public String toString() {
        String result;
        if(this == MALE) {
            result = "м";
        }
        else {
            result = "ж";
        }

        return result;
    }
}
