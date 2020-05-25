package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        File file = new File(args[0]);
        int spaceCount = 0;
        int symbolCount = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int sign;

            while(reader.ready()) {
                sign = reader.read();
                symbolCount++;
                if(((char) sign) == ' ') {
                    spaceCount++;
                }
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        if(symbolCount <= 0) {
            System.out.printf("%.2f", 0d);
        }
        else {
            System.out.printf("%.2f", (double)spaceCount / symbolCount * 100);
        }

    }
}
