package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    static Horse winner;
    private List<Horse> horses;

    public static void main(String[] args) throws InterruptedException {
        Hippodrome hippo = new Hippodrome(new ArrayList<Horse>());
        Hippodrome.game = hippo;
        hippo.getHorses().add(new Horse("Plotva", 3, 0));
        hippo.getHorses().add(new Horse("Sivka", 3, 0));
        hippo.getHorses().add(new Horse("Burka", 3, 0));
        
        game.run();
        game.printWinner();
    }

    public Hippodrome(List horses) {
        this.horses = new ArrayList<>();
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for(Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for(Horse horse : horses) {
            horse.print();
        }
//        for(int i = 0; i < 10; i++) {
//            System.out.println();
//        }
    }

    public Horse getWinner() {
        return horses.stream().max(Comparator.comparing(Horse::getDistance)).get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
