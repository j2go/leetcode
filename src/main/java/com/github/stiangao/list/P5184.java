package com.github.stiangao.list;

import java.util.Arrays;

public class P5184 {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {4, 3, 1};
        System.out.println(new P5184().makeArrayIncreasing(arr1, arr2));
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int index2 = 0;
        int k = 0;
        for (int i = 0; i < arr1.length - 1; i++) {
            if (arr1[i] >= arr1[i + 1]) {
                if(index2 >= arr2.length) return -1;
                if (i - 1 >= 0) {
                    while (index2 < arr2.length && arr1[i-1] >= arr2[index2++]);
                }
                if(index2 >= arr2.length) return -1;

                if (arr2[index2] >= arr1[i]) {
                    return -1;
                }
                arr1[i] = arr2[index2++];
                k++;
                if (arr1[i] > arr1[i + 1]) {

                }
            }
        }
        return k;
    }
}

