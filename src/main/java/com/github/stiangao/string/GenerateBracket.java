package com.github.stiangao.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateBracket {
    char[] ans;
    int len;
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        len = n * 2;
        ans = new char[len];

        backtrack(0, '(', n-1, n);
        return result;
    }

    void backtrack(int i, char ch, int l, int r) {
        if(i == len) {
            if(checkAns()) result.add(new String(ans));
            return;
        }
        ans[i] = ch;
        if(l > 0) {
            backtrack(i+1, '(', l-1, r);
        }
        if(r > 0) {
            backtrack(i+1, ')', l, r-1);
        }
    }

    boolean checkAns() {
        int cur = 0;
        for(int i = 0; i < len; i++) {
            if(ans[i] == '(')
                cur++;
            else if(cur < 1)
                return false;
            else
                cur--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateBracket().generateParenthesis(3));
    }
}
