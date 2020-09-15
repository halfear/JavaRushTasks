package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        Solution sol = (Solution) obj;

        boolean result = false;
        if(this.first == null && this.last != null) {
            result = sol.first == null && sol.last.equals(this.last);
        }
        else if(this.first != null && this.last == null) {
            result = sol.first.equals(this.first) && sol.last == null;
        }
        else if(this.first == null && this.last == null) {
            result = sol.first == null && sol.last == null;
        }
        else
            result = sol.first.equals(this.first) && sol.last.equals(this.last);
        return result;
    }

    @Override
    public int hashCode() {
        int result = 1;
        if(first != null && last != null) {
            result = 31 * (first.hashCode() + last.hashCode());
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, "Duck"));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
