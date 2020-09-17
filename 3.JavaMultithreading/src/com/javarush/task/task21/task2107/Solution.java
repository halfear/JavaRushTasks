package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    protected Map<String, User> users = new LinkedHashMap();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = solution.clone();
        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);
    }

    @Override
    public Solution clone() {
        Solution sol = new Solution();
        Map<String, User> usr = new LinkedHashMap<>();
        for(Map.Entry<String, User> ent : users.entrySet()) {
            usr.put(ent.getKey(), ent.getValue());
        }
        sol.users = usr;

        return sol;
    }

    @Override
    public int hashCode() {
        return 31 * users.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(!(obj instanceof Solution)) return false;

        Solution solution = (Solution) obj;

        return solution.users.equals(this.users);
    }

    public static class User implements Cloneable {
        int age;
        String name;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public int hashCode() {
            return 31 * (age + name.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(obj == null) return false;
            if(!(obj instanceof User)) return false;

            User user = (User) obj;

            return user.age == this.age && user.name.equals(this.name);
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
