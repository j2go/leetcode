package com.github.stiangao.list;

public class P334 {

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int x : nums) {
            if(x < min) {
                min = x;
            } else if(x < min2) {
                min2 = x;
            } else if(x > min2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P334().increasingTriplet(new int[]{2,1,5,0,3}));
    }
}
