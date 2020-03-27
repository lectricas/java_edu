package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class NextYear {
    public static void main(String[] args) throws FileNotFoundException {
        NextYear n = new NextYear();
        n.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        int max = 98765431;
        long number = s.nextLong();
        if (number > max) {
            System.out.println(-1);
            return;
        }
        Set<Character> set = new HashSet();
        while (number < max) {
            number++;
            set.clear();
            char[] nString = String.valueOf(number).toCharArray();
            for (int i = 0; i < nString.length; i++) {
                if (nString[i] == '0' || nString[i] == '2') {
                    continue;
                }
                set.add(nString[i]);
            }
            if (set.size() == nString.length) {
                System.out.println(number);
                return;
            }
        }
        System.out.println(-1);
    }
}
