package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        String fileName = readFilename();
        String text = readFileText(fileName);
        ArrayList<Integer> openingTagsList = findTags(tag, text, "start");
        ArrayList<Integer> closingTagsList = findTags(tag, text, "end");
        ArrayList<String> tagsContent = findTagsContent(text, openingTagsList, closingTagsList, tag);

        tagsContent.forEach(System.out::println);
    }

    private static String readFilename() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }

    private static String readFileText(String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()) {
                builder.append(reader.readLine());
            }
        }
        return builder.toString();
    }

    private static ArrayList<Integer> findTags(String tag, String text, String position) {
        ArrayList<Integer> list = new ArrayList<>();


        if(position.equals("start")) {
            Pattern pattern = Pattern.compile("<" + tag);
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()) {
                list.add(matcher.start());
            }
        }
        if(position.equals("end")) {
            Pattern pattern = Pattern.compile("/" + tag + ">");
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()) {
                list.add(matcher.end());
            }
        }
        return list;
    }

    private static ArrayList<String> findTagsContent(String text, ArrayList<Integer> openingTagsList, ArrayList<Integer> closingTagsList, String tag) {
        ArrayList<String> list = new ArrayList<>();
        int openingTagIndex = 0;
        int closingTagIndex = 0;


        while(!openingTagsList.isEmpty()) {
            while(!closingTagsList.isEmpty()) {
                int from = openingTagsList.get(openingTagIndex);
                int to = closingTagsList.get(closingTagIndex);

                String capture = text.substring(from, to);
                int openCount = tagCounter(capture, ("<" + tag));
                int closeCount = tagCounter(capture, ("/" + tag + ">"));

                if(openCount == closeCount) {
                    list.add(capture);
                    openingTagsList.remove(openingTagIndex);
                    closingTagsList.remove(closingTagIndex);
                    closingTagIndex = 0;
                }
                else {
                    closingTagIndex++;
                }
            }
        }
        return list;
    }

    private static int tagCounter(String capture, String tag) {
        int count = 0;
        int start = 0;

        Pattern pattern = Pattern.compile(tag);
        Matcher matcher = pattern.matcher(capture);
        while(matcher.find(start)) {
            count++;
            start = matcher.end();
        }
        return count;
    }
}
