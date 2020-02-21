package com.lectricas.leetcode;

import java.util.Scanner;

public class MergeSortAgain {

    long inversions;

    public static void main(String[] args) {
        MergeSortAgain m = new MergeSortAgain();
        m.run();
    }

    private void run() {

//        Scanner s = new Scanner(System.in);
//        int[] arr = new int[s.nextInt()];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = s.nextInt();
//        }
        int[] arr = new int[]{8,7,6,5,4,3,2,1};

        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);

        System.out.println(inversions);
    }

    public void mergeSort(int[] arr, int[] aux, int l, int r) {
        if (l < r) {
            int middle = (l + r) / 2;
            mergeSort(arr, aux, l, middle);
            mergeSort(arr, aux, middle + 1, r);
            merge(arr, aux, l, r, middle);
        }
    }

    public void merge(int[] arr, int[] aux, int lo, int hi, int middle) {

        assert isSortedAsc(arr, lo, middle);
        assert isSortedAsc(arr, middle + 1, hi + 1);

        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int i = lo;
        int j = middle + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > middle) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                inversions += (middle + 1) - i;
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }

        assert isSortedAsc(arr, lo, hi);
    }


    public static boolean isSortedAsc(int[] arr, int from, int to) {
        for (int i = from; i < to - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
