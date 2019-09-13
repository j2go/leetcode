package com.github.stiangao.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class P56 {
    /**
     * 按第一数字排序，然后顺序遍历，当前最大的第二个数如果比下一个的第一个数大就继续比下去，然后就能得到一个区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.parallelSort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] arr = new int[intervals.length][2];
        int arrIndex = 0;
        for (int i = 0; i < intervals.length; i++) {
            arr[arrIndex][0] = intervals[i][0];
            int end = intervals[i][1];
            while(i+1 < intervals.length && end >= intervals[i+1][0]) {
                i++;
                end = end < intervals[i][1] ? intervals[i][1] : end;
            }
            arr[arrIndex][1] = end;
            arrIndex++;
        }
        int[][] result = new int[arrIndex][2];
        for (int i = 0; i < arrIndex; i++) {
            result[0]=arr[0];
        }
        return result;
    }
}
