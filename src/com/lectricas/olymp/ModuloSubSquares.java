package com.lectricas.olymp;

import java.util.Scanner;

class ModuloSubSquares {

    private static long MOD = (long) (10E5 + 7);

    public static void main(String[] args) {
        ModuloSubSquares subSquares = new ModuloSubSquares();
        subSquares.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        long sA = mMul(a, a, MOD);
        long sB = mMul(b, b, MOD);
        System.out.println(mSub(sA, sB, MOD));
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
