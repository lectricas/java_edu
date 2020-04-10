package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polynomials {

    private static double EST = 10E-14;

    public static void main(String[] args) throws FileNotFoundException {
        Polynomials p = new Polynomials();
        p.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
//        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] coef = new int[n + 1];
        for (int i = 0; i < coef.length; i++) {
            coef[i] = s.nextInt();
        }

        double left = -1;
        double right = 1;

        while (sample(coef, left) * sample(coef, right) > 0) {
            left*=2;
            right*=2;
        }

        System.out.println(left);
        System.out.println(right);

        double tempLeft = sample(coef, left);
        double tempRight = sample(coef, right);
        if (tempLeft > tempRight) {
            double t = left;
            left = right;
            right = t;
        }

        double x = 0;
        double y = 0;

        for (int i = 0; i < 200; i++) {
            x = (left + right) / 2;
            y = sample(coef, x);
            if (y < 0.0) {
                left = x;
            } else {
                right = x;
            }
        }

        System.out.println(x);
    }

    private Double sample(int[] couef, double value) {
        double answer = couef[0];
        for (int i = 1; i < couef.length; i++) {
            answer = value * answer + couef[i];
        }
        return answer;
    }
}
