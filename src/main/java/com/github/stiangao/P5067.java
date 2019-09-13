package com.github.stiangao;

import java.util.Arrays;

public class P5067 {

    public static void main(String[] args) {
        int res = new P5067().countLetters("aaaaaaaaaa");
        System.out.println(res);
    }

    public int countLetters(String S) {
        char[] chars = S.toCharArray();
        int[] chCount = new int[26];
        chCount[chars[0] - 'a'] = 1;
        int dup = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                dup++;
                chCount[chars[0] - 'a'] += dup;
            } else {
                chCount[chars[0] - 'a'] += 1;
                dup = 1;
            }
        }
        int count = 0;
        for (int i : chCount) {
            count += i;
        }
        return count;
    }
}
