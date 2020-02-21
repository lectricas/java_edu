package com.lectricas.contest5048;

import java.io.FileNotFoundException;

public class VasyaPetyaGame {
    public static void main(String[] args) throws FileNotFoundException {
        VasyaPetyaGame vp = new VasyaPetyaGame();
        vp.run();
    }

    private void run() throws FileNotFoundException {
        for (int n = 1; n < 100; n++) {
            if (checkNumber(n) == -1) {
                System.out.println(n);
            }
        }

    }

    private int checkNumber(int n) {
        for (int sk = 1; sk < 100000000; sk++) {
            int k = n * sk;

            int sum = 0;
            char[] chars = Integer.toString(k).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                sum += Character.getNumericValue(chars[j]);
            }

            if (sum == sk) {
//                System.out.println("n=" + n + " sk=" + sk + " k="+k);
                return 1;
            }
        }
        return -1;
    }


//            System.out.println(i + " by " + sum + " equals=" + (double) i / sum);

}
