package com.anil.sample.datastructure.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();
        System.out.println("Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        int[] data = new int[5];
        data[0] = 1;
        data[1] = 4;
        data[2] = 3;
        data[3] = 7;
        data[4] = 5;
        System.out.println("Data before sorting = " + getValues(data));
        bubbleSort(data);
    }

    private static String getValues(int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i] + " ");
        }
        return sb.toString();
    }

    private static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                int oneValue = data[i];
                int secondValue = data[j];
                if (oneValue < secondValue) {
                    data[i] = secondValue;
                    data[j] = oneValue;
                }
            }
            System.out.println("after iteration " + i + " = " + getValues(data));
        }
    }
}
