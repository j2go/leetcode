package com.github.stiangao.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
 */
public class P448 {

    /**
     * 抽屉原理，基于交换
     * 8ms
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int t;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] != i + 1) {
                t = nums[nums[i] - 1];
                if (t == nums[i]) {
                    nums[i] = 0;
                } else {
                    nums[nums[i] - 1] = nums[i];
                    while (t != 0 && t != i + 1 && nums[t - 1] != t) {
                        nums[i] = nums[t - 1];
                        nums[t - 1] = t;
                        t = nums[i];
                    }
                    if (t == i + 1) continue;

                    if (t == 0 || nums[t - 1] == t) nums[i] = 0;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) list.add(i + 1);
        }
        return list;
    }

    /**
     * 简单方法
     * 38 ms
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int k = 1;
        for (int n : nums) {
            while (k < n) {
                list.add(k++);
            }
            k = n + 1;
        }
        while (k <= nums.length) {
            list.add(k++);
        }
        return list;
    }
}
