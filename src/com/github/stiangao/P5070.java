package com.github.stiangao;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P5070 {
    public int[] shortestDistanceColor(int[] colors, int[][] queries) {
        int[] result = new int[queries.length];
        int n = colors.length;
        for (int i = 0; i < queries.length; i++) {
            result[i] = -1;
            int k = 0, index = queries[i][0], target = queries[i][1];
            while (index - k > 0 || index + k < n) {
                int l = index - k;
                if (l > 0 && colors[l] == target) {
                    result[i] = k;
                    break;
                }
                int r = index + k;
                if (r < n && colors[r] == target) {
                    result[i] = k;
                    break;
                }
                k++;
            }
        }
        return result;
    }

    private int search(int[] colors, int i, int target) {
        int k = 0;
        int n = colors.length;
        while (i - k > 0 || i + k < n) {
            int l = i - k;
            if (l > 0 && colors[l] == target) {
                return k;
            }
            int r = i + k;
            if (r < n && colors[r] == target) {
                return k;
            }
            k++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] c = new int[]{1,1,2,1,3,2,2,3,3};
        int [][] q = new int[][]{{1,9},{2,2},{6,1}};
        System.out.println(Arrays.toString(new P5070().shortestDistanceColor(c, q)));
    }
}
