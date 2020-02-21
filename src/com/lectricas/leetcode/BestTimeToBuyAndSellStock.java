package com.lectricas.leetcode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
        s.maxProfit(new int[]{1, 4, 2});
    }

    public void maxProfit(int[] prices) {
        int[] array = new int[]{7, 1, 5, 3, 6, 4};

        int maxProfit = Integer.MIN_VALUE;
        int i = 0;
        while (i < array.length - 1) { // buy stock
            int j = i + 1;
            while (j < array.length) { // sell stock
                int profit = array[j] - array[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
                j++;
            }
            i++;
        }

        if (maxProfit > 0) {
            System.out.println(maxProfit);
        } else {
            System.out.println(0);
        }
    }
}
