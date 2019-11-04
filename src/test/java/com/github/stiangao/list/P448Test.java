package com.github.stiangao.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class P448Test {

    @Test
    public void findDisappearedNumbers() {
        P448 p = new P448();
        assertEquals(Collections.emptyList(), p.findDisappearedNumbers(new int[]{1}));
        assertEquals(Arrays.asList(2), p.findDisappearedNumbers(new int[]{1, 1}));
        assertEquals(Arrays.asList(1), p.findDisappearedNumbers(new int[]{3, 2, 2, 4}));
        assertEquals(Arrays.asList(1, 5, 6), p.findDisappearedNumbers(new int[]{3, 2, 2, 4, 4, 4}));
        assertEquals(Collections.emptyList(), p.findDisappearedNumbers(new int[]{2,3,4,5,6,7,8,1}));
    }
}