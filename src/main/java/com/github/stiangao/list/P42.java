package com.github.stiangao.list;

public class P42 {
    public int trap(int[] height) {
        int maxi = 0;
        int n = height.length;
        int max = 0;
        for(int i=0;i<n;i++) {
            if(max < height[i]) {
                max = height[i];
                maxi = i;
            }
        }
        int[] cap = new int[n];
        int lim = 0;
        for(int i=0;i<maxi;i++) {
            if(lim < height[i]) {
                lim = height[i];
            }
            cap[i] = max - height[i] - (max - lim);
        }
        lim = 0;
        for(int i=n-1;i>maxi;i--) {
            if(lim < height[i]) {
                lim = height[i];
            }
            cap[i] = max - height[i] - (max - lim);
        }
        for(int i=1;i<maxi;i++) {
            cap[0] += cap[i];
        }

        return cap[0];
    }
}
