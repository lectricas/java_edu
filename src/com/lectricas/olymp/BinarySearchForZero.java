package com.lectricas.olymp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BinarySearchForZero {
    public static void main(String[] args) throws Exception {
        BinarySearchForZero zero = new BinarySearchForZero();
        zero.run();
    }

    private void run() throws Exception {
        FastInput f = new FastInput();
        int n = f.nextInt();
        int m = f.nextInt();
        int[] ks = f.lineToIntArr(m);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < ks.length; i++) {
            bw.write(binary(ks[i], n)+ "\n");
        }
        bw.flush();
    }

    private int binary(int k, int n) {
        int left = -1;
        int right = n;
        int count = 0;
        while (right > left + 1) {
            count++;
            int middle = (left + right) / 2;
            if (k > middle) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return count;
    }

    private static final class FastInput {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        private String nextLine() throws Exception { return br.readLine(); }
        private int nextInt() throws Exception { return Integer.parseInt(nextWord()); }
        private long nextLong() throws Exception { return Long.parseLong(nextWord()); }

        private String nextWord() throws Exception {
            if (st==null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine(), " ");
            return st.nextToken();
        }

        private int[] lineToIntArr(int len) throws Exception {
            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++) arr[i] = nextInt();
            return arr;
        }
    }
}
