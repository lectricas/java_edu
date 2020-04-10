package com.lectricas.olymp;

import java.math.BigInteger;
import java.util.Scanner;

class ThreeNumbers {
    public static void main(String[] args) {
        ThreeNumbers n = new ThreeNumbers();
        n.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();
        long c = s.nextLong();

        BigInteger bA = BigInteger.valueOf(a);
        BigInteger bB = BigInteger.valueOf(b);
        BigInteger bC = BigInteger.valueOf(c);

        BigInteger num = bA.multiply(bB).multiply(bC);
//        System.out.println(num.toString());

        BigInteger demon = bA.multiply(bB).add(bA.multiply(bC)).add(bB.multiply(bC));
//        System.out.println(demon.toString());

        System.out.println(num.divide(demon));
    }
}
