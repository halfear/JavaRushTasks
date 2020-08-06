package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        fillPeople(PEOPLE, args[0]);
        print(PEOPLE);
    }

    private static void fillPeople(List<Person> people, String arg) throws IOException {
        Pattern datePattern = Pattern.compile("\\d{1,2}\\s+\\d{1,2}\\s+\\d{4}");

        try(BufferedReader reader = new BufferedReader(new FileReader(arg))) {
            while(reader.ready()) {
                int splitPosition = 0;
                String line = reader.readLine();
                Matcher matcher = datePattern.matcher(line);
                if(matcher.find()) {
                    splitPosition = matcher.start();
                }
                String name = line.substring(0, splitPosition).trim();
                String[] date = line.substring(splitPosition).split(" ");
                Calendar calendar = new GregorianCalendar(Integer.parseInt(date[2]),
                        Integer.parseInt(date[1]) - 1,
                        Integer.parseInt(date[0]));
                people.add(new Person(name, calendar.getTime()));
            }
        }
    }

    private static void print(List<Person> people) {
        PEOPLE.forEach(person -> System.out.println(person.getName() + " - " + person.getBirthDate()));
    }
}
