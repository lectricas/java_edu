package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Ropes {
    public static void main(String[] args) throws FileNotFoundException {
        Ropes r = new Ropes();
        r.run();
    }

    private void run() throws FileNotFoundException {
//        Scanner s = new Scanner(new File("input.txt"));
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] ropes = new int[n];

        int left = 0;
        int right = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < ropes.length; i++) {
            ropes[i] = s.nextInt();
            if (ropes[i] > right) {
                right = ropes[i];
            }
            total = total + ropes[i];
        }

        right++;
        while (right > left + 1) {
            int middle = (left + right) / 2;
            if (canCut(ropes, middle, k)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        System.out.println(left);

    }

    private boolean canCut(int[] arr, int length, int n) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i] / length;
        }
        return total >= n;
    }
}
