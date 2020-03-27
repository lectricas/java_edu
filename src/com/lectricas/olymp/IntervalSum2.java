package com.lectricas.olymp;


import java.io.*;
import java.util.StringTokenizer;

class IntervalSum2 {
    public static void main(String[] args) throws Exception {

        IntervalSum2 i = new IntervalSum2();
        i.run();
    }

    private void run() throws Exception {

        FastInput f = new FastInput();

        long[] sums = new long[f.nextInt()];
        long[] answers = new long[f.nextInt()];


        sums[0] = f.nextInt();

        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + f.nextInt();
        }

        for (int i = 0; i < answers.length; i++) {
            int l = f.nextInt()- 1;
            int r = f.nextInt() - 1;
            if (l == 0) {
                answers[i] = sums[r];
            } else {
                answers[i] = sums[r] - sums[l - 1];
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < answers.length; i++) {
            bw.write(answers[i] + "\n");
        }
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

