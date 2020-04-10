package com.lectricas.rucode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class SumOfTwo {
    public static void main(String[] args) throws Exception {
        SumOfTwo t = new SumOfTwo();
        t.run();
    }

    private void run() throws Exception {
        FastInput f = new FastInput();
        long a = f.nextLong();
        long b = f.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(a * b + "\n");
        bw.flush();

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
