package com.lectricas.contest5048;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class InterestingJourneyGenerator {
    public static void main(String[] args) throws IOException {
        new InterestingJourneyGenerator().run();
    }

    Random r = new Random();

    private void run() throws IOException {
        FileWriter fileWriter = new FileWriter("input.txt");
        PrintWriter pw = new PrintWriter(fileWriter);
        int cities = 997;
        pw.println(cities + 2);
        pw.printf("%d %d%n", 0, 0);
        for (int i = 0; i < cities; i++) {
            pw.printf("%d %d%n", r.nextInt(500), r.nextInt(500));
        }
        pw.printf("%d %d%n", 1000, 1000);
//        pw.print(r.nextInt(1000000000) + 1000000000);
        pw.print(1500);
        pw.println();
        pw.printf("%d %d", 1, 999);
        pw.close();
    }
}
