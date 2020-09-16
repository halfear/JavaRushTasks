package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (this.anInt != solution1.anInt) return false;
        if (Double.compare(solution1.aDouble, this.aDouble) != 0) return false;
        if (this.date != null ? !this.date.equals(solution1.date) : solution1.date != null) return false;
        if (this.solution != null ? !this.solution.equals(solution1.solution) : solution1.solution != null) return false;
        if (this.string != null ? !this.string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) temp; //(temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (string != null ? string.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> set = new HashSet<>();
        set.add(new Solution(8, "eight", 1.2, new Date(1983,06,8), null));
        System.out.println(set.contains(new Solution(8, "eight", 1.2, new Date(1983,06,8), null)));
    }
}
