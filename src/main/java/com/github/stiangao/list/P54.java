package main.java.com.github.stiangao.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class P54 {
    public static void main(String[] args) {
        int[][] matrix = {{2, 5}, {8, 4}, {0, -1}};
        System.out.println(new P54().spiralOrder2(matrix));
    }

    /**
     * 普通解法，按方向遍历, 已通过，超过 99 的时间
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        int m = matrix.length, n = matrix[0].length;
        int size = m * n;
        List<Integer> list = new ArrayList<>(size);
        int x = 0, y = 0, xf = 0, jf = 1;
        for (int i = 0, j = 0; list.size() < size; i += xf, j += jf) {
            list.add(matrix[i][j]);
            if (xf == 0 && jf == 1 && j == n - 1) {
                y++;
                xf = 1;
                jf = 0;
            }
            if (xf == 1 && jf == 0 && i == m - 1) {
                n--;
                xf = 0;
                jf = -1;
            }
            if (xf == 0 && jf == -1 && j == x) {
                x++;
                xf = -1;
                jf = 0;
            }
            if (xf == -1 && jf == 0 && i == y) {
                m--;
                xf = 0;
                jf = 1;
            }
        }
        return list;
    }

    enum Direction {
        right(0, 1), down(1, 0), left(0, -1), up(-1, 0);

        Direction(int x, int y) {
            xf = x;
            yf = y;
        }
        int xf;
        int yf;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        int m = matrix.length, n = matrix[0].length;
        int size = m * n;
        List<Integer> list = new ArrayList<>(size);
        int x = 0, y = 0;
        Direction d = Direction.right;
        for (int i = 0, j = 0; list.size() < size; i += d.xf, j += d.yf) {
            list.add(matrix[i][j]);
            if (d == Direction.right && j == n - 1) {
                y++;
                d = Direction.down;
            } else if (d == Direction.down && i == m - 1) {
                n--;
                d = Direction.left;
            } else if (d == Direction.left && j == x) {
                x++;
                d = Direction.up;

            } else if (d == Direction.up && i == y) {
                m--;
                d = Direction.right;
            }
        }
        return list;
    }
}
