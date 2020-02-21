package com.lectricas.coursera.princeton;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BstManipulations {

    public static void main(String[] args) {
        BstManipulations bstManipulations = new BstManipulations();
        bstManipulations.run();
    }

    private void run() {
        Bst bst = new Bst();

        int[] arr = new int[]{1, 7, 4, 9, 0, 3, 5, 2, 6, 8};

        for (int i = 0; i < arr.length; i++) {
            bst.put(arr[i], i + "");
        }

        for (Bst.Node node : bst.iterator()) {
            System.out.print(node.key + " " + node.value + ", ");
        }

        System.out.println();
        for (Bst.Node node : bst.iteratorBFS()) {
            System.out.print(node.key + " " + node.value + ", ");
        }
    }


    class Bst {

        private Node root;

        public Node put(Integer key, String value) {
            root = putValue(root, key, value);
            return root;
        }

        private Node putValue(Node x, Integer key, String value) {
            if (x == null) {
                return new Node(key, value, 1);
            }
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = putValue(x.left, key, value);
            } else if (cmp > 0) {
                x.right = putValue(x.right, key, value);
            } else {
                x.value = value;
            }
            x.count = 1 + size(x.left) + size(x.right);
            return x;
        }

        public int size() {
            return size(root);
        }

        public Queue<Node> iterator() {
            Queue<Node> queue = new LinkedList();
            inOrder(queue, root);
            return queue;
        }

        public Stack<Node> iteratorBFS() {
            Stack<Node> stack = new Stack<>();
            BFS(stack, root);
            return stack;
        }

        private void inOrder(Queue<Node> queue, Node root) {
            if (root != null) {
                queue.add(root);
                inOrder(queue, root.left);
                inOrder(queue, root.right);
            }
        }

        private void BFS(Stack<Node> stack, Node root) {
            if (root != null) {
                BFS(stack, root.left);
                stack.add(root);
                BFS(stack, root.right);
            }
        }

        private int size(Node node) {
            if (node == null) {
                return 0;

            }
            return node.count;
        }

        private class Node {
            Node left;
            Node right;
            String value;
            Integer key;
            int count;

            public Node(Integer key, String value, int count) {
                this.value = value;
                this.key = key;
                this.count = count;
            }
        }
    }

    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1]
            int r = i + (int) (Math.random() * (n - i));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }
}
