package com.lectricas.stepik_algs;

import java.io.File;
import java.util.*;

class HoffmanDecode {

    int index = -1;

    LinkedList<Node> codes = new LinkedList<>();

    public static void main(String[] args) {
        HoffmanDecode h = new HoffmanDecode();
        h.run();
    }

    private void run() {
        File text = new File("input.txt");
        Scanner s = null;
        s = new Scanner(System.in);
        int codesCount = s.nextInt();
        int stringLength = s.nextInt();

        int i = 0;
        while (i < codesCount) {
            char ch = s.next().charAt(0);
            codes.add(new Node(null, null, ch, s.next().toCharArray()));
            i++;
        }
        char[] encodedString = s.next().toCharArray();

        Node head = new Node(null, null, null, null);
        for (Node code : codes) {
            insertNode(head, code, 0);
        }

        while (index < encodedString.length - 1) {
            findChar(head, encodedString);
        }
    }

    void findChar(Node head, char[] encodedStr) {
        if(head.value!= null) {
            System.out.print(head.value);
            return;
        } else {
            index++;
        }
        if(encodedStr[index] == '0') {
            findChar(head.left, encodedStr);
        } else {
            findChar(head.right, encodedStr);
        }
    }
    //1 01 1001011

    void insertNode(Node head, Node toInsert, int pointer) {
        char direction = toInsert.priority[pointer];
        boolean insertHere = pointer == toInsert.priority.length - 1;
        if (direction == '0') {
            if(insertHere) {
                head.left = toInsert;
                return;
            } else {
                if(head.left == null) {
                    head.left = new Node(null, null, null, null);
                }
                insertNode(head.left, toInsert, pointer+1);
            }
        } else {
            if(insertHere) {
                head.right = toInsert;
                return;
            } else {
                if(head.right == null) {
                    head.right = new Node(null, null, null, null);
                }
                insertNode(head.right, toInsert, pointer+1);
            }
        }
    }


    static class Node {
        Node left;
        Node right;
        Character value;
        char[] priority;

        public Node(Node left, Node right, Character value, char[] priority) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.priority = priority;
        }
    }
}
