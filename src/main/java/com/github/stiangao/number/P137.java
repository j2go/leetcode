package com.github.stiangao.number;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 */
public class P137 {

    public int singleNumber(int[] nums) {
        int f1 = 0, f2 = 0;
        //f1  0,1 -> 1, 1,0 -> 1, 1,1 -> 0, 0,0 ->0
        //f2 是 f1 的进位， {n:f1} 1,1 -> 1, f2 是 1 表示有两个了
        for (int n : nums) {
            f1 |= f2 & n;
            f2 ^= f1 & n;
            f1 ^= n;
        }
        return f1;
    }

}
