package com.lectricas.olymp;

public class SunOfDice {
    public static void main(String[] args) {

        int[] prob = new int[19];
        for (int i = 1; i <= 6 ; i++) {
            for (int j = 1; j <= 6 ; j++) {
                for (int k = 1; k <= 6 ; k++) {
                    prob[i+j+k]++;
                }
            }
        }

        for (int i = 0; i < prob.length; i++) {
            System.out.println(i + " " + prob[i]);
        }
    }
}
