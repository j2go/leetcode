package com.github.stiangao.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P44Test {

    @Test
    public void isMatch() {
        P44 p = new P44();
        assertEquals(true, p.isMatch("ho", "ho**"));
        assertEquals(true, p.isMatch("hoc", "ho**c"));
        assertEquals(true, p.isMatch("hobc", "ho**?c"));
        assertEquals(true, p.isMatch("hodbc", "ho**?c"));
        assertEquals(true, p.isMatch("", "**"));
        assertEquals(true, p.isMatch("c", "*?*"));
        assertEquals(false, p.isMatch("s", "*d*"));
        assertEquals(false, p.isMatch("aa", "a"));
        assertEquals(true, p.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        assertEquals(false, p.isMatch("mississippi", "m??*ss*?i*pi"));
        assertEquals(true, p.isMatch("hi", "*?"));
        assertEquals(true, p.isMatch("ab", "*?*?"));
        assertEquals(true, p.isMatch("aa", "*"));
    }
}