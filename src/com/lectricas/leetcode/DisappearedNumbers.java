package com.lectricas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

*/
public class DisappearedNumbers {

    public static void main(String[] args) {
        new DisappearedNumbers().run();
    }

    private void run() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers(nums);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) { // the idea is to swap untill we got the item on right position
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while(i<nums.length)
        {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            if(nums[i]-1==i)
            {
                i++;
            }
            else if(nums[i]-1==nums[nums[i]-1]-1)
            {
                i++;
            }
            else{
                swap(nums,i,nums[i]-1);
            }
            System.out.println();

        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]-1!=i)
            {
                res.add(i+1);
            }
        }
        return res;
    }

    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //O(n) memory
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//
//        List<Integer> answer = new ArrayList<>();
//        int[] aux = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            aux[nums[i] - 1] = 1;
//        }
//
//        for (int i = 0; i < aux.length; i++) {
//            if (aux[i] == 0) {
//                answer.add(i + 1);
//            }
//        }
//
//        for (Integer integer : answer) {
//            System.out.print(integer + " ");
//        }
//        return answer;
//    }

}
