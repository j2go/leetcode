package com.github.stiangao.number;

/**
 * https://leetcode-cn.com/problems/add-digits/
 */
public class P258 {

    public int addDigits(int num) {
        int ans = 10;
        while(ans > 9) {
            ans = 0;
            while(num != 0) {
                ans += num % 10;
                num /= 10;
            }
            num = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        new P258().addDigits(38);
    }
}
