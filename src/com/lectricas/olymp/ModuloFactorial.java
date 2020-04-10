package com.lectricas.olymp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class ModuloFactorial {

    private static long MOD = (long) 10E5 + 3;

    public static void main(String[] args) throws IOException {
        long before = System.currentTimeMillis();
        ModuloFactorial m = new ModuloFactorial();
        m.run();
    }

    private void run() throws IOException {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long one = 1;
        int k = 1;
        if (n >= MOD) {
            System.out.println(0);
        } else {
            while (k <= n) {
                one = mMul(one, k, MOD);
                k++;
            }
        }
        System.out.println(one);
    }

    public static long norm(long d, long MOD) {
        return (d % MOD + MOD) % MOD;
    }

    public static long mAdd(long a, long b, long MOD) {
        return norm(norm(a, MOD) + norm(b, MOD), MOD);
    }

    public static long mSub(long a, long b, long MOD) {
        return norm(norm(a, MOD) - norm(b, MOD), MOD);
    }

    public static long mMul(long a, long b, long MOD) {
        return norm(norm(a, MOD) * norm(b, MOD), MOD);
    }
}
