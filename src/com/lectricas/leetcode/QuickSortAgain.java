package com.lectricas.leetcode;

import java.util.Arrays;

public class QuickSortAgain {

    public static void main(String[] args) {
        QuickSortAgain quickSortAgain = new QuickSortAgain();
        quickSortAgain.run();
    }

    private void run() {
        int[] arr = new int[]{4, 5, 2, 3, 1, 3};
//        shuffle(arr);

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

//        System.out.println();

        int kthmax = sort(arr, 0, arr.length - 1, 5);


//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

        System.out.println(kthmax);
    }

    public int sort(int[] arr, int lo, int hi, int k) {
        while (lo < hi) {
            int j = partition(arr, lo, hi);
            if (k > j) {
                lo = j + 1;
            } else if (k < j) {
                hi = j - 1;
            } else {
                return arr[j];
            }
        }
        return arr[k];
    }

    private int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (arr[++i] < arr[lo]) {
                if (i == hi) {
                    break;
                }
            }

            while (arr[--j] > arr[lo]) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }

        swap(arr, lo, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1]
            int r = i + (int) (Math.random() * (n - i));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }
}
