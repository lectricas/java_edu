package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Cows {
    public static void main(String[] args) throws FileNotFoundException {
        Cows c = new Cows();
        c.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
//        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] stables = new int[n];
        for (int i = 0; i < stables.length; i++) {
            stables[i] = s.nextInt();
        }

        int left = 0;
        int right = stables[n - 1];

        while (right > left + 1) {
            int middle = (right + left) / 2;
            boolean canFit = canFitWithDistance(stables, middle, k);
//            System.out.println(middle + " " + canFit);
            if (canFit) {
                left = middle;
            } else {
                right = middle;
            }
        }

        System.out.println(left);
    }

    private boolean canFitWithDistance(int[] arr, int distance, int n) {
        int total = 1;
        int slow = 0;
        int fast = 1;
        while (fast < arr.length) {
            while (fast < arr.length - 1 && arr[fast] - arr[slow] < distance) {
                fast++;
            }

            if (arr[fast] - arr[slow] >= distance) {
                total++;
            }
            slow = fast;
            fast = slow + 1;
        }

        return total >= n;
    }
}
