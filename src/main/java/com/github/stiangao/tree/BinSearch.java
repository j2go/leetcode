package main.java.com.github.stiangao.tree;

import java.util.Arrays;

public class BinSearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(findMax(array));
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int t = array[0];
            for (int j = 1; j < n; j++) {
                array[j - 1] = array[j];
            }
            array[n - 1] = t;
            System.out.println(Arrays.toString(array) + " --- " + findMax(array));
        }

    }

    private static int findMax(int[] array) {
        int l = 0, r = array.length - 1;
        int m = -1;
        while (l < r) {
            m = (l + r) / 2;
            if (l == m) {
                break;
            }
            if (array[l] < array[m]) {
                l = m;
            } else {
                r = m;
            }
        }
//        System.out.print("l:" + l + ",r:" + r + "  ");
        return array[l] < array[r] ? r : l;
    }
}
