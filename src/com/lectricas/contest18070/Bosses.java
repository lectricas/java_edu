package com.lectricas.contest18070;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bosses {
    public static void main(String[] args) throws FileNotFoundException {
        Bosses b = new Bosses();
        b.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        int n = s.nextInt();
        int[] people = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < people.length; i++) {
            people[i] = s.nextInt();
        }

        for (int i = 0; i < people.length; i++) {
            toBottom(people, count, i);
        }

        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
    }

    private void toBottom(int[] people, int[] count, int n) {
        if (people[n] == 0) {
            return;
        } else if (count[n] != 0) {
            count[n] = count[people[n] - 1] + 1;
        }
        else {
            toBottom(people, count, people[n] - 1);
            count[n] = count[people[n] - 1] + 1;
        }
    }
}
