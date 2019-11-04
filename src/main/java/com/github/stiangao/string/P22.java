package com.github.stiangao.string;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class P22 {
    List<String> output = new ArrayList<>();
    int n;
    char[] chars;

    /**
     * 这个题用回溯有点杀鸡用牛刀，但是算是一个不错的练习
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        this.n = n;
        chars = new char[n * 2];
        backTrace(0, '(');
        return output;
    }

    void backTrace(int t, char c) {
        chars[t] = c;
        if (t == n * 2 - 1) {
            if (checkOK()) output.add(new String(chars));
            return;
        }
        if (canGo()) {
            backTrace(t + 1, '(');
            backTrace(t + 1, ')');
        }
    }

    boolean canGo() {
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') l++;
            else r++;
        }
        return l <= n && r <= n;
    }

    LinkedList<Character> queue = new LinkedList();

    boolean checkOK() {
        queue.clear();
        for (int i = 0; i < n * 2; i++) {
            if (chars[i] == '(') queue.push(chars[i]);
            else if (queue.isEmpty()) {
                return false;
            } else queue.pop();
        }
        return queue.isEmpty();
    }

    /**
     * 优化
     */
    static class Solution {
        List<String> output = new ArrayList<>();
        int size;
        char[] chars;

        public List<String> generateParenthesis(int n) {
            size = 2 * n;
            chars = new char[size];
            chars[size - 1] = ')';
            tryNext(0, '(', n - 1, n - 1);
            return output;
        }

        void tryNext(int i, char c, int l, int r) {
            chars[i] = c;
            if (i == size - 2) {
                if (checkOK()) output.add(new String(chars));
            }
            if (l > 0) {
                tryNext(i + 1, '(', l - 1, r);
            }
            if (r > 0) {
                tryNext(i + 1, ')', l, r - 1);
            }
        }

        boolean checkOK() {
            int k = 0;
            for (int i = 0; i < size; i++) {
                if (chars[i] == '(') {
                    k++;
                } else if (k == 0) {
                    return false;
                } else k--;
            }
            return k == 0;
        }
    }

    /**
     * 动态规划
     */
    static class Solution2 {

        public List<String> generateParenthesis(int n) {
            Set<String> set = new HashSet<>();
            set.add("()");
            for (int i = 1; i < n; i++) {
                Set<String> newSet = new HashSet<>();
                for (String s : set) {
                    newSet.add("()" + s);
                    newSet.add("(" + s + ")");
                    newSet.add(s + "()");
                }
                set = newSet;
            }
            return new ArrayList<>(set);
        }
    }
}
