package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Condition {
    public static void main(String[] args) throws FileNotFoundException {
        long before = System.currentTimeMillis();
        Condition c = new Condition();
        c.run();
        System.out.println(System.currentTimeMillis() - before + " ms");
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input2.txt"));
        int n = s.nextInt();
        int[] aud = new int[n];
        for (int i = 0; i < aud.length; i++) {
            aud[i] = s.nextInt();
        }
        List<Cond> conds = new ArrayList<>();
        int r = s.nextInt();
        for (int i = 0; i < r; i++) {
            Cond c = new Cond(s.nextInt(), s.nextInt());
            conds.add(c);
        }

        conds.sort(new Comparator<Cond>() {
            @Override
            public int compare(Cond o1, Cond o2) {
                return Integer.compare(o1.price, o2.price);
            }
        });

        int total = 0;
        for (int i = 0; i < aud.length; i++) {
            int j = 0;
            while (true) {
                if (conds.get(j).power >= aud[i]) {
                    break;
                }
                j++;
            }
            total += conds.get(j).price;
        }
        System.out.println(total);
    }

    private int binary(int k, List<Cond> arr) {
        int left = -1;
        int right = arr.size();
        while (right > left + 1) {
            int middle = (left + right) / 2;
            if (k > arr.get(middle).power) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return arr.get(right).price;
    }

    class Cond {
        int power;
        int price;

        public Cond(int power, int price) {
            this.power = power;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Cond{" +
                    "power=" + power +
                    ", price=" + price +
                    '}';
        }
    }
}
