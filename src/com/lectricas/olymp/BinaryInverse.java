package com.lectricas.olymp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BinaryInverse {
    public static void main(String[] args) throws Exception {
        BinaryInverse zero = new BinaryInverse();
        zero.run();
    }

    private void run() throws Exception {
        FastInput f = new FastInput();
        int n = f.nextInt();
        int m = f.nextInt();
        int[] ks = f.lineToIntArr(m);
        int left = -1;
        int right = n;
        for (int i = 0; i < ks.length; i++) {
            int middle = (left + right) / 2;
            if (ks[i] == 0) {
                left = middle;
            } else {
                right = middle;
            }
        }
        System.out.println(right);
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
