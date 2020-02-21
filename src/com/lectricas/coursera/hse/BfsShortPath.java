package com.lectricas.coursera.hse;

import com.lectricas.stuructures.GraphOnList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsShortPath {

    private static final int UNREACHEABLE = -1;

    int[] dist;
    Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws FileNotFoundException {
        new BfsShortPath().run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        int queriesCount = s.nextInt();
        for (int k = 0; k < queriesCount; k++) {
            GraphOnList g = new GraphOnList(s.nextInt());
            dist = new int[g.getV()];
            int E = s.nextInt();
            for (int i = 0; i < E; i++) {
                g.addEdge(s.nextInt(), s.nextInt());
            }
            findShortestPath(s.nextInt(), g);

            for (int i = 0; i < dist.length; i++) {
                int distance = dist[i];
                if (distance != 0) {
                    System.out.print(distance + " ");
                }
            }
            System.out.println();
        }
    }

    private void findShortestPath(int s, GraphOnList graph) {
        s = s - 1; //decrease scr to move to 0 to n-1
        Arrays.fill(dist, UNREACHEABLE);
        dist[s] = 0;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph.getAdjEdges(u)) {
                if (dist[v] == UNREACHEABLE) {
                    queue.offer(v);
                    dist[v] = dist[u] + 6;
                }
            }
        }
    }
}
