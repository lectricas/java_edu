package com.lectricas.olymp;

import com.lectricas.contest5048.InterestingJourneyGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ConditionersGenerator {
    public static void main(String[] args) throws IOException {
        new ConditionersGenerator().run();
    }

    Random r = new Random();

    private void run() throws IOException {
        FileWriter fileWriter = new FileWriter("input2.txt");
        PrintWriter pw = new PrintWriter(fileWriter);
        int n = 50000;
        int m = 50000;
        pw.println(n);
        for (int i = 0; i < n; i++) {
            pw.print(r.nextInt(1000) + " ");
        }
        pw.println();
        pw.println(m);
        for (int i = 0; i < m; i++) {
            pw.println(r.nextInt(1000) + " " + r.nextInt(1000));
        }
        pw.close();
    }
}
