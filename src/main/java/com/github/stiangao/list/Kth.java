package com.github.stiangao.list;

public class Kth {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if((n & 1) == 1) return findKth((n + 1)/2 , nums1, 0, nums2, 0);
        return (findKth(n/2 , nums1, 0, nums2, 0) + findKth(n/2+1, nums1, 0, nums2, 0)) / 2.0;
    }

    int findKth(int k, int[] a, int ai, int[] b, int bi) {
        if (ai == a.length) return b[bi + k - 1];
        if (bi == b.length) return a[ai + k - 1];
        if (k == 1) return a[ai] < b[bi] ? a[ai] : b[bi];
        int mk = (k - 1) / 2;
        int ak = Math.min(a.length - 1, ai + mk);
        int bk = Math.min(b.length - 1, bi + mk);
        if (a[ak] < b[bk]) return findKth(k - mk - 1, a, ak + 1, b, bi);
//        if (a[ak] == b[bk]) return findKth(k - (mk * 2), a, ak, b, bk);
        return findKth(k - mk - 1, a, ai, b, bk + 1);
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {-1,3};
//        System.out.println(new Kth().findMedianSortedArrays(a, b));
        System.out.println(new Kth().findKth(2,a, 0, b, 0));
        System.out.println(new Kth().findKth(3,a, 0, b, 0));
    }
}
