package com.lectricas.contest14723;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class DontOnMapBrute {

    public static void main(String[] args) {
        DontOnMapBrute brute = new DontOnMapBrute();
        long before = System.currentTimeMillis();
        brute.run();
        System.out.println(System.currentTimeMillis() - before + " ms");

    }

    private void run() {
        File input = new File("input.txt");

        List<Dot> dots = new ArrayList<Dot>();

        try (Scanner scanner = new Scanner(input)) {
            int numberOfCoordinates = scanner.nextInt();
            for (int i = 0; i < numberOfCoordinates; i++) {
                dots.add(new Dot(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
            }

            dots.sort(Comparator.comparingDouble(o -> o.weight));

            int numberOfRequests = scanner.nextInt();
            int maxItems = scanner.nextInt();
            for (int k = 0; k < numberOfRequests; k++) {
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double size = scanner.nextDouble();
                double total = 0;
                int i = dots.size() - 1;
                int currentMax = 0;

                while (currentMax < maxItems && i >=0 ) {
                    Dot dot = dots.get(i);
                    if (dot.x >= x && dot.x <= x + size && dot.y <= y && dot.y >= y - size ) {
                        total  += dots.get(i).weight;
                        currentMax++;
                    }
                    i--;
                }
//                System.out.println(total);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Dot {
        double x;
        double y;
        double weight;

        public Dot(double x, double y, double weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
