package com.lectricas.rucode;

import java.util.Scanner;

class CheckString {
    public static void main(String[] args) {
        CheckString s = new CheckString();
        s.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        int initialLength = a.length() - 1;
        String reduced = a.replace(" ", "");
        int reducedLength = reduced.length() - 1;
        if (reducedLength * 3 > initialLength) {
            System.out.println("unsafe");
        } else {
            System.out.println("safe");
        }
    }
}
