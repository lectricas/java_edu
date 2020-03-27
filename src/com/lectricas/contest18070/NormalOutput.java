package com.lectricas.contest18070;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class NormalOutput {

    public static void main(String[] args) throws FileNotFoundException {
        NormalOutput output = new NormalOutput();
        output.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        int n = s.nextInt();
        int[] canonic = new int[n];
        for (int i = 0; i < n; i++) {
            canonic[i] = s.nextInt();
        }
        int m = s.nextInt();


        int[] toCheck = new int[m];
        for (int i = 0; i < toCheck.length; i++) {
            toCheck[i] = s.nextInt();
        }
        Arrays.sort(canonic);


        for (int i = 0; i < toCheck.length; i++) {
            int searched = search(canonic, toCheck[i]);
            System.out.println(searched);
        }
    }

    public static int search(int[] a, int value) {

        if(value < a[0]) {
            return a[0];
        }
        if(value > a[a.length-1]) {
            return a[a.length-1];
        }

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (value < a[mid]) {
                hi = mid - 1;
            } else if (value > a[mid]) {
                lo = mid + 1;
            } else {
                return a[mid];
            }
        }
        // lo == hi + 1
        return (a[lo] - value) < (value - a[hi]) ? a[lo] : a[hi];
    }
}
