package com.lectricas.stepik_algs;

import java.io.File;
import java.util.*;

public class Hoffman {

    LinkedList<Node> rateMap = new LinkedList<>();
    StringBuilder answer = new StringBuilder();
    Map<Character, String> codes = new HashMap<>();
    int charSize = 0;

    public static void main(String[] args) {
        Hoffman h = new Hoffman();
        h.run();
    }

    private void run() {

        File text = new File("input.txt");

        Scanner scanner = null;
        scanner = new Scanner(System.in);

        char[] inputStr = scanner.nextLine().toCharArray();

        for (int i = 0; i < inputStr.length; i++) {
            char newChar = inputStr[i];
            boolean contains = false;
            for (Node node : rateMap) {
                if (node.value == newChar) {
                    node.priority++;
                    contains = true;
                }
            }
            if (!contains) {
                rateMap.push(new Node(null, null, newChar, 1));
            }
        }

        charSize = rateMap.size();

        int initialSize = rateMap.size();
        int j = 0;
        while(j < initialSize) {
            Node firstMin = extractMin();
            Node secondMin = extractMin();
            Node center;

            if (secondMin == null) {
                if (firstMin.value == null) {
                    center = firstMin;
                } else {
                    center = new Node(firstMin, null, null, firstMin.priority);
                }
                rateMap.push(center);
                break;
            }
            if (firstMin.value == null) {
                center = new Node(secondMin, firstMin, null, firstMin.priority + secondMin.priority);
            } else  {
                center = new Node(firstMin, secondMin, null, firstMin.priority + secondMin.priority);
            }

            rateMap.push(center);
            j++;
        }


        for (int i = 0; i < inputStr.length; i++) {
            char newChar = inputStr[i];
            findCode(rateMap.get(0), newChar, "");
        }

        System.out.println(charSize + " " + answer.length());
        for (Character character : codes.keySet()) {
            System.out.println(character + ": " + codes.get(character));
        }

        System.out.println(answer);

    }

    private void findCode(Node node, Character ch, String code) {
        if (node == null) {
            return;
        }
        if (node.value != null) {
            if (node.value == ch) {
                codes.put(ch, code);
                answer.append(code);
            }
        }
        findCode(node.left, ch, code + "0");
        findCode(node.right, ch, code + "1");

    }

    private Node extractMin() {
        int priority = Integer.MAX_VALUE;
        Node min = null;

        Iterator<Node> iterator = rateMap.iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
            if (next.priority < priority) {
                priority = next.priority;
                min = next;
            }

        }
        rateMap.remove(min);
        return min;
    }

    static class Node {
        Node left;
        Node right;
        Character value;
        int priority;

        public Node(Node left, Node right, Character value, int priority) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.priority = priority;
        }
    }
}
