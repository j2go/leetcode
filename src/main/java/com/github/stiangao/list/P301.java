package com.github.stiangao.list;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 */
public class P301 {

    public static void main(String[] args) {
        new P301().removeInvalidParentheses("(a)())()");
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();

        int st = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st++;
            } else if (ch == ')') {
                if (st == 0) {
                    list.add("");
                } else {
                    st--;
                }
            }
        }
        return Collections.singletonList(s);
    }

    private List<String> remove(String s, int i) {
        List<String> list = new ArrayList<>();
        return list;
    }
}
