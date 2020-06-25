package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;

        if(args.length > 0) {
            fileName = readFileName();

            switch(args[0]) {
                case "-u":
                    updateProduct(fileName, args);
                    break;
                case "-d":
                    deleteProduct(fileName, args);
                    break;
                default:
            }
        }
    }

    private static String readFileName() throws IOException {
        String name;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        }
        return name;
    }

    private static void updateProduct(String fileName, String[] args) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            String productSignature;
            int id;
            long positionBeforeRead = raf.getFilePointer();

            while((productSignature = raf.readLine()) != null) {
                id = parseId(productSignature);

                if(id == Integer.parseInt(args[1])) {
                    replaceLine(fileName, id, positionBeforeRead, args);
                    break;
                }
                positionBeforeRead = raf.getFilePointer();
            }
        }
    }

    private static int parseId(String productSignature) {
        return Integer.parseInt(productSignature.substring(0, 8).trim());
    }

    private static void replaceLine(String fileName, int id, long positionBeforeRead, String[] args) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            String newProductSignature = String.format("%-8s%-30s%-8s%-4s%n", id, args[2], args[3], args[4]);

            raf.seek(positionBeforeRead);
            raf.writeBytes(newProductSignature);
        }
    }

    private static void deleteProduct(String fileName, String[] args) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            String productSignature;
            int id;
            long positionBeforeRead = raf.getFilePointer();

            while((productSignature = raf.readLine()) != null) {
                long positionAfterRead = raf.getFilePointer();
                id = parseId(productSignature);

                if(id == Integer.parseInt(args[1])) {
                    deleteLine(fileName, positionBeforeRead, positionAfterRead);
                    break;
                }
                positionBeforeRead = raf.getFilePointer();
            }
        }
    }

    private static void deleteLine(String fileName, long positionBeforeRead, long positionAfterRead) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            String lineToMove;

            raf.seek(positionAfterRead);
            while((lineToMove = raf.readLine()) != null) {
                lineToMove = String.format("%s%n", lineToMove);
                positionAfterRead = raf.getFilePointer();
                raf.seek(positionBeforeRead);
                raf.writeBytes(lineToMove);
                positionBeforeRead = raf.getFilePointer();
                raf.seek(positionAfterRead);
            }
            raf.setLength(raf.length() - 51);
        }
    }
}
