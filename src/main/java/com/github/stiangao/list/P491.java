package com.github.stiangao.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P491 {

    int[] d;
    int n;
    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        d = new int[n];
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <  n - l; i++)
                backTrack(0, nums, i, l);
        }
        return new ArrayList<>(ans);
    }

    void backTrack(int k, int[] nums, int i, int len) {
        d[k] = nums[i];
        if (k == len - 1) {
            if (check(len)) addAns(len);
            return;
        }
        for (int j = i + 1; j < n; j++) {
            backTrack(k + 1, nums, j, len);
        }
    }

    boolean check(int len) {
        for (int i = 0; i < len - 1; i++) {
            if (d[i] > d[i + 1]) return false;
        }
        return true;
    }

    void addAns(int len) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(d[i]);
        }
        ans.add(list);
    }

    public static void main(String[] args) {
        new P491().findSubsequences(new int[]{4, 6, 7, 7});
    }
}
