package com.github.stiangao;

import java.util.*;

public class WiggleSort {

    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int mid = nums.length / 2 - 1;

        int b = mid;
        while (b > 0 && nums[b - 1] == nums[b]) {
            b--;
        }
        int c = mid + 1;
        while (c < nums.length && nums[c] == nums[c - 1]) {
            c++;
        }
        int i = -1, x = 0, y = b, z = c;
        while (true) {
            //  中大中大
            if (y < c) {
                arr[++i] = nums[y++];
            }
            if (i > nums.length - 2) {
                break;
            }
            if (z < nums.length) {
                arr[++i] = nums[z++];
            }
            if (i > nums.length - 2) {
                break;
            }
        }
        while (true) {
            // 小中小中
            if (y < c) {
                arr[++i] = nums[y++];
            }
            if (i > nums.length - 2) {
                break;
            }
            if (x < b) {
                arr[++i] = nums[x++];
            }
            if (i > nums.length - 1) {
                break;
            }
            if (z < nums.length) {
                arr[++i] = nums[z++];
            }
            if (i > nums.length - 2) {
                break;
            }
        }
        System.arraycopy(arr, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,1};
        new WiggleSort().wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
