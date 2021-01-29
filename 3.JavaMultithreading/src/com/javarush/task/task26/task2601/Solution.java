package com.javarush.task.task26.task2601;

import java.util.Arrays;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        Integer[] sourceArray = new Integer[]{13, 8, 15, 5, 17};
//        System.out.println(Arrays.toString(sourceArray));
//        System.out.println(Arrays.toString(sort(sourceArray)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer medianValue = getMedian(array);
        Arrays.sort(array, (o1, o2) -> {
            int o1MedianDelta = Math.abs(medianValue - o1);
            int o2MedianDelta = Math.abs(medianValue - o2);
            return o1MedianDelta - o2MedianDelta;
        });
        return array;
    }

    private static int getMedian(Integer[] array) {
        quickSort(array, 0, array.length - 1);
        int middle = array.length / 2;
        return array.length % 2 == 0
                ? (array[middle] + array[middle - 1]) / 2
                : array[middle];
    }

    public static void quickSort(Integer[] arr, int from, int to) {
        if (arr.length == 0) return;
        if (from >= to) return;

        int divideIndex = partition(arr, from, to);
        quickSort(arr, from, divideIndex - 1);
        quickSort(arr, divideIndex, to);
    }

    private static int partition(Integer[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(Integer[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
