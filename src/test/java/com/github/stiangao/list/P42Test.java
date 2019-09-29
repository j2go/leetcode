package com.github.stiangao.list;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P42Test {

    @Test
    public void trap() {
        P42 p = new P42();
        p.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(Integer.MIN_VALUE);
        Queue<Integer> queue = new LinkedList<>();
    }
}
