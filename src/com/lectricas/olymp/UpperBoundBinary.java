package com.lectricas.olymp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class UpperBoundBinary {
    public static void main(String[] args) throws Exception {
        UpperBoundBinary b = new UpperBoundBinary();
        b.run();
    }

    private void run() throws Exception {
        FastInput f = new FastInput();
        int size = f.nextInt();
        int qSize = f.nextInt();
        int[] arr = f.lineToIntArr(size);
        int[] query = f.lineToIntArr(qSize);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < query.length; i++) {
            String a = binary(query[i], arr);
            bw.write(a + "\n");
        }
        bw.flush();
    }

    private String binary(int k, int[] arr) {
        int left = -1;
        int right = arr.length;
        while (right > left + 1) {
            int middle = (left + right) / 2;
            if (k < arr[middle]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        if (right < arr.length) {
            return String.valueOf(right + 1);
        } else {
            return "NO SOLUTION";
        }
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
