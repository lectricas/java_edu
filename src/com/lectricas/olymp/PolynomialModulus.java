package com.lectricas.olymp;

import java.util.Scanner;

public class PolynomialModulus {
    public static void main(String[] args) {
        PolynomialModulus m = new PolynomialModulus();
        m.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] args = new int[n + 1];
        int[] powers = new int[n + 1];

        for (int i = args.length - 1; i >=0 ; i--) {
            args[i] = s.nextInt();
        }

        for (int x = 0; x < m; x++) {
            int total = args[0];
            powers[0] = 1;
            for (int i = 1; i < n + 1; i++) {
                powers[i] = x * powers[i - 1];
                total += powers[i] * args[i];
            }
            System.out.println(total);
        }
    }
}
