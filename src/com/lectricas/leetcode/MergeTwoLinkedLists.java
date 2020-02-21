package com.lectricas.leetcode;

public class MergeTwoLinkedLists {

    public static void main(String[] args) {
        MergeTwoLinkedLists m = new MergeTwoLinkedLists();
        m.run();
    }

    private void run() {

        Node head1 = new Node(
                new Node(
                        new Node(
                                new Node(null, 7),
                                5
                        ), 3),
                1);

        Node head2 = new Node(
                new Node(
                        new Node(
                                new Node(null, 8),
                                6
                        ), 4),
                2);
        Node current1 = head1;
        Node current2 = head2;
        Node answer = new Node(null, -1);
        Node currentAnswer = answer;

        while (current1 != null || current2 != null) {
            if (current1 == null) {
                currentAnswer.next = current2;
                break;
            } else if (current2 == null) {
                currentAnswer.next = current1;
                break;
            } else if(current1.val < current2.val) {
                currentAnswer.next = current1;
                currentAnswer = currentAnswer.next;
                current1 = current1.next;
            } else {
                currentAnswer.next = current2;
                currentAnswer = currentAnswer.next;
                current2 = current2.next;
            }
        }

        Node iter = answer.next;

        while (iter != null) {
            System.out.println(iter.val + " ");
            iter = iter.next;
        }



    }

    class Node {
        Node next;
        int val;

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }


}
