package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public static class Human
    {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private int strength;
        private int perception;
        private int endurance;
        private int charisma;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, int strength)
        {
            this.name = name;
            this.age = age;
            this.strength = strength;
        }

        public Human(String name, int age, int strength, int perception)
        {
            this.name = name;
            this.age = age;
            this.strength = strength;
            this.perception = perception;
        }

        public Human(String name, int age, int strength, int perception, int endurance)
        {
            this.name = name;
            this.age = age;
            this.strength = strength;
            this.perception = perception;
            this.endurance = endurance;
        }

        public Human(String name, int age, int strength, int perception, int endurance, int charisma)
        {
            this.name = name;
            this.age = age;
            this.strength = strength;
            this.perception = perception;
            this.endurance = endurance;
            this.charisma = charisma;
        }

        public Human(int age, int strength)
        {
            this.age = age;
            this.strength = strength;
        }

        public Human(int age, int strength, int perception)
        {
            this.age = age;
            this.strength = strength;
            this.perception = perception;
        }

        public Human(int age, int strength, int perception, int endurance)
        {
            this.age = age;
            this.strength = strength;
            this.perception = perception;
            this.endurance = endurance;
        }

        public Human(int age, int strength, int perception, int endurance, int charisma)
        {
            this.age = age;
            this.strength = strength;
            this.perception = perception;
            this.endurance = endurance;
            this.charisma = charisma;
        }
    }
}
