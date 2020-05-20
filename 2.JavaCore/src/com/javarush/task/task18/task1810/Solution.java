package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        File file;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            file = new File(reader.readLine());
            try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                if(inputStream.available() < 1000) {
                    reader.close();
                    throw new DownloadException();
                }
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
