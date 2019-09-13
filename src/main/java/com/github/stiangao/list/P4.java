package com.github.stiangao.list;

public class P4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1) {
            return getKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 + 1);
        }
        int k = (m + n) / 2;
        return (getKth(nums2, 0, n-1, nums1, 0, m-1, k) + getKth(nums2, 0, n-1, nums1, 0, m-1, k + 1)) * 0.5;
    }

    int getKth(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int k) {
        int len1 = aEnd - aStart + 1;
        int len2 = bEnd - bStart + 1;

        if (len1 > len2) return getKth(b, bStart, bEnd, a, aStart, aEnd, k);
        if (len1 == 0) return b[bStart + k - 1];

        if (k == 1) return Math.min(a[aStart], b[bStart]);

        int i = aStart + Math.min(len1, k / 2) - 1;
        int j = bStart + Math.min(len2, k / 2) - 1;

        if (a[i] > b[j]) {
            return getKth(a, aStart, aEnd, b, j + 1, bEnd, k - (j - bStart + 1));
        }
        return getKth(a, i + 1, aEnd, b, bStart, bEnd, k - (i - aStart + 1));
    }

}
