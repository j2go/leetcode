package com.github.stiangao.list;

public class Kth {
    public int findKthLargest(int[] nums, int k) {

        return quickKth(nums, 0, nums.length - 1, k - 1);
    }

    int quickKth(int[] nums, int start, int end, int k) {
        int index = partition(nums, start, end);
        while (index != k) {
            if (index < k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

    int partition(int[] nums, int l, int r) {
        int x = nums[l];
        while (l < r) {
            while (nums[r] < x) r--;
            if (l < r) {
                nums[l] = nums[r];
            } else {
                nums[l] = x;
                return l;
            }
            while (l <= r && nums[l] >= x) l++;
            if (l < r) {
                nums[r] = nums[l];
            } else {
                nums[r] = x;
                return r;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new Kth().findKthLargest(nums, 2));
    }
}
