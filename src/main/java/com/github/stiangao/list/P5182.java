package com.github.stiangao.list;

public class P5182 {
    public static void main(String[] args) {
        System.out.println(new P5182().maximumSum2(new int[]{2,1,-2,-5,-2}));
    }
    public int maximumSum(int[] arr) {
        int cur = arr[0], res = cur;
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            if (cur < 0)
                cur = 0;
            cur = cur + arr[i];
            if (cur > res)
                res = cur;
        }
        return res;
    }

    public int maximumSum2(int[] arr) {
        int max = maxSub(arr);
        int t;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i-1] >= 0 && arr[i] < 0 && arr[i + 1] >= 0) {
                t = arr[i];
                arr[i] = 0;
                int b = maxSub(arr);
                if (b > 0) {
                    max = Math.max(max, b);
                }
                arr[i] = t;
            }
        }
        return max;
    }

    int maxSub(int[] array) {
        int cur, res;
        cur = array[0];
        res = cur;
        for (int i = 1; i < array.length; i++) {
            if (cur < 0)
                cur = 0;
            cur = cur + array[i];
            if (cur > res)
                res = cur;
        }
        return res;
    }
}
