package com.anil.sample.datastructure.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortExample {
    public static void main(String[] args) {
        List<Integer> unsorted = new ArrayList<>();
        unsorted.add(10);
        unsorted.add(7);
        unsorted.add(4);
        unsorted.add(11);
        unsorted.add(3);
        unsorted.add(2);
        unsorted.add(9);
        unsorted.add(6);
        unsorted.add(69);
        unsorted.add(16);
        unsorted.add(26);
        unsorted.add(34);
        unsorted.add(34);
        unsorted.add(0);

        System.out.println("unsorted = " + unsorted);
        List<Integer> sorted = getMergeSortedList(unsorted);
        System.out.println("sorted = " + sorted);
    }

    private static List<Integer> getMergeSortedList(List<Integer> unsorted) {
        if (unsorted == null || unsorted.size() < 2) {
            return unsorted;
        }
        int size = unsorted.size();
        int mid = size / 2;
        List<Integer> partOneSorted = getMergeSortedList(new ArrayList<>(unsorted.subList(0, mid)));
        List<Integer> partTwoSorted = getMergeSortedList(new ArrayList<>(unsorted.subList(mid, size)));
        List<Integer> sortedList = new ArrayList<>(size);
        int partOnePosition = 0;
        int partTwoPosition = 0;
        boolean allSorted = false;
        while (!allSorted) {
            if (partOnePosition == partOneSorted.size() && partTwoPosition == partTwoSorted.size()) {
                allSorted = true;
            } else if (partOnePosition < partOneSorted.size()) {
                if (partTwoPosition < partTwoSorted.size()) {
                    if (partOneSorted.get(partOnePosition) < partTwoSorted.get(partTwoPosition)) {
                        sortedList.add(partOneSorted.get(partOnePosition));
                        partOnePosition++;
                    } else {
                        sortedList.add(partTwoSorted.get(partTwoPosition));
                        partTwoPosition++;
                    }
                } else {
                    sortedList.add(partOneSorted.get(partOnePosition));
                    partOnePosition++;
                }
            } else {
                sortedList.add(partTwoSorted.get(partTwoPosition));
                partTwoPosition++;
            }


        }
        return sortedList;
    }
}
