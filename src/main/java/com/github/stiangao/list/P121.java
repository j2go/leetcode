package com.github.stiangao.list;

public class P121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int i = 0, j = 1;
        int max = 0;
        while (j < n) {
            if (prices[i] > prices[j]) {
                i = j;
            }
            j++;
            if (j < n) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P121 p = new P121();
        p.maxProfit(new int[]{4, 2, 1, 7});
    }
}
