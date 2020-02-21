package com.lectricas.stepik_algs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Heap {

    List<Integer> array = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Heap h = new Heap();
        h.run();
    }

    private void run() throws FileNotFoundException {
        File f = new File("input.txt");
        Scanner s = new Scanner(f);

        int count = s.nextInt();
        while (count != 0) {

            if (s.next().equals("Insert")) {
                addItem(s.nextInt());
            } else {
                extractMax();
            }
            count--;
        }
    }

    private void extractMax() {
        int item = array.get(0);
        int last = array.remove(array.size() - 1);
        if (array.size() > 0) {
            array.set(0 , last); // might be wrong max heap implaaaaaaaaaaaaaaa
            siftDown(0);
        }

        System.out.println(item);
    }

    private void addItem(int value) {
        array.add(value);
        siftUp(array.size() - 1);
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2; // suspect index is not 0 when only 1 element in the list
        if (array.get(index) > array.get(parentIndex)) {
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }

    private void siftDown(int parent) {
        int leftIndex = Math.min(array.size() - 1, 2 * parent + 1);
        int rightIndex = Math.min(array.size() - 1, 2 * parent + 2);

        if (array.get(leftIndex) > array.get(rightIndex)) {
            if (array.get(leftIndex) > array.get(parent)) {
                swap(leftIndex, parent);
                siftDown(leftIndex); // might be wrong argument
            } else {
                return;
            }
        } else {
            if (array.get(rightIndex) > array.get(parent)) {
                swap(rightIndex, parent);
                siftDown(rightIndex);
            } else {
                return;
            }
        }
    }

    private void swap(int left, int right) {
        int temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }
}