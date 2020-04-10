package com.lectricas;

public class LivingPeople {
    public static void main(String[] args) {
        int[][] arr = new int[5][2];
        arr[0] = new int[]{1,9};
        arr[1] = new int[]{3,4};
        arr[2] = new int[]{5,7};
        arr[3] = new int[]{2,3};
        arr[4] = new int[]{9,10};

        int max = 0;
        int [] y = new int[11];
        for (int i = 0; i < arr.length; i++) {
            y[arr[i][0]]++;
            y[arr[i][1]]--;
        }
        for (int i = 0; i < y.length; i++) {
            System.out.print(y[i] + " ");
        }
    }
}
