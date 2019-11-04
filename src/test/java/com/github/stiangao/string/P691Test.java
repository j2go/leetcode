package com.github.stiangao.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class P691Test {

    @Test
    public void minStickers() {
        P691 p = new P691();
        System.out.println(p.minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }
}