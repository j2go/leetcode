package com.github.stiangao.list;

/**
 * https://leetcode-cn.com/problems/largest-sum-of-averages/
 * 最大平均值和的分组
 */
public class P813 {
    // dp[i][k] 表示 0..i 被分成 k 段的平均最大值
    // dp[i][k] = max()
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[n][K + 1];
        dp[0][1] = A[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = avg(A, 0, i);
            for (int k = 2; k <= i + 1 && k <= K; k++) {
                for (int j = i; j >= k - 1; j--) {
                    double b = dp[j - 1][k - 1] + avg(A, j, i);
                    dp[i][k] = Math.max(dp[i][k], b);
                }
            }
        }
        return dp[n - 1][K];
    }

    double avg(int[] s, int i, int j) {
        if (i == j) return (double) s[i];
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += s[k];
        }
        return sum * 1.0 / (j - i + 1);
    }
}
