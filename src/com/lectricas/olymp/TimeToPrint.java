package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TimeToPrint {
    public static void main(String[] args) throws FileNotFoundException {
        TimeToPrint p = new TimeToPrint();
        p.run();
    }

    private void run() throws FileNotFoundException {
//        Scanner s = new Scanner(new File("input.txt"));
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();

        int min = Math.min(x, y);
        long right = min * (n + 1);
        long left = 0;

        while (right > left + 1) {
            long middle = (left + right) / 2;
            if ((middle / x + middle / y) < n - 1) {
                left = middle;
            } else {
                right = middle;
            }
        }

        System.out.println(right + min);
    }
}
