package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        File file;
        HashMap<Integer, Integer> bytes = new HashMap<>();
        int maxCount = 0;
        ArrayList<Integer> minBytes = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(reader.readLine());
        }

        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            while(inputStream.available() > 0) {
                int currentByte = inputStream.read();
                if(bytes.containsKey(currentByte)) {
                    int currentByteCount = bytes.get(currentByte);
                    bytes.put(currentByte, currentByteCount + 1);
                    maxCount = Math.max(maxCount, currentByteCount + 1);
                }
                else {
                    bytes.put(currentByte, 1);
                }
            }
        }

        for(int i = 1; i < Short.MAX_VALUE; i++) {
            for(Map.Entry<Integer, Integer> entry : bytes.entrySet()) {
                if(entry.getValue() == i) {
                    minBytes.add(entry.getKey());
                }
            }

            if(!minBytes.isEmpty()) {
                break;
            }
        }

        for(Integer byt : minBytes) {
            System.out.print(byt + " ");
        }
    }
}
