package com.lectricas.contest14723;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DotsOnMap {

    Node root;

    List<Dot> list = new ArrayList<>();

    double total = 0;
    int max = 0;

    public static void main(String[] args) throws FileNotFoundException {
        DotsOnMap bst = new DotsOnMap();
        bst.run();
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

        for (int k = 0; k < numberOfRequests; k++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int size = scanner.nextInt();
            max = maxItems;
            total = 0;
            isInSquare(x, x + size, y, y - size);
            System.out.println(String.format("%.2f", total));
        }
    }

    class Node {
        Node left;
        Node right;
        double x;
        double y;
        boolean isHorizontal;
        double weight;

        public Node(Node left, Node right, double x, double y, boolean isHorizontal, double weight) {
            this.left = left;
            this.right = right;
            this.x = x;
            this.y = y;
            this.isHorizontal = isHorizontal;
            this.weight = weight;
        }
    }

    public void put(double x, double y, double weight) {
        root = putNode(root, x, y, false, weight);
    }

    public void isInSquare(int left, int right, int top, int bottom) {
        checkSquare(root, left, right, top, bottom);
    }

    private void checkSquare(Node node, int left, int right, int top, int bottom) {
        if (node == null || max == 0) {
            return;
        }
        if (!node.isHorizontal) {
            if (node.x >= left && node.x <= right && node.y >= bottom && node.y <= top) {
                total += node.weight;
                max--;
            }
            if (node.x >= left && node.x <= right) {
                if (node.left != null && node.right != null) {
                    if (node.right.weight > node.left.weight) {
                        checkSquare(node.right, left, right, top, bottom);
                        checkSquare(node.left, left, right, top, bottom);
                    } else {
                        checkSquare(node.left, left, right, top, bottom);
                        checkSquare(node.right, left, right, top, bottom);
                    }
                } else {
                    checkSquare(node.left, left, right, top, bottom);
                    checkSquare(node.right, left, right, top, bottom);
                }

            } else if (left > node.x) {
                checkSquare(node.right, left, right, top, bottom);
            } else {
                checkSquare(node.left, left, right, top, bottom);
            }
        } else {
            if (node.y >= bottom && node.y <= top && node.x >= left && node.x <= right) {
                total += node.weight;
                max--;
            }
            if (node.y >= bottom && node.y <= top) {
                if (node.left != null && node.right != null) {
                    if (node.right.weight > node.left.weight) {
                        checkSquare(node.right, left, right, top, bottom);
                        checkSquare(node.left, left, right, top, bottom);
                    } else {
                        checkSquare(node.left, left, right, top, bottom);
                        checkSquare(node.right, left, right, top, bottom);
                    }
                } else {
                    checkSquare(node.left, left, right, top, bottom);
                    checkSquare(node.right, left, right, top, bottom);
                }
            } else if (bottom > node.y) {
                checkSquare(node.right, left, right, top, bottom);
            } else {
                checkSquare(node.left, left, right, top, bottom);
            }
        }
    }

    private Node putNode(Node node, double x, double y, boolean isHorizontal, double weight) {
        if (node == null) {
            return new Node(null, null, x, y, isHorizontal, weight);
        }

        if (isHorizontal) {
            int result = Double.compare(y, node.y);
            if (result < 0) {
                node.left = putNode(node.left, x, y, false, weight);
            } else {
                node.right = putNode(node.right, x, y, false, weight);
            }
        } else {
            int result = Double.compare(x, node.x);
            if (result < 0) {
                node.left = putNode(node.left, x, y, true, weight);
            } else {
                node.right = putNode(node.right, x, y, true, weight);
            }
        }
        return node;
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
