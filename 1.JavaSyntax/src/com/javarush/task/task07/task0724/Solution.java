package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
        Human gpa1 = new Human("Ivan", true, 60);
        Human gma1 = new Human("Maria", false, 55);
        Human gpa2 = new Human("Oleg", true, 60);
        Human gma2 = new Human("Nina", false, 55);
        Human fat = new Human("Anatoliy", true, 35, gpa2, gma2);
        Human mot = new Human("Valentina", false, 32, gpa1, gma1);
        Human kid1 = new Human("Pavel", true, 10, fat, mot);
        Human kid2 = new Human("Kolya", true, 11, fat, mot);
        Human kid3 = new Human("Slava", true, 9, fat, mot);

        System.out.println(gpa1.toString());
        System.out.println(gma1.toString());
        System.out.println(gpa2.toString());
        System.out.println(gma2.toString());
        System.out.println(fat.toString());
        System.out.println(mot.toString());
        System.out.println(kid1.toString());
        System.out.println(kid2.toString());
        System.out.println(kid3.toString());
    }

    public static class Human
    {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
            {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null)
            {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}