package com.github.stiangao;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class PalindromeNumber {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
