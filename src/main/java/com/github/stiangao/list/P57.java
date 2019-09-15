package com.github.stiangao.list;

import java.util.Arrays;

public class P57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval[1] < intervals[0][0]) {
            return merge(new int[][]{newInterval}, intervals);
        }
        int n = intervals.length;
        if (newInterval[0] > intervals[n - 1][1]) {
            return merge(intervals, new int[][]{newInterval});
        }
        int start = binSearch(intervals, newInterval[0], 0);
        int end = binSearch(intervals, newInterval[1], 1);
        //
        if (intervals[start][1] < newInterval[1])
        for (int i = start; i < n; i++) {

        }
        return null;
    }

    int binSearch(int[][] d, int x, int i) {
        if (x < d[0][i]) {
            return -1;
        }
        int l = 0, r = d.length - 1;
        int m = (l + r) / 2;
        while (l < r - 1) {
            if (x >= d[m][i]) {
                l = m;
            } else {
                r = m;
            }
            m = (l + r) / 2;
        }
        return x > d[r][i] ? r : l;
    }

    int[][] merge(int[][] s1, int[][] s2) {
        int[][] res = new int[s1.length + s2.length][2];
        System.arraycopy(s1, 0, res, 0, s1.length);
        System.arraycopy(s2, 0, res, s1.length, s2.length);
        return res;
    }


    /**
     * 暴力解法，从前往后遍历
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int n = intervals.length;
        if (intervals[0][0] > newInterval[1]) {
            int[][] result = new int[n + 1][2];
            result[0] = newInterval;
            System.arraycopy(intervals, 0, result, 1, n);
            return result;
        }
        int i = 0;
        // 跳过区间尾值小于待插入区间开始的区间
        while (i < n && intervals[i][1] < newInterval[0]) i++;
        if (i == n) {
            int[][] result = new int[n + 1][2];
            System.arraycopy(intervals, 0, result, 0, n);
            result[n] = newInterval;
            return result;
        }
        if (intervals[i][0] > newInterval[1]) {
            //待插入区间是个独立区间
            int[][] result = new int[n + 1][2];
            System.arraycopy(intervals, 0, result, 0, i);
            result[i] = newInterval;
            System.arraycopy(intervals, i, result, i + 1, n - i);
            return result;
        }
        // 接下来一直找到待插入区间尾在哪个区间里
        intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
        int j = i;
        while (j < n && intervals[j][1] < newInterval[1]) j++;
        if (j == n) {
            //待插入区间尾巴比最大的区间还大
            intervals[i][1] = Math.max(intervals[j - 1][1], newInterval[1]);
            return Arrays.copyOf(intervals, i + 1);
        }
        if (intervals[j][0] <= newInterval[1]) {
            intervals[i][1] = intervals[j][1];
            j++;
        } else {
            intervals[i][1] = newInterval[1];
        }
        while (j < n) {
            i++;
            intervals[i] = intervals[j];
            j++;
        }
        return Arrays.copyOf(intervals, i + 1);
    }

}
