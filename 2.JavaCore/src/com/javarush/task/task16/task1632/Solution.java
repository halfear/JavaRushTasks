package com.javarush.task.task16.task1632;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        threads.get(2).start();
    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            while(true) {
            }
        }
    }

    public static class Thread2 extends Thread {

        @Override
        public void run() {
            while(true) {
                try {
                    if(isInterrupted())
                        throw new InterruptedException();
                }
                catch(InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread3 extends Thread {

        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
                catch(InterruptedException e) {
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {

        @Override
        public void run() {
            while(!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class Thread5 extends Thread {
        AtomicInteger integer = new AtomicInteger(0);

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;

            while(true) {
                try {
                    input = reader.readLine();
                    if(input.equals("N")) break;
                    integer.accumulateAndGet(Integer.parseInt(input), Integer::sum);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }

                System.out.println(integer.get());
            }
        }
    }
}