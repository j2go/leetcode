package com.github.stiangao.number;

import java.util.stream.IntStream;

/**
 * 375. 猜数字大小 II
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
 */
public class P375 {
    public int getMoneyAmount(int n) {
        if (n > 283) {
            return n - 63 + Math.max(5 * n - 57, getMoneyAmount(n - 64));
        }
        if (n > 123) {
            return n - 31 + Math.max(4 * n - 26, getMoneyAmount(n - 32));
        }
        //72 8*9
        if (n > 51) { //123  19*3-6
            return n - 15 + Math.max(3 * n - 11, getMoneyAmount(n - 16));
        }
        // 43 44 45 46 47 48 49 50
        if (n > 19) {
            return n - 7 + Math.max(2 * n - 4, getMoneyAmount(n - 8));
        }
        //8 8*1
        if (n > 11) {
            return n - 3 + Math.max(n - 1, getMoneyAmount(n - 4));
        }
        if (n < 4) {
            return n - 1;
        }
        return 2 * n - 4;
    }

    /**
     *  dp[i][j] 表示 i 到 j 的最大代价
     *  i 从 n 到 1
     *      dp[i][i+1] = i
     *      j 从 i+2 到 n ( i 是起始点 j 是终点)
     *         k 从 j-1 到 i+1 ( k 从大到小开始迭代 -2 )
     *         dp[i][j] = min(${lastVal}, k + max(dp[k+1][j], dp[i][k-1]))
     * @param n
     * @return
     */
    public int dpGetMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (j - i == 1) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = j - 1; k > i; k -= 2) {
                        dp[i][j] = Math.min(k + Math.max(dp[k + 1][j], dp[i][k - 1]), dp[i][j]);
                    }
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        P375 p375 = new P375();
        p375.dpGetMoneyAmount(30);
//        for (int i = 0; i < 200; i++) {
//            System.out.println(i + ": " + p375.getMoneyAmount(i));
//        }
    }
}
