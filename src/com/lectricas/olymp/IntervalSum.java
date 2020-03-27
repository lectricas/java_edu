package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class IntervalSum {
    public static void main(String[] args) throws FileNotFoundException {

        IntervalSum i = new IntervalSum();
        i.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
//        Scanner s = new Scanner(System.in);
        long[] sums = new long[s.nextInt()];
        int requests = s.nextInt();
        sums[0] = s.nextInt();


        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + s.nextInt();
        }

        for (int i = 0; i < requests; i++) {
            int l = s.nextInt() - 1;
            int r = s.nextInt() - 1;
            if (l == 0) {
                System.out.println(sums[r]);
            } else {
                System.out.println(sums[r] - sums[l - 1]);
            }
        }

    }

    private static int readInt(InputStream in) throws IOException {
        int ret = 0;
        boolean dig = false;

        for (int c = 0; (c = in.read()) != -1; ) {
            if (c >= '0' && c <= '9') {
                dig = true;
                ret = ret * 10 + c - '0';
            } else if (dig) break;
        }

        return ret;
    }
}
