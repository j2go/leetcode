package com.github.stiangao.number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P137Test {

    @Test
    public void singleNumber() {
        P137 p = new P137();
        assertEquals(3, p.singleNumber(new int[]{2, 2, 3, 2}));
        assertEquals(3, p.singleNumber(new int[]{2, 2, 129, 3, 129, 2, 129}));
    }
}