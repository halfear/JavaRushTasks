package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] personProfile = fileScanner.nextLine().split(" ");
            String firstName = personProfile[1];
            String middleName = personProfile[2];
            String lastName = personProfile[0];
            Calendar calendar = new GregorianCalendar(
                    Integer.parseInt(personProfile[5]),
                    Integer.parseInt(personProfile[4]) - 1,
                    Integer.parseInt(personProfile[3])
            );
            Date birthDate = calendar.getTime();

            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
