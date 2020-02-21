package com.lectricas.stepik_algs;

import java.util.Scanner;

public class LISBottomUp {

    public static void main(String[] args) {
        LISBottomUp lisBottomUp = new LISBottomUp();
        lisBottomUp.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[s.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        int[] dist = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dist[i] = 1;
            int j = 0;
            while (j < i) {
                if (arr[i] % arr[j] == 0 && dist[j] + 1 > dist[i]) {
                    dist[i] = dist[i] + 1;
                }
                j++;
            }
        }

        int max = 1;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] > max) {
                max = dist[i];
            }
        }

        System.out.println(max);
    }
}
