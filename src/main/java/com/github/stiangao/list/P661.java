package com.github.stiangao.list;

/**
 * https://leetcode-cn.com/problems/image-smoother/submissions/
 */
public class P661 {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length < 1 || M[0] == null || M[0].length < 1) {
            return null;
        }
        int row = M.length;
        int col = M[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0, count = 0;
                // 2*2 2*6 3*3 直接循环就好了
                int xi = i + 2 >= row ? row : i + 2;
                for (int x = (i > 0 ? i - 1 : 0); x < xi; x++) {
                    int yi = j + 2 >= col ? col : j + 2;
                    for (int y = (j > 0 ? j - 1 : 0); y < yi; y++) {
                        sum += M[x][y];
                        count++;
                    }
                }
                M[i][j] = sum / count;
            }
        }
        return M;
    }

    public static void main(String[] args) {
        int[][] m = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        new P661().imageSmoother(m);
    }
}
