package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Alexey");
            user.setLastName("Borisov");
            user.setBirthDate(new GregorianCalendar(1983, 7, 7).getTime());
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (PrintWriter writer = new PrintWriter(outputStream)){
                if(!this.users.isEmpty()) {
                    for(User user : this.users) {
                        writer.println(user.getFirstName() + ", " +
                                user.getLastName() + ", " +
                                user.getBirthDate().getTime() + ", " +
                                user.isMale() + ", " +
                                user.getCountry());
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;

                while((line = reader.readLine()) != null) {
                    String[] params = line.split(", ");
                    User user = new User();
                    user.setFirstName(params[0]);
                    user.setLastName(params[1]);
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTimeInMillis(Long.parseLong(params[2]));
                    user.setBirthDate(calendar.getTime());
                    user.setMale(params[3].equals("true"));
                    user.setCountry(recognizeCountry(params[4]));
                    this.users.add(user);
                }
            }
        }

        private User.Country recognizeCountry(String param) {
            User.Country country;

            switch(param) {
                case "RUSSIA":
                    country = User.Country.RUSSIA;
                    break;
                case "UKRAINE":
                    country = User.Country.UKRAINE;
                    break;
                default:
                    country = User.Country.OTHER;
            }
            return country;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
