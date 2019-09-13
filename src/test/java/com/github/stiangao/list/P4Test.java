package com.github.stiangao.list;

import org.junit.Assert;
import org.junit.Test;

public class P4Test {

    @Test
    public void findMedianSortedArrays() {
        int[] a = {1, 3};
        int[] b = {2};
        P4 p4 = new P4();
        Assert.assertEquals(2.0, p4.findMedianSortedArrays(a, b));
    }

    @Test
    public void getKth() {
        int[] a = {1, 2, 3, 5, 7, 8};
        int[] b = {1, 4, 9, 11, 17, 18};
        P4 p4 = new P4();
        Assert.assertEquals(5, p4.getKth(a, 0, a.length - 1, b, 0, b.length - 1, 6));

        a = new int[]{7};
        Assert.assertEquals(7, p4.getKth(a, 0, a.length - 1, b, 0, b.length - 1, 3));
        Assert.assertEquals(9, p4.getKth(a, 0, a.length - 1, b, 0, b.length - 1, 4));

    }
}
