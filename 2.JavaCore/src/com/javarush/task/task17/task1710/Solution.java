package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws SexException, ParseException {
        //start here - начни тут
        String id;
        String name;
        Sex sex;
        Date date;

        if(args.length > 0) {
            switch(args[0]) {
                case "-c":
                    sex = sexRusToEng(args[2]);
                    date = parseDate(args[3]);

                    if(sex == Sex.FEMALE) {
                        allPeople.add(Person.createFemale(args[1], date));
                    }
                    else {
                        allPeople.add(Person.createMale(args[1], date));
                    }

                    System.out.println(allPeople.size() - 1);
                    break;

                case "-u":
                    id = args[1];
                    name = args[2];
                    sex = sexRusToEng(args[3]);
                    date = parseDate(args[4]);
                    allPeople.get(Integer.parseInt(id)).setName(name);
                    allPeople.get(Integer.parseInt(id)).setSex(sex);
                    allPeople.get(Integer.parseInt(id)).setBirthDate(date);
                    break;

                case "-d":
                    id = args[1];
                    allPeople.get(Integer.parseInt(id)).setName(null);
                    allPeople.get(Integer.parseInt(id)).setSex(null);
                    allPeople.get(Integer.parseInt(id)).setBirthDate(null);
                    break;

                case "-i":

                    try {
                        id = args[1];
                        Person person = allPeople.get(Integer.parseInt(id));
                        name = person.getName();
                        String sexRus = sexEngToRus(person.getSex());
                        date = person.getBirthDate();
                        StringBuilder builder = new StringBuilder();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        builder.append(name).append(" ")
                                .append(sexRus).append(" ")
                                .append(formatter.format(date));
                        System.out.println(builder);
                    }
                    catch(NullPointerException e) {
                        System.out.println("запись пуста");
                    }

                    break;

                default:
                    break;
            }
        }
    }


    private static Sex sexRusToEng(String sex) throws SexException {
        Sex result = null;
        if(sex.equals("м")) {
            result = Sex.MALE;
        }
        else {
            if(sex.equals("ж")) {
                result = Sex.FEMALE;
            }
            else {
                throw new SexException("м или ж");
            }
        }

        return result;
    }

    private static String sexEngToRus(Sex sex) {
        String result;
        if(sex == Sex.MALE) {
            result = "м";
        }
        else {
            result = "ж";
        }

        return result;
    }

    private static class SexException extends Exception {

        public SexException(String message) {
            super(message);
        }
    }

    private static Date parseDate(String param) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        return parser.parse(param);
    }


}
