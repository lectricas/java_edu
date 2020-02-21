package com.lectricas.stuructures;

import java.util.LinkedList;

public class GraphOnList {

    int V;
    LinkedList<Integer> list[];

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
