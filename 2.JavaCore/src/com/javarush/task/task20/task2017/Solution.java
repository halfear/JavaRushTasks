package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A a;
        try(ObjectInputStream ois = objectStream) {
            if(!(ois.readObject() instanceof A)) {
                System.out.println("Not A Class");
                a = null;
            } else {
                a = (A) ois.readObject();
            }
        }
        catch(Exception e) {
            System.out.println("Something goes wrong");
            a = null;
        }
        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
