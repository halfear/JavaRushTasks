package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return false;
        }
        if(o == null) {
            return false;
        }
        if(!(o instanceof Solution)) {
            return false;
        }
        Solution n = (Solution) o;
        boolean result = false;
        if(this.first == null && this.last != null) {
            result = n.first == null && n.last.equals(this.last);
        }
        else if(this.first != null && this.last == null) {
            result = n.first.equals(this.first) && n.last == null;
        }
        else if(this.first == null && this.last == null) {
            result = n.first == null && n.last == null;
        }
        else
            result = n.first.equals(this.first) && n.last.equals(this.last);
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
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
