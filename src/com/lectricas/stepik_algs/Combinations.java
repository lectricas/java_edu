package com.lectricas.stepik_algs;

import java.util.ArrayList;
import java.util.List;

class Combinations {

    List<String> arr = new ArrayList();
    StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        Combinations c = new Combinations();
        c.combinations(n, k, 0, n - 1, "");
        System.out.println();
    }

    private int combinations(int n, int k, int i, int j, String cache) {

        if (n == k) {
            str.append(cache);
            System.out.print(cache);
            for (int a = i; a <= j; a++) {
                str.append(a).append(" ");
                System.out.print(a + " ");
            }
            arr.add(str.toString());
            str = new StringBuilder();
            System.out.println();
            return 1;
        }

        if (k == 0) {
            arr.add(cache);
            System.out.print(cache);
            System.out.println();
            str = new StringBuilder();
            return 1;
        }

        return combinations(n - 1, k - 1, i + 1, j, cache + i + " ") + combinations(n - 1, k, i + 1, j, cache);
    }
}