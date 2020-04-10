package com.lectricas.olymp;

public class Csc2016 {
    public static void main(String[] args) {
        Csc2016 csc2016 = new Csc2016();
        csc2016.run();
    }

    private void run() {
        double answer = calc(2015, 2016, 2017);
        System.out.println(answer);
    }

    private double calc(double cur, double next, int n) {
        if (n == 2) {
            return next;
        } else {
            return calc(next, (next + 1) / cur, n - 1);
        }
    }
}
