package com.javarush.task.task20.task2009;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public static void serializeStatic(ObjectOutputStream oos) throws IOException {
            oos.writeChars(ClassWithStatic.staticString);
        }

        public static void deserializeStatic(ObjectInputStream ois) throws IOException {
            ClassWithStatic.staticString = ois.readUTF();
        }

    }

    public static void main(String[] args) {

    }
}
