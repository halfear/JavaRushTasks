package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];

        Solution sol1 = new Solution();
        sol1.innerClasses[0] = new Solution.InnerClass();
        sol1.innerClasses[1] = new Solution.InnerClass();

        Solution sol2 = new Solution();
        sol2.innerClasses[0] = new Solution.InnerClass();
        sol2.innerClasses[1] = new Solution.InnerClass();

        result[0] = sol1;
        result[1] = sol2;

        return result;
    }

    public static void main(String[] args) {

    }
}
