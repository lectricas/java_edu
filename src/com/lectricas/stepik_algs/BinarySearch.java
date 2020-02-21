package com.lectricas.stepik_algs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch {

    int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        BinarySearch b = new BinarySearch();
        b.run();
    }

    private void run() throws FileNotFoundException {
        File f = new File("input.txt");
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        arr = new int[length];
        int i = 0;
        while (i < length) {
            arr[i] = s.nextInt();
            i++;
        }

        int count = s.nextInt();
        while (count != 0) {
            int toSearch = s.nextInt();
            System.out.print(find(toSearch) + " ");
            count--;
        }
    }

    private int find(int toSearch) {
        int j = 0;
        int k = arr.length - 1;

        while (j <= k) {
            int middle = (j + k) / 2;
            if (arr[middle] == toSearch) {
                return middle + 1;
            } else if (arr[middle] > toSearch) {
                k = middle - 1;
            } else {
                j = middle + 1;
            }
        }
        return -1;
    }
}
