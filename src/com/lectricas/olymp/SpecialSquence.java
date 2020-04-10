package com.lectricas.olymp;

import java.util.Arrays;

public class SpecialSquence {

    public static void main(String[] args) {
        int arr[] = new int[200];
        int r = 0;
        for (int i = 2; i < 100; i++) {
            for (int j = 2; j < 100; j++) {
                int number = (int) Math.pow(j, i);
                char[] chars = (number + "").toCharArray();

                int sum = 0;
                for (int k = 0; k < chars.length; k++) {
                    sum += Character.getNumericValue(chars[k]);
                }

                if (sum == j) {
                    arr[r++] = number;
//                    System.out.println(j + " " + " "+ i + " " + number);
                }

            }
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static boolean isInt(double d) {
        return d == (int) d;
    }


}
