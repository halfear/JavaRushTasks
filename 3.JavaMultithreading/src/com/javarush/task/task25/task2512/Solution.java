package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/

import java.util.LinkedList;
import java.util.List;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        
        List<String> res = new LinkedList<>();
        while (e != null) {
            res.add(0, e.toString());
            e = e.getCause();
        }

        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                throw new RuntimeException("ABC", new Exception("DEF", new IllegalAccessException("GHI")));
            }
        };
        t.setUncaughtExceptionHandler(new Solution());
        t.start();
    }
}
