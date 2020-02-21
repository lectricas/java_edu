package com.lectricas.contest5048;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InterestingJourney {

    private static final int UNREACHEABLE = -1;

    int[] dist;
    Queue<Integer> queue = new LinkedList<Integer>();

    List<City> cities = new ArrayList<>();
    double fuel = 0;
    int cityTo = 0;

    public static void main(String[] args) throws FileNotFoundException {
        long before = System.currentTimeMillis();
        new InterestingJourney().run();
        System.out.println();
        System.out.println(System.currentTimeMillis() - before + " ms");
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        int count = s.nextInt();

        for (int i = 0; i < count; i++) {
            cities.add(new City(i, s.nextInt(), s.nextInt()));
        }
        fuel = s.nextDouble();
        int cityFrom = s.nextInt();
        cityTo = s.nextInt();

        GraphOnList graphOnList = new GraphOnList(count);

        for (int i = 0; i < cities.size(); i++) {
            for (int j = 0; j < cities.size(); j++) {
                if (i != j && getDistance(cities.get(i), cities.get(j)) <= fuel) {
                    graphOnList.addEdge(i+1, j+1);
                }
            }
        }

        dist = new int[graphOnList.getV()];
        int dist = findShortestPath(cityFrom, graphOnList);
        System.out.print(dist);
    }

    private double getDistance(City city1, City city2) {
        return Math.abs(city1.x - city2.x) + Math.abs(city1.y - city2.y);
    }

    private int findShortestPath(int src, GraphOnList graph) {
        src = src - 1; //decrease scr to move to 0 to n-1
        Arrays.fill(dist, UNREACHEABLE);
        dist[src] = 0;
        queue.offer(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph.getAdjEdges(u)) {
                if (dist[v] == UNREACHEABLE) {
                    queue.offer(v);
                    dist[v] = dist[u] + 1;
                    if (v == cityTo - 1) {
                        return dist[v];
                    }
                }
            }
        }
        return -1;
    }

    static class City {
        double x;
        double y;
        int number;

        public City(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }

    static class GraphOnList {

        int V;
        LinkedList<Integer>[] list;

        public GraphOnList(int V) {
            this.V = V;
            list = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                list[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dst) {
            list[src - 1].add(dst - 1);
            list[dst - 1].add(src - 1);
        }

        public int getV() {
            return V;
        }

        public LinkedList<Integer> getAdjEdges(int edge){
            return list[edge];
        }
    }
}
