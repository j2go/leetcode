package com.github.stiangao.list;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class P462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int res = 0;
        for (int i = 0; i < mid; i++) {
            res += nums[mid] - nums[i];
        }
        for (int i = nums.length - 1; i > mid; i--) {
            res += nums[i] - nums[mid];
        }
        return res;
    }
}
