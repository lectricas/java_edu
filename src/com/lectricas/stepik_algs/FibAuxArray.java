package com.lectricas.stepik_algs;

public class FibAuxArray {

    int[] aux;

    public static void main(String[] args) {
        FibAuxArray f = new FibAuxArray();
        f.run();
    }

    private void run() {
        long before = System.currentTimeMillis();
        int n = 45;
        aux = new int[n + 1];
        int i = fib(n);
        System.out.println(i);
        System.out.println(System.currentTimeMillis() - before + " ms");
    }

    private int fib(int i) {
        if (i < 2) {
            return i;
        }
        if (aux[i] != 0) {
            return aux[i];
        } else {
            aux[i] = fib(i - 2) + fib(i - 1);
            return aux[i];
        }
//        return fib(i - 2) + fib(i - 1);
    }

}
