package com.lectricas.olymp;

import java.util.Scanner;

class CheckIfPrime {
    public static void main(String[] args) {
        CheckIfPrime p = new CheckIfPrime();
        p.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int m = (int) Math.sqrt(n);

        if (n < 3) {
            System.out.println(1);
            return;
        }
        if (n % 2 == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 3; i < m; i+=2) {
            if (n % i == 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
