package com.github.stiangao.string;

public class BigNumAdd2 {

    public static void main(String[] args) {
        BigNumAdd2 numAdd2 = new BigNumAdd2();
        System.out.println(numAdd2.add("19274123801265218309127458210.12731237", "12132983928744124.55555555552731237"));
        System.out.println(numAdd2.add("19274123801265218309127458210.92731237", "12132983928744124.55555555552731237"));
    }

    //以小数据为中心构造长度相等的 char[] 数组后再计算，一次 for 循环中搞定
    public String add(String a, String b) {
        int iA = a.indexOf("."), iB = b.indexOf(".");
        int lenA = a.length(), lenB = b.length();
        int l = Math.max(iA, iB), r = Math.max(lenA - iA, lenB - iB);
        int len = l + r;
        char[] num1 = new char[len], num2 = new char[len];
        for (int i = 1; i <= l; i++) {
            num1[l - i] = iA >= i ? a.charAt(iA - i) : '0';
            num2[l - i] = iB >= i ? b.charAt(iB - i) : '0';
        }
        num1[l] = '.';
        num2[l] = '.';
        for (int i = 1; i < r; i++) {
            num1[l + i] = iA + i < lenA ? a.charAt(iA + i) : '0';
            num2[l + i] = iB + i < lenB ? b.charAt(iB + i) : '0';
        }
        return add(num1, num2);
    }

    // len(num1) == len(num2)
    private String add(char[] num1, char[] num2) {
        StringBuilder ans = new StringBuilder();
        int h = 0;
        for (int i = num1.length - 1; i >= 0; i--) {
            if (num1[i] != '.') {
                h = appendNum(ans, (num1[i] - '0') + (num2[i] - '0') + h);
            } else {
                ans.append(".");
            }
        }
        if (h != 0) {
            ans.append(h);
        }
        return ans.reverse().toString();
    }

    private int appendNum(StringBuilder ans, int tmp) {
        if (tmp > 9) {
            ans.append(tmp - 10);
            return 1;
        }
        ans.append(tmp);
        return 0;
    }
}
