package com.lectricas.olymp;

import java.util.Scanner;

class ModuloFib {

    private static long MOD = (long) (10E5 + 3);

    public static void main(String[] args) {
        ModuloFib m = new ModuloFib();
        m.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int m = s.nextInt();
        long zero = 0;
        long first = 1;

        int p = pesano(m);

        n = norm(n, p);

        while (n > 0) {
            long temp = mAdd(zero, first, m);
            zero = first;
            first = temp;
            n--;
        }

        System.out.println(zero);
    }

    private int pesano(int mod) {
        long zero = 0;
        long first = 1;
        int k = 0;
        int m = mod * 6;

        while (k < m) {
            long temp = mAdd(zero, first, mod);
            zero = first;
            first = temp;
            k++;
            if (zero == 0 && first == 1) {
                return k;
            }
        }
        throw new IllegalStateException("No way");
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
