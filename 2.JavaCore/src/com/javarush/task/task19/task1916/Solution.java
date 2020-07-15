package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String[] fileNames = readName();
        String fileName1 = fileNames[0];
        String fileName2 = fileNames[1];
        List<String> list1 = readFileLines(fileName1);
        List<String> list2 = readFileLines(fileName2);
        lines = compareLists(list1, list2);
    }

    private static String[] readName() throws IOException {
        String[] names = new String[2];

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            names[0] = reader.readLine();
            names[1] = reader.readLine();
        }
        return names;
    }

    private static List<String> readFileLines(String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()) {
                list.add(reader.readLine());
            }
        }
        return list;
    }

    private static List<LineItem> compareLists(List<String> l1, List<String> l2) {
        List<LineItem> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>(l1);
        List<String> list2 = new ArrayList<>(l2);

        while(true) {
            if(list1.isEmpty() && list2.isEmpty()) {
                break;
            }
            else if(!list1.isEmpty() && !list2.isEmpty()) {
                if(list1.get(0).equals(list2.get(0))) {
                    list.add(new LineItem(Type.SAME, list1.get(0)));
                    list1.remove(0);
                    list2.remove(0);
                }
                else if(list1.get(0).equals(list2.get(1))) {
                    list.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                }
                else if(list2.get(0).equals(list1.get(1))) {
                    list.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                }
            }
            else if(list1.isEmpty()) {
                list.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }
            else {
                list.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }
        }
        return list;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}