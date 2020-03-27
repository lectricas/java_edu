package com.lectricas.olymp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MaxSubArray {
    public static void main(String[] args) throws Exception {
        MaxSubArray subArray = new MaxSubArray();
        subArray.run();
    }

    private void run() throws Exception {
        FastInput input = new FastInput();
        long[] summ = new long[input.nextInt()];

        for (int i = 0; i < summ.length; i++) {
            summ[i] = input.nextLong();
        }

        long max = summ[0];
        for (int i = 1; i < summ.length; i++) {
            if (summ[i] < summ[i] + summ[i-1]) {
                summ[i] = summ[i] + summ[i-1];
            }
            if (summ[i] > max) {
                max = summ[i];
            }
        }
        System.out.println(max);
    }


    private static final class FastInput {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        private String nextLine() throws Exception {
            return br.readLine();
        }

        private int nextInt() throws Exception {
            return Integer.parseInt(nextWord());
        }

        private long nextLong() throws Exception {
            return Long.parseLong(nextWord());
        }

        private String nextWord() throws Exception {
            if (st == null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine(), " ");
            return st.nextToken();
        }

        private int[] lineToIntArr(int len) throws Exception {
            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++) arr[i] = nextInt();
            return arr;
        }
    }
}
