package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HashSet<String> set = new HashSet<>();

        while (true) {
            String password = generatePassword();
            if (password.matches(".*[A-Z]+.*")
                    && password.matches(".*[a-z]+.*")
                    && password.matches(".*[0-9]+.*")
                    && set.add(password)) {
                try {
                    baos.write(password.getBytes(StandardCharsets.UTF_8));
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos;
    }

    private static String generatePassword() {
        String bigs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smals = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        Random random = new Random();
        StringBuilder builder = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            char ch;
            int switcher = random.nextInt(3);
            switch (switcher) {
                case 0:
                    ch = bigs.charAt(random.nextInt(bigs.length()));
                    break;
                case 1:
                    ch = smals.charAt(random.nextInt(smals.length()));
                    break;
                default:
                    ch = nums.charAt(random.nextInt(nums.length()));
                    break;
            }
            builder.append(ch);
        }
        return builder.toString();
    }
}