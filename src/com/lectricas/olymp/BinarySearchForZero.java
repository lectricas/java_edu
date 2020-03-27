package com.lectricas.olymp;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchForZero {
    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchForZero zero = new BinarySearchForZero();
        zero.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] ks = new int[m];
        for (int i = 0; i < ks.length; i++) {
            int a = binary(s.nextInt(), n);
            System.out.println(a);
        }
    }

    private int binary(int k, int n) {
        int left = -1;
        int right = n;
        int count = 0;
        while (right > left + 1) {
            count++;
            int middle = (left + right) /2;
            if (middle == k) {
                return count;
            } else if (k > middle) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return count;
    }
}
