package com.github.stiangao.list;

import java.util.LinkedList;

public class P1004 {

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,0,0,0,1,1,1,1};
        System.out.println(new P1004().longestOnes(a, 0));
    }

    public int longestOnes(int[] A, int K) {
        int res = 0;
        for (int count = 0, l = 0, r = 0; r < A.length; ++r) {
            if (A[r] == 1) {
                ++count;
            }
            while (r - l + 1 - count > K) {
                if (A[l++] == 1) {
                    --count;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}
