package com.lectricas.coursera.princeton;

public class MergeWithHalfSpace {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 2, 3, 5};

        int[] aux = new int[3];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = arr[i];
        }

        int i = 0;
        int j = aux.length;
        int k = 0;
        while (k < aux.length) {
            if (aux[i] > arr[j]) {
                arr[k++] = arr[j++];
            } else {
                arr[k++] = aux[i++];
            }
        }

        System.out.println();


        for (int r = 0; r < i; r++) {
            aux[r] = arr[j++];
        }

        int maxJ = i;
        j = 0;
        while (k < arr.length) {
            if (j >= maxJ) {
                arr[k++] = aux[i++];
            } else if (i >= aux.length) {
                arr[k++] = aux[j++];
            } else if (aux[j] < aux[i]) {
                arr[k++] = aux[j++];
            } else {
                arr[k++] = aux[i++];
            }
        }

        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.print(arr[i1] + " ");
        }
    }
}
