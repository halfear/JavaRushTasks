package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human daughter = new Human("Daut", false, 20);
        Human son1 = new Human("Son1", true, 21);
        Human son2 = new Human("Son2", true, 22);
        Human mom = new Human("Mom", false, 45);
        mom.children.add(daughter);
        mom.children.add(son1);
        mom.children.add(son2);
        Human dad = new Human("Dad", true, 46);
        dad.children.add(daughter);
        dad.children.add(son1);
        dad.children.add(son2);
        Human gma1 = new Human("Gma1", false, 68);
        gma1.children.add(mom);
        Human gpa1 = new Human("Gpa1", true, 69);
        gpa1.children.add(mom);
        Human gma2 = new Human("Gma2", false, 68);
        gma2.children.add(dad);
        Human gpa2 = new Human("Gpa2", true, 69);
        gpa2.children.add(dad);

        System.out.println(gma1.toString());
        System.out.println(gpa1.toString());
        System.out.println(gma2.toString());
        System.out.println(gpa2.toString());
        System.out.println(mom.toString());
        System.out.println(dad.toString());
        System.out.println(daughter.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        List<Human> children = new ArrayList<>();

        public Human (String name, Boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
