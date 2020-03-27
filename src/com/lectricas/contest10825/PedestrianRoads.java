package com.lectricas.contest10825;

import com.lectricas.stuructures.GraphOnMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PedestrianRoads {

    int[] dist;
    Queue<Integer> queue = new LinkedList<Integer>();

    private static final int UNREACHEABLE = -1;

    public static void main(String[] args) throws FileNotFoundException {
        PedestrianRoads p = new PedestrianRoads();
        p.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        GraphOnMatrix g = new GraphOnMatrix(s.nextInt());
        dist = new int[g.getV()];
        int edges = s.nextInt();
        for (int i = 0; i < edges; i++) {
            g.addEdge(s.nextInt(), s.nextInt());
        }

        int from = s.nextInt();

    }
}
