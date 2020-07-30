package com.github.stiangao.string;

public class BigNumAdd {
    public static void main(String[] args) {
        add("19274123801265218309127458210.12731237", "12132983928744124.55555555552731237");
        add("11123.12731237", "55555555552731237.12132983928744124");
        add("999955555555552731237.92731237", "999955555555552731237.92132983928744124");
    }

    public static void add(String a, String b) {
        int iA = a.indexOf(".");
        int iB = b.indexOf(".");
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        System.out.println(iA > iB ? add(num1, num2, iA, iB) : add(num2, num1, iB, iA));
    }

    private static String add(char[] num1, char[] num2, int i1, int i2) {
        int len1 = num1.length, len2 = num2.length;
        StringBuilder ans = new StringBuilder();
        int h = len1 - i1 > len2 - i2 ? addRight(num1, i1, num2, i2, ans) : addRight(num2, i2, num1, i1, ans);
        ans.append('.');
        int tmp;
        do {
            i1--;
            i2--;
            if (i2 < 0) {
                h = appendNum(ans, (num1[i1] - '0') + h);
            } else {
                tmp = (num1[i1] - '0') + (num2[i2] - '0') + h;
                h = appendNum(ans, tmp);
            }
        } while (i1 > 0);
        if (h > 0) ans.append(h);
        return ans.reverse().toString();
    }

    /**
     * @param num1
     * @param i1
     * @param num2
     * @param i2
     * @param ans
     * @return 返回进位
     */
    static int addRight(char[] num1, int i1, char[] num2, int i2, StringBuilder ans) {
        int size1 = num1.length - i1;
        int size2 = num2.length - i2;
        int h = 0, tmp;
        for (int i = size1 - 1; i > 0; i--) {
            if (size2 <= i) {
                ans.append(num1[i + i1]);
            } else {
                tmp = (num1[i + i1] - '0') + (num2[i + i2] - '0') + h;
                h = appendNum(ans, tmp);
            }
        }
        return h;
    }

    private static int appendNum(StringBuilder ans, int tmp) {
        if (tmp > 9) {
            ans.append(tmp - 10);
            return 1;
        }
        ans.append(tmp);
        return 0;
    }
}
