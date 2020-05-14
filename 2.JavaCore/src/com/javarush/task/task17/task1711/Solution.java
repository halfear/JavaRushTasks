package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

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
        Person person;

        if(args.length > 0) {
            switch(args[0]) {
                case "-c":
                    synchronized(allPeople) {
                        for(int i = 3; i < args.length; i += 3) {
                            name = args[i - 2];
                            sex = sexRusToEng(args[i - 1]);
                            date = parseDate(args[i]);

                            if(sex == Sex.FEMALE) {
                                person = Person.createFemale(name, date);
                            }
                            else {
                                person = Person.createMale(name, date);
                            }

                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }

                    break;

                case "-u":
                    synchronized(allPeople) {
                        for(int i = 4; i < args.length; i += 4) {
                            id = args[i - 3];
                            name = args[i - 2];
                            sex = sexRusToEng(args[i - 1]);
                            date = parseDate(args[i]);
                            allPeople.get(Integer.parseInt(id)).setName(name);
                            allPeople.get(Integer.parseInt(id)).setSex(sex);
                            allPeople.get(Integer.parseInt(id)).setBirthDate(date);
                        }
                    }

                    break;

                case "-d":
                    synchronized(allPeople) {
                        for(int i = 1; i < args.length; i++) {
                            id = args[i];
                            allPeople.get(Integer.parseInt(id)).setName(null);
                            allPeople.get(Integer.parseInt(id)).setSex(null);
                            allPeople.get(Integer.parseInt(id)).setBirthDate(null);
                        }
                    }

                    break;

                case "-i":
                    synchronized(allPeople) {
                        for(int i = 1; i < args.length; i++) {
                            try {
                                id = args[i];
                                person = allPeople.get(Integer.parseInt(id));
                                name = person.getName();
                                String sexRus = person.getSex().toString();
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
                        }
                    }

                    break;

                default:
                    synchronized(allPeople) {
                        break;
                    }
            }
        }
    }

    private static Sex sexRusToEng(String sex) throws SexException {
        Sex result;
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
