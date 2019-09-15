package com.github.stiangao.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/description/
 */
public class Sum4 {

    /**
     * 题目解释： 给定数组和结果 S， 找到所有的 4 个数的和是 S
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {1, 0, -1, 0, -2, 2};
        System.out.println(new Sum4().fourSum(ints, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    /**
     * k 求和问题，从有序数组中找出 k 个数等于和 target
     *
     * @param nums   数组
     * @param target 目标和的值
     * @param k
     * @param index  从 index 到数组末尾这段数据中找
     * @return
     */
    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        int len = nums.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (index >= len) {
            return res;
        }
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                //find a pair
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target - nums[i]);
                    res.add(temp);
                    //skip duplication
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j - 1] == nums[j]) j--;
                    i++;
                    j--;
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    //move right bound
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if (temp != null) {
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }
}
