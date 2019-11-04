package com.github.stiangao.matrix;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/01-matrix/
 */
public class P542 {
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * 执行用时 : 26 ms , 在所有 Java 提交中击败了 67.39% 的用户
     * 内存消耗 : 55.8 MB , 在所有 Java 提交中击败了 91.40% 的用户
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ans = new int[m][n];

        LinkedList<Integer> xq = new LinkedList<>();
        LinkedList<Integer> yq = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    xq.add(i);
                    yq.add(j);
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        int step = 1;
        while (!xq.isEmpty()) {
            int k = xq.size();
            for (int i = 0; i < k; i++) {
                int x = xq.removeFirst();
                int y = yq.removeFirst();
                for (int[] dxy : d) {
                    int nextx = x + dxy[0];
                    int nexty = y + dxy[1];
                    if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n && ans[nextx][nexty] < 0) {
                        ans[nextx][nexty] = step;
                        xq.add(nextx);
                        yq.add(nexty);
                    }
                }
            }
            step++;
        }
        return ans;
    }

    /**
     * 斜线扫描法
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix2(int[][] matrix) {
        return null;
    }

    public static void main(String[] args) {
        P542 p = new P542();
        int[][] m = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        p.updateMatrix(m);
    }
}
