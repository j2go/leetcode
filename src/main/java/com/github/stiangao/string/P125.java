package com.github.stiangao.string;

public class P125 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n < 2) return true;
        int l = 0, r = n - 1, ol = 0, or = 0;
        while(l < r) {
            while(l < r && (ol = charOffset(s.charAt(l))) < 0) l++;
            while(l < r && (or = charOffset(s.charAt(r))) < 0) r--;
            if(l < r && ol != or) return false;
            l++;
            r--;
        }
        return true;
    }

    int charOffset(char c) {
        if(c >= 'a' && c <= 'z') return c - 'a';
        if(c >= 'A' && c <= 'Z') return c - 'A';
        return -1;
    }

//    public static void main(String[] args) {
//        System.out.println(( & (1<<31)));
//    }

}
