package com.lectricas.stepik_algs;

import java.util.Scanner;

class CountSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arrA = new int[s.nextInt()];
        int[] arrC = new int[arrA.length];
        int[] arrB = new int[10];
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = s.nextInt();
            arrB[arrA[i] - 1] = arrB[arrA[i] - 1] + 1;
        }

        for (int i = 1; i < arrB.length; i++) {
            arrB[i] = arrB[i] + arrB[i - 1];
        }

        for (int i = 0; i < arrA.length; i++) {
            int position = arrB[arrA[i] - 1] - 1;
            arrB[arrA[i] - 1] = position;
            arrC[position] = arrA[i];
        }

        for (int i = 0; i < arrC.length; i++) {
            System.out.print(arrC[i] + " ");
        }
    }
}
