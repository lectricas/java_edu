package com.lectricas.rucode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Frogs {
    public static void main(String[] args) {
        Frogs f = new Frogs();
        f.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        long x = s.nextLong();
        long p = s.nextLong();
        int k = s.nextInt();
        long m = s.nextLong();
        long d = s.nextLong();


        int[] heat = new int[k];
        int[] post = new int[k];
        Arrays.fill(heat, 1);
        while (true) {
            int stone = 0;
            System.out.println();
            for (int i = 0; i < post.length; i++) {
                System.out.print(post[i] + " ");
            }
            System.out.println();

            stone++;
            heat[0] += modPow(x, stone, p);
            post[0]++;
            boolean prevHas = true;
            int frog = 1;
            while (frog < k && prevHas) {
                if (heat[frog - 1] % m == 0) {
                    post[frog]++;
                    heat[frog] += modPow(x, stone, p);
                } else {
                    prevHas = false;
                }
                frog++;
            }
            if (post[0] - post[k - 1] >= d) {
                break;
            }
        }

        System.out.println(post[0]);
    }

    public static long modPow(long base, long exponent, long modulus) {
        long result = 1L;
        base = base % modulus;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }
        return result;
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
