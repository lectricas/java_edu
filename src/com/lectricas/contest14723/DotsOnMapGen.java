package com.lectricas.contest14723;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DotsOnMapGen {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("input.txt"));

        Random r = new Random();

        int N = 10000;
        writer.write(N + " ");
        writer.println();
        for (int i = 0; i < N; i++) {
            writer.write(r.nextInt(5000) + " " + r.nextInt(5000) + " " + ThreadLocalRandom.current().nextDouble(0.1, 1));
            writer.println();
        }

        writer.write(N + " " + (r.nextInt(9) + 1));
        writer.println();

        for (int i = 0; i < N; i++) {
            writer.write(r.nextInt(5000) + " " + r.nextInt(5000) + " " + r.nextInt(5000));
            writer.println();
        }
        writer.flush();
        writer.close();
    }
}
