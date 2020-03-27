package com.lectricas.contest10825;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TestingTime {

    PriorityQueue<Integer> taskPriorities = new PriorityQueue(Comparator.reverseOrder());

    TotalTime[] deviceTotalTime;

    public static void main(String[] args) throws FileNotFoundException {
        TestingTime time = new TestingTime();
        time.run();
     }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
        int N = s.nextInt();
        int K = s.nextInt();
        deviceTotalTime = new TotalTime[K];

        for (int i = 0; i < N; i++) {
            taskPriorities.add(s.nextInt());
        }

        while (!taskPriorities.isEmpty()) {
            int i = 0;
            while (i < deviceTotalTime.length) {
                if (!taskPriorities.isEmpty()) {
                    if (deviceTotalTime[i] == null) {
                        TotalTime time = new TotalTime();
                        time.addTaskTime(taskPriorities.poll());
                        deviceTotalTime[i] = time;
                    } else {
                        deviceTotalTime[i].addTaskTime(taskPriorities.poll());
                    }

                }
                i++;
            }
        }

        long total = 0;
        for (TotalTime totalTime : deviceTotalTime) {
            total += totalTime.totalTime;
        }
        System.out.println(total);
    }

//    3
//    2
//    6
//    2
//    5

    class TotalTime {
        int countTested = 0;
        long totalTime = 0;

        void addTaskTime(int time) {
            totalTime += (2 * countTested + 1) * time;
            countTested++;
        }
    }
}
