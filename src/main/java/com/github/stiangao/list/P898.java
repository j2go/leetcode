package main.java.com.github.stiangao.list;

import java.util.*;

/**
 * 898. 子数组按位或操作
 * https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/
 */
public class P898 {

    public static void main(String[] args) {
        new P898().subarrayBitwiseORs2(new int[]{39, 19, 300, 56, 79, 50, 19, 70, 30, 129, 258});
    }

    public int subarrayBitwiseORs(int[] A) {

        int n = A.length;
        Set<Integer> set = new HashSet<>(n * 3);
        List<Integer> list = Collections.emptyList();
        for (int i = 0; i < n; i++) {
            List<Integer> newList = new ArrayList<>(list.size() + 1);
            int pre = A[i];
            set.add(pre);
            newList.add(pre);
            for (int x : list) {
                int tmp = pre | x;
                if (tmp > pre) {
                    newList.add(tmp);
                }
                pre = tmp;
                set.add(pre);
            }
            list = newList;
        }

        return set.size();
    }

    /**
     * 简单 dp 做法 (但是提交超时)
     *
     * 二维数组 B[i][j] 表示 A 从 i 到 j 的 或结果
     * 那么 B[i][j] = B[i][j-1] | B[i][j]
     *
     * i: 0 -> n-1
     *      B[i][i] = A[i]
     *      j: 0 -> i-1
     *          B[j][i] = B[j][i-1] | A[i]
     *
     * 统计所有不同的 B[j][i] 即可
     *
     * 因为所有只是用了上一次的结果，统计不同值的数量，所以可以直接优化为一维数组
     *
     * i: 0 -> n-1
     *      B[i] = A[i]
     *      j: 0 -> i-1
     *          B[j] = B[j] | A[i]  //这一次的结果等于上一次
     *          resultSet.add(B[j])
     */
    public int subarrayBitwiseORs2(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int n = A.length;
        int[] B = new int[n];
        B[0] = A[0];
        Set<Integer> set = new HashSet<>(n * 3);
        set.add(A[0]);
        for (int i = 1; i < n; i++) {
            B[i] = A[i];
            set.add(B[i]);
            for (int j = 0; j < i; j++) {
                B[j] = B[j] | A[i];
                set.add(B[j]);
            }
        }
        return set.size();
    }

}
