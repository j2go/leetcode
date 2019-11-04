package com.github.stiangao.list;

public class MedFinder {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int al = 0, ar = nums1.length - 1;
        int bl = 0, br = nums2.length - 1;
        while (al < ar && bl < br) {
            if (nums1[al] < nums2[bl]) al++;
            else bl++;

            if (nums1[ar] > nums2[br]) ar--;
            else br--;
        }
        if (al == ar) return mid(nums2, bl, br, nums1[al]);
        if (bl == br) return mid(nums1, al, ar, nums2[bl]);
        if (al > ar) return mid(nums2, bl, br);
        return mid(nums1, al, ar);
    }

    double mid(int[] arr, int i, int j) {
        while (i + 1 <= j - 1) {
            i++;
            j--;
        }
        return i == j ? arr[i] : (arr[i] + arr[j]) / 2.0;
    }

    double mid(int[] arr, int i, int j, int x) {
        if (i == j) return (arr[i] + x) / 2.0;
        if (i == j - 1) {
            if (x < arr[i]) return arr[i];
            if (x > arr[j]) return arr[j];
            return x;
        }
        if (x < arr[i]) return mid(arr, i, j - 1);
        if (x > arr[j]) return mid(arr, i + 1, j);
        return mid(arr, i + 1, j - 1, x);
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3};
        System.out.println(new MedFinder().findMedianSortedArrays(a, b));
    }

    static int getKth(int[] A, int la, int ra, int[] B, int lb, int rb, int k) {
        int len1 = ra - la + 1;
        int len2 = rb - lb + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(B, lb, rb, A, la, ra, k);
        if (len1 == 0) return B[lb + k - 1];

        if (k == 1) return Math.min(A[la], B[lb]);

        int ak = la + Math.min(len1, k / 2) - 1;
        int bk = lb + Math.min(len2, k / 2) - 1;

        return A[ak] > B[bk] ? getKth(A, la, ra, B, bk + 1, rb, k - (bk - lb + 1))
                : getKth(A, ak + 1, ra, B, lb, rb, k - (ak - la + 1));

    }
}
