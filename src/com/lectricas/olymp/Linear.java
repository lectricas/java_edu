package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Linear {

    private long cur = 0;
    public static void main(String[] args) throws FileNotFoundException {
        Linear l = new Linear();
        l.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
//        Scanner s = new Scanner(System.in);
        long[] arr = new long[s.nextInt()];
        cur = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        long max1 = Long.MIN_VALUE;
        int max1Index = -1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nextRand(a, b);
            if (arr[i] > max1) {
                max1 = arr[i];
                max1Index = i;
            }

        }
        long max2 = Long.MIN_VALUE;
        int max2Index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max2 && i != max1Index) {
                max2 = arr[i];
                max2Index = i;
            }
        }
        System.out.print(max1Index + 1 + " ");
        System.out.print(max2Index + 1);
    }

    private long nextRand(int a, int b) {
        int mod = 1791791791;
        cur = (cur * a + b) % mod;
        return cur;
    }
}
