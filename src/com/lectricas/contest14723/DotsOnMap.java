package com.lectricas.contest14723;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class DotsOnMap {

    Node root;

    List<Dot> list = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        DotsOnMap bst = new DotsOnMap();
        long before = System.currentTimeMillis();
        bst.run();
        System.out.println(System.currentTimeMillis() - before + " ms");
    }

    private void run() throws FileNotFoundException {
        File input = new File("input.txt");


        Scanner scanner = new Scanner(input);
        int numberOfCoordinates = scanner.nextInt();
        for (int i = 0; i < numberOfCoordinates; i++) {
            list.add(new Dot(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
        }
        list.sort((o1, o2) -> Double.compare(o2.weight, o1.weight));

        for (Dot dot : list) {
            put(dot.x, dot.y, dot.weight);
        }

        int numberOfRequests = scanner.nextInt();
        int maxItems = scanner.nextInt();

        for (int i = 0; i < numberOfRequests; i++) {
            List<Double> weights = new ArrayList<>();
            int left = scanner.nextInt();
            int top = scanner.nextInt();
            int size = scanner.nextInt();
            isInSquare(left, left + size, top, top - size, weights);
            weights.sort(Comparator.reverseOrder());
            int j = 0;
            double total = 0;
            while (j < maxItems && j < weights.size()) {
                total += weights.get(j);
                j++;
            }
//            System.out.println(total);

        }
    }

    public void isInSquare(int left, int right, int top, int bottom, List<Double> weights) {
        checkSquare(root, left, right, top, bottom, weights);
    }

    public void checkSquare(Node root, int left, int right, int top, int bottom, List<Double> weights) {
        if (root == null) {
            return;
        }
        if (root.x >= left && root.x <= right && root.y <= top && root.y >= bottom) {
            weights.add(root.weight);
        }
        if (root.isVertical) {
            if (root.x > right) {
                checkSquare(root.left, left, right, top, bottom, weights);
            } else if (root.x < left) {
                checkSquare(root.right, left, right, top, bottom, weights);
            } else {
                checkSquare(root.left, left, right, top, bottom, weights);
                checkSquare(root.right, left, right, top, bottom, weights);
            }
        } else {
            if (root.y > top) {
                checkSquare(root.left, left, right, top, bottom, weights);
            } else if (root.y < bottom) {
                checkSquare(root.right, left, right, top, bottom, weights);
            } else {
                checkSquare(root.left, left, right, top, bottom, weights);
                checkSquare(root.right, left, right, top, bottom, weights);
            }
        }
    }


    public void put(double x, double y, double weight) {
        root = putNode(root, x, y, false, weight);
    }


    private Node putNode(Node node, double x, double y, boolean isVertical, double weight) {
        if (node == null) {
            return new Node(x, y, !isVertical, weight);
        }

        if (node.isVertical) {
            int result = Double.compare(x, node.x);
            if (result < 0) {
                node.left = putNode(node.left, x, y, node.isVertical, weight);
            } else {
                node.right = putNode(node.right, x, y, node.isVertical, weight);
            }
        } else {
            int result = Double.compare(y, node.y);
            if (result < 0) {
                node.left = putNode(node.left, x, y, node.isVertical, weight);
            } else {
                node.right = putNode(node.right, x, y, node.isVertical, weight);
            }
        }
        return node;
    }

    class Node {
        Node left;
        Node right;
        double x;
        double y;
        boolean isVertical;
        double weight;

        public Node(double x, double y, boolean isVertical, double weight) {
            this.x = x;
            this.y = y;
            this.isVertical = isVertical;
            this.weight = weight;
        }
    }

    class Dot {
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
