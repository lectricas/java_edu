package com.lectricas.leetcode;

import java.util.Stack;

//Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
//
//For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//
//Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

public class WarmTemperature {

    public static void main(String[] args) {
        WarmTemperature w = new WarmTemperature();
        w.run();
    }

    private void run() {
        int[] T = new int[]{89,62,70,58,47,47,46,76,100,70};
        int[] warm = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                warm[i] = stack.peek() - i;
                stack.push(i);
            }
        }

        for (int i = 0; i < warm.length; i++) {
            System.out.println(warm[i]);
        }
    }
}
