package com.github.stiangao.list;

import java.util.Arrays;
import java.util.List;

public class P315 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] repeat = new int[n];
        Integer[] ans = new Integer[n];
        for (int i = n - 1; i >= 0; --i) {
            repeat[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    ans[i] = ans[j] + repeat[j];
                    break;
                } else if (nums[i] == nums[j]) {
                    repeat[i] = repeat[j] + 1;
                    ans[i] = ans[j];
                    break;
                }
            }
            if (ans[i] == null) {
                ans[i] = 0;
            }
        }
        return Arrays.asList(ans);
    }

    public static void main(String[] args) {
        System.out.println(new P315().countSmaller(new int[]{5, 4, 2, 4, 1, 6, 1}));
    }
}
