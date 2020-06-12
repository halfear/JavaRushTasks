package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        String fileName;

        while(true) {
            fileName = readFileName();
            if(fileName.equals("exit")) {
                break;
            }

            Thread thread = new ReadThread(fileName);
            thread.start();
        }
    }

    private static String readFileName() throws IOException {
        String string;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            string = reader.readLine();
        }
        return string;
    }

    public static class ReadThread extends Thread {
        String fileName;
        Integer frequentByte;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                frequentByte = findFrequentByte(fileName);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            resultMap.put(fileName, frequentByte);
        }

        private Integer findFrequentByte(String fileName) throws IOException {
            int[] bytes = new int[256];

            countAllBytes(fileName, bytes);
            return findTheByte(bytes);
        }

        private void countAllBytes(String fileName, int[] bytes) throws IOException {
            try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
                int byt;

                while((byt = bis.read()) != -1) {
                    bytes[byt]++;
                }
            }
        }

        private Integer findTheByte(int[] bytes) {
            int freqByte = -1;
            int max = 0;
            int value;

            for(int index = 0; index < bytes.length; index++) {
                if((value = bytes[index]) > max) {
                    max = value;
                    freqByte = index;
                }
            }
            return freqByte;
        }
    }
}
