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

    @Test
    public void pushDominoes2() {
        P838 p = new P838();
        Assert.assertEquals("LL.RR.LLRRLL..", p.pushDominoes2(".L.R...LR..L.."));
        Assert.assertEquals("RR.L", p.pushDominoes2("RR.L"));
        Assert.assertEquals("RL", p.pushDominoes2("RL"));
        Assert.assertEquals("L.....RRRRLLLLLLL.RR", p.pushDominoes2("L.....RR.RL.....L.R."));
        Assert.assertEquals("...RL....R.LLL........RRRRRLLLL....R.L.....R.L..RL....RRRRRRRRRRRRRRRRRRRRRRRR.LLLLLLLLLLLLRRRRLL.RR", p.pushDominoes2("...RL....R.L.L........RR......L....R.L.....R.L..RL....R....R......R.......................LR.R..L.R."));
    }
}
