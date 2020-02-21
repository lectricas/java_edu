package com.lectricas.stepik_algs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

//Найдите эйлеров цикл в графе.
//
//Формат входных данных:
//В первой строке указаны два числа разделенных пробелом: vv (число вершин) и ee (число ребер). В следующих ee строках указаны пары вершин, соединенных ребром. Выполняются ограничения: 2\leq v \leq1000,0\leq e\leq10002≤v≤1000,0≤e≤1000 .
//
//Формат выходных данных:
//Одно слово: NONE, если в графе нет эйлерова цикла, или список вершин в порядке обхода эйлерова цикла, если он есть.

//Sample Input 1:
//
//4 2
//1 2
//3 2
//Sample Output 1:
//
//NONE
//Sample Input 2:
//
//3 3
//1 2
//2 3
//3 1
//Sample Output 2:
//
//1 2 3

public class FindEulerCycle {

    int[][] matrix;
    int V;

    LinkedList<Integer> answers;
    Map<Integer, Boolean> unique;

    int start;

    FindEulerCycle(int V, int E) {
        this.V = V;
        matrix = new int[V][V];
        answers = new LinkedList<>();
        unique = new HashMap<>();
    }

    void addEdge(int v, int w) {
        matrix[v][w]++;
        matrix[w][v]++;
    }

    private void findEuler(int v) {
        if (!checkSums()) {
            return;
        }

        start = v;
        find(v);
        if (isLeft()) {
            return;
        }
        if (unique.size() != V) {
            System.out.println("NONE");
            return;
        }

        answers.pollLast();
        for (Integer answer : answers) {
            System.out.print(answer + 1 + " ");
        }
    }

    private boolean checkSums() {
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                count += matrix[i][j];
            }
            if (count % 2 != 0) {
                System.out.println("NONE");
                return false;
            }
        }
        return true;
    }

    private boolean isLeft() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    System.out.println("NONE");
                    return true;
                }
            }
        }
        return false;
    }

    private void find(int v) {
        for (int i = 0; i < matrix[v].length; i++) {
            if (matrix[v][i] > 0) {
                matrix[v][i]--;
                matrix[i][v]--;
                find(i);
            }
        }
        answers.add(v);
        unique.put(v, true);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input_euler.txt"));
        int v = scanner.nextInt();
        int e = scanner.nextInt();

        if (e == 0) {
            System.out.println("NONE");
            return;
        }

        FindEulerCycle g = new FindEulerCycle(v, e);
        while (e > 0) {
            int v1 = scanner.nextInt() - 1;
            int v2 = scanner.nextInt() - 1;

            g.addEdge(v1, v2);
            e--;
        }

        g.findEuler(0);
    }
}
