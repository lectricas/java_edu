package com.lectricas.contest18070;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WinMatrix {

    public static void main(String[] args) throws FileNotFoundException {
        WinMatrix matrix = new WinMatrix();
        matrix.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        int n = s.nextInt();
        int[] matrix = new int[n * n];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int num = s.nextInt();
            matrix[i] = num;
            if (num != 0) {
                set.add(num);
            }

        }

        int i = 1;
        int j = 0;
        while (i < n * n + 1) {
            if (set.contains(i)) {
                i++;
            } else if (matrix[j] != 0) {
                j++;
            } else {
                matrix[j] = i;
                i++;
                j++;
            }

        }

        for (int p = 0; p < matrix.length; p++) {
            System.out.print(matrix[p] + " ");
            if ((p + 1) % n == 0) {
                System.out.println();
            }
        }
    }
}
