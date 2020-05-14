package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach a = new Beach("A", 1000.0f, 550);
        Beach b = new Beach("B", 500.0f, 50);

        System.out.println(a.compareTo(b));
    }

    @Override
    public synchronized int compareTo(Beach o) {
        return (int) compareDistance(o) + compareQuality(o);
    }

    private synchronized float compareDistance(Beach o) {
        return o.distance - this.distance;
    }

    private synchronized int compareQuality(Beach o) {
        return this.quality - o.quality;
    }
}
