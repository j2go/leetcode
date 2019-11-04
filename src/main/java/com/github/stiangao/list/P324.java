package com.github.stiangao.list;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/wiggle-sort-ii/
 */
public class P324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 0;
        int m = n / 2;
        int[] low = new int[n - m], high = new int[m];

        System.arraycopy(nums, 0, low, 0, low.length);
        System.arraycopy(nums, low.length, high, 0, m);

        for (; i < m; i++) {
            nums[2 * i] = low[low.length - 1 - i];
            nums[2 * i + 1] = high[m - 1 - i];
        }
        if (n % 2 != 0) {
            nums[2 * i] = low[low.length - 1 - i];
        }
    }

}
