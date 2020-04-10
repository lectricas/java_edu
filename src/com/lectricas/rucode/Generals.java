package com.lectricas.rucode;

import java.util.Scanner;

public class Generals {
    public static void main(String[] args) {
        Generals g = new Generals();
        g.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        char[] line = s.next().toCharArray();

        int left = 0;
        int right = n - 1;

        while (right > left + 1) {
            while (line[left] != 'w') {
                left++;
            }

            while (line[right] != 'w') {
                right--;
            }
        }
    }
}
