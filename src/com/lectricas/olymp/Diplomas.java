package com.lectricas.olymp;

import java.io.FileNotFoundException;
import java.util.Scanner;

class Diplomas {
    public static void main(String[] args) throws FileNotFoundException {
        Diplomas d = new Diplomas();
        d.run();
    }

    private void run() throws FileNotFoundException {
//        Scanner s = new Scanner(new File("input.txt"));
        Scanner s = new Scanner(System.in);
        long w = s.nextInt();
        long h = s.nextInt();
        long n = s.nextInt();

        long left = 0; // длинна стороны
        long right = Math.max(w, h) * n; //длинна стороны

        while (right > left + 1) {
            long middle = (left + right) / 2;
            long widthCount = middle / w;
            long heightCount = middle / h;
            if (widthCount * heightCount < n) {
                left = middle;
            } else {
                right = middle;
            }
        }

        System.out.println(right);
    }
}
