package com.lectricas.stepik_algs;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Rucksack {

    List<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        Rucksack r = new Rucksack();
        r.run();
    }

    private void run() {
        File text = new File("input.txt");

        Scanner scanner = null;
        scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int free = scanner.nextInt();


        int lines = 0;
        while (lines < count) {
            int price = scanner.nextInt();
            int weight = scanner.nextInt();
            items.add(new Item(weight, price));
            lines++;
        }

        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.value, o1.value);
            }
        });

        double total = 0;
        for (Item item : items) {
            if (free - item.weight >= 0) {
                free = free - item.weight;
                total += item.price;
            } else {
                total += free * item.value;
                free = 0;
            }
        }

        System.out.println(total);
    }

    static class Item {
        int weight;
        int price;
        double value;

        public Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
            value = price / (double) weight;
        }
    }
}