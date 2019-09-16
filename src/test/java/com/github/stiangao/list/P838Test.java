package com.github.stiangao.list;

import org.junit.Assert;
import org.junit.Test;

public class P838Test {


    @Test
    public void pushDominoes() {
        P838 p = new P838();
        Assert.assertEquals("LL.RR.LLRRLL..", p.pushDominoes(".L.R...LR..L.."));
        Assert.assertEquals("RR.L", p.pushDominoes("RR.L"));
        Assert.assertEquals("RL", p.pushDominoes("RL"));
    }
}
