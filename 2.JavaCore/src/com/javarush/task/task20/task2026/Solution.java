package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        for(int y = 0; y < a.length - 1; y++) {
            for(int x = 0; x < a[y].length - 1; x++) {
                if((a[y][x] == 1) && (a[y][x + 1] == 0) && (a[y + 1][x] == 0) && (a[y + 1][x + 1] == 0)) {
                    count++;
                }
            }
        }
        for(int y = 0; y < a.length - 1; y++) {
            if((a[y][a[y].length - 1] == 1) && (a[y + 1][a[y].length - 1] == 0)) {
                count++;
            }
        }
        for(int x = 0; x < a.length - 1; x++) {
            if((a[a.length - 1][x] == 1) && (a[a.length - 1][x + 1] == 0)) {
                count++;
            }
        }
        if(a[a.length - 1][a[a.length - 1].length - 1] == 1) {
            count++;
        }

        return count;
    }
}
