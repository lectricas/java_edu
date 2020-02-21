package com.lectricas.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode {

    public static void main(String[] args) {
        int[] a = new int[]{2,2,1,1,1,2,2,1,1,2,2};
        System.out.println(majorityElement(a));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count + 1);
            }
        }

        int total = 0;
        Integer number = -1;
        for (Integer integer : map.keySet()) {
            Integer count = map.get(integer);
            if (count > total) {
                total = count;
                number = integer;
            }

        }

        return number;
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        while(j < nums.length && nums[j] != 0) {
            j++;
        }

        for(int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        while(j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public static String addBinary(String a, String b) {
        char[] lg;
        char[] st;
        if (a.length() > b.length()) {
            lg = a.toCharArray();
            st = b.toCharArray();
        } else {
            lg = b.toCharArray();
            st = a.toCharArray();
        }

        int i = st.length - 1;
        int rem = 0;
        int j = lg.length - st.length;

        StringBuilder s = new StringBuilder();
        while (i >= 0) {
            int sum = Character.getNumericValue(lg[i + j]) + Character.getNumericValue(st[i]) + rem;
            rem = 0;
            if (sum == 3) {
                s.insert(0, 1);
                rem = 1;
            } else if  (sum == 2) {
                s.insert(0, 0);
                rem = 1;
            } else {
                s.insert(0,sum);
            }
            i--;
        }
        j--;
        while (j >= 0) {
            int sum = Character.getNumericValue(lg[j]) + rem;
            rem = 0;
            if (sum == 2) {
                s.insert(0, 0);
                rem = 1;
            } else {
                s.insert(0, sum);
            }
            j--;
        }

        if (rem != 0) {
            s.insert(0, rem);
        }
        return s.toString();
    }


    public static int[] plusOne(int[] digits) {
        int rem = 1;
        int i = digits.length - 1;
        while (i >= 0) {
            int sum = (digits[i] + rem);
            digits[i] = sum % 10;
            rem = sum / 10;
            i--;
        }
        if (rem != 0) {
            int[] a = new int[digits.length + 1];
            a[0] = rem;
            System.arraycopy(digits, 0, a, 1, digits.length);
            return a;
        } else {
            return digits;
        }
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int total = 0;
        while (s.length() > 1) {
            String one = s.substring(0, 1);
            String two = s.substring(0, 2);
            if (map.containsKey(two)) {
                total += map.get(two);
                s = s.substring(2);
            } else {
                total += map.get(one);
                s = s.substring(1);
            }
        }
        if (s.length() > 0) {
            total += map.get(s);
        }
        return total;
    }
//
//    public static int removeDuplicates(int[] nums) {
//        if (nums.length < 2) {
//            return nums.length;
//        }
//
//        int i = 0;
//        int j = 1;
//        while (j < nums.length) {
//            if (nums[i] == nums[j]) {
//
//            } else {
//                i++;
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//            }
//            j++;
//        }
//        return i + 1;
//    }

//    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++)
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) return "";
//            }
//        return prefix;
//    }
}
