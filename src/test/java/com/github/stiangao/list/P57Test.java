package com.github.stiangao.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P57Test {

    @Test
    public void test1() {
        int[][] p = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] q = new int[]{4, 8};
        P57 instance = new P57();
        int[][] res = instance.insert(p, q);
        for (int[] r : res) {
            System.out.println(r[0]  + "  " + r[1]);
        }
    }

    @Test
    public void test2() {
        int[][] p = new int[][]{{3,5},{12,15}};
        int[] q = new int[]{6, 6};
        P57 instance = new P57();
        int[][] res = instance.insert(p, q);
        for (int[] r : res) {
            System.out.println(r[0]  + "  " + r[1]);
        }
    }

    @Test
    public void testBinSearch() {
        int[][] p = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        P57 p57 = new P57();
        Assert.assertEquals(-1, p57.binSearch(p, 0, 0));
        Assert.assertEquals(0, p57.binSearch(p, 2, 0));
        Assert.assertEquals(1, p57.binSearch(p, 3, 0));
        Assert.assertEquals(2, p57.binSearch(p, 7, 0));
        Assert.assertEquals(3, p57.binSearch(p, 9, 0));
        Assert.assertEquals(4, p57.binSearch(p, 13, 0));

    }
}
