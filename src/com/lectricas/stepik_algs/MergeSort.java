package com.lectricas.stepik_algs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MergeSort {

    int[] arr;

    int inversions = 0;

    public static void main(String[] args) throws FileNotFoundException {
        MergeSort m = new MergeSort();
        m.run();
    }

    private void run() throws FileNotFoundException {
        File f = new File("input.txt");
        Scanner s = new Scanner(f);
        int count = s.nextInt();

        arr = new int[]{4, 3, 2, 1};
//        count = 0;
//        while (count < arr.length) {
//            arr[count] = s.nextInt();
//            count++;
//        }

        MergeSort(0, arr.length - 1);

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + ",");
//        }

        System.out.println(inversions);
    }

    private void MergeSort(int i, int j) {
        if (i < j) {
            int middle = (i + j) / 2;

            MergeSort(i, middle);
            MergeSort(middle + 1, j);
            merge(i, j, middle);
        }
    }

    private void merge(int left, int right, int middle) {

//        System.out.println("left="+left + " right=" + right + " middle=" + middle);

        int[] a1 = new int[middle - left + 1];
        int[] a2 = new int[right - middle];

        for (int i = 0; i < a1.length; i++) {
            a1[i] = arr[i + left];
        }

        for (int i = 0; i < a2.length; i++) {
            a2[i] = arr[i + middle + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                arr[k] = a1[i];
                i++;
            } else {
                inversions += a1.length - i;
                arr[k] = a2[j];
                j++;
            }
            k++;
        }

        while (i < a1.length) {
            arr[k] = a1[i];
            i++;
            k++;
        }

        while (j < a2.length) {
            arr[k] = a2[j];
            j++;
            k++;
        }
    }
}
