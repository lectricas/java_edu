package com.lectricas;

import java.util.TreeMap;

public class Conditioners {

    public static void main(String[] args) {
        int[] rooms1 = {400};
        int[][] heaters1 = {{400, 1000}};
        int[] rooms2 = {2, 1, 3};
        int[][] heaters2 = {{1, 15}, {1, 7}, {2, 3}, {10, 7}};
//        System.out.println(getMinCost(rooms1, heaters1));
        System.out.println(getMinCost(rooms2, heaters2));
    }

    private static int getMinCost(int[] rooms, int[][] heaters) {
        TreeMap<Integer, Integer> tm = new TreeMap<>((a, b) -> b - a);
        int res = 0;
        for (int[] h : heaters) {
            tm.putIfAbsent(h[0], h[1]);
            if (h[1] < tm.get(h[0]))
                tm.put(h[0], h[1]);
        }
        int max = Integer.MAX_VALUE;
        for (int k : tm.keySet()) {
            max = Math.min(max, tm.get(k));
            tm.put(k, max);
        }
        for (int r : rooms) {
            if (tm.floorKey(r) == null)
                return -1;
            res += tm.floorEntry(r).getValue();
        }
        return res;
    }
}
