package com.github.stiangao.string;

/**
 * https://leetcode-cn.com/problems/wildcard-matching/submissions/
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P44 {
    /**
     * 3ms beat 100%
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, star = -1;
        int k = 0; // 记录最后一次匹配的位置  + 1

        while (i < s.length()) {
            if (j < p.length()) {
                char chp = p.charAt(j);
                if (s.charAt(i) == chp || chp == '?') {
                    ++i;
                    ++j;
                    continue;
                }
                if (chp == '*') {
                    star = j++;
                    if (j == p.length()) return true;
                    k = i;
                    continue;
                }
            }
            if (star != -1) {
                i = ++k;
                j = star + 1;
                continue;
            }
            return false;
        }

        while (j < p.length() && p.charAt(j) == '*') ++j;

        return j == p.length();
    }
}
