package com.github.stiangao.list;

/**
 * 哎哟，面试碰到这题，审题有误
 * <p>
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class P17 {
    public static void main(String[] args) {
        int[] h = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new P17().maxArea(h));
    }

    public int maxArea(int[] height) {
        if (height.length < 3) {
            return 2 * (height[0] < height[1] ? height[0] : height[1]);
        }
        int max = 0;
        for (int start = 0; start < height.length - 1; start++) {
            for (int end = 1; end < height.length; end++) {
                int v = (end - start + 1) * (height[start] < height[end] ? height[start] : height[end]);
                if (max < v) {
                    max = v;
                }
            }
        }
        return max;
    }

    /**
     * height 数组构成的阶梯型容器能容纳最多的水
     *
     * @param height
     * @return
     */
    public static int myMaxArea(int[] height) {
        int[] cap = new int[height.length];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < height.length; i++) {
            cap[i] = max - height[i];
        }
        int flag = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (flag < height[i]) {
                flag = height[i];
            }
            cap[i] -= (max - flag);
        }
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (flag < height[i]) {
                flag = height[i];
            }
            cap[i] -= (max - flag);
        }
        int count = 0;
        for (int n : cap) {
            count += n;
            System.out.print(n + " ");
        }
        return count;
    }
}
