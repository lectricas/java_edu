package com.lectricas.stepik_algs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

class QuickSort {

    int[] left;
    int[] right;
    int[] points;

    Random random = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        QuickSort q = new QuickSort();
        q.run();
//        int[] testArr = new int[]{3,3,3,4,5,5,6};
//        System.out.println(lowerBound(testArr, 0, testArr.length - 1, 6));
    }

    private static int lowerBound(int[] a, int low, int high, int element) {
        if (element > a[high]) {
            return high + 1;
        }
        while (low < high) {
            int middle = (low + high) >> 1;
            if (element > a[middle]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }


    private static int upperBound(int[] a, int low, int high, int element) {
        if (element >= a[high]) {
            return high + 1;
        }
        while (low < high) {
            int middle = (low + high) >> 1;
            if (a[middle] > element)
                high = middle;
            else
                low = middle + 1;
        }
        return low;
    }

    private void run() throws FileNotFoundException {
        File f = new File("input.txt");
        Scanner s = new Scanner(f);
        int n = s.nextInt();
        int m = s.nextInt();
        left = new int[n];
        right = new int[n];
        points = new int[m];

        for (int i = 0; i < n; i++) {
            left[i] = s.nextInt();
            right[i] = s.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = s.nextInt();
        }

        quickSort(left, 0, left.length - 1);
        quickSort(right, 0, right.length - 1);

        for (int i = 0; i < points.length; i++) {
            int point = points[i];
            int fromLeft = upperBound(left, 0, left.length - 1, point);
            int fromRight = lowerBound(right, 0, right.length - 1, point);
            System.out.print(fromLeft - fromRight + " ");
        }

    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = partition(arr, left, right);
            quickSort(arr, left, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int basis = random.nextInt(r - l) + l;
        swap(arr, l, basis);
        int i = l;
        int j = i + 1;
        while (j <= r) {
            if (arr[j] <= arr[l]) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        swap(arr, i, l);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
