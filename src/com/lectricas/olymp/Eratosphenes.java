package com.lectricas.olymp;

import java.util.Scanner;

public class Eratosphenes {
    public static void main(String[] args) {
        Eratosphenes er = new Eratosphenes();
        er.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[s.nextInt() + 1];

        for (int i = 2; i * i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j < arr.length; j += i) {
                    if (arr[j] == 0) {
                        arr[j] = i;
                    }
                }
            }
        }

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total+=arr[i];

        }
        System.out.println(total);
    }
}
