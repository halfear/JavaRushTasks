package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код
        while (result.size() < 4)
        {
            result.add(new Cat());
        }

        return result;
    }

    public static Set<Dog> createDogs()
    {
        //напишите тут ваш код
        Set<Dog> result = new HashSet<>();

        while (result.size() < 3)
        {
            result.add(new Dog());
        }

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        //напишите тут ваш код
        Set<Object> result = new HashSet<>();

        result.addAll(cats);
        result.addAll(dogs);
        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        //напишите тут ваш код
        for (Cat cat : cats)
        {
            pets.remove(cat);
        }
    }

    public static void printPets(Set<Object> pets)
    {
        //напишите тут ваш код
        pets.forEach(System.out::println);
    }

    //напишите тут ваш код
    public static class Cat
    {
    }

    public static class Dog
    {
    }
}
