package com.lectricas.rucode;

import java.util.Scanner;

class BadSet {
    public static void main(String[] args) {
        BadSet set = new BadSet();
        set.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int power = s.nextInt();
        System.out.println((long) Math.pow(2, power - 1));
    }
}
