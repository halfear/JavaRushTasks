package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        File file;
        HashMap<Integer, Integer> bytes = new HashMap<>();
        int maxCount = 0;

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

        for(Map.Entry<Integer, Integer> entry : bytes.entrySet()) {
            if(entry.getValue() == maxCount) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
