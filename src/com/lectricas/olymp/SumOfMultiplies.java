package com.lectricas.olymp;

public class SumOfMultiplies {
    public static void main(String[] args) {
        int total = 0;
        int n = 5;
        for (int i = 1; i<=n; i++) {
            for(int j = i+1; j<=n; j++) {
                int temp = i * j;
                total++;
                System.out.print("tic ");
            }
            System.out.println();
        }
        System.out.println(total);
    }
}
