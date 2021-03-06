package com.lectricas.rucode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Locomotiv {
    public static void main(String[] args) throws Exception {
        Locomotiv l = new Locomotiv();
        l.run();
    }

    private void run() throws Exception {
        FastInput f = new FastInput();
        int max = f.nextInt();
        int n = f.nextInt();
        int[] train = f.lineToIntArr(n);

        int fast = 0;
        int slow = 0;
        int totalWeight = 0;
        while (fast < train.length) {
            if (fast - slow < 4) {
                totalWeight += train[fast++];
            } else {
                totalWeight -= train[slow++];
                totalWeight += train[fast++];
            }
            if (totalWeight > max) {
                fast--;
                break;
            }
        }


        int a = fast - 1;
        if (a < 0) {
            a = 0;
        }
        System.out.println(a);
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
