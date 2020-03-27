package com.lectricas.stuructures;

public class GraphOnMatrix {
    int V;
    int[][] matrix;

    public GraphOnMatrix(int V) {
        this.V = V;
        matrix = new int[V][V];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    public void addEdge(int src, int dst) {
        matrix[src - 1][dst - 1] = Integer.MAX_VALUE;
        matrix[dst - 1][src - 1] = Integer.MAX_VALUE;
    }

    public int getV() {
        return V;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int[] getAdjacent(int src) {
        return matrix[src];
    }
}

