package com.github.stiangao.list;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/push-dominoes/
 * . 推多米诺
 */
public class P838 {

    /**
     * 29ms
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        Queue<Integer> lq = new ArrayDeque<>();
        Queue<Integer> rq = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                if (i > 0 && chars[i - 1] == '.') {
                    lq.add(i);
                }
            }
            if (chars[i] == 'R') {
                if (i + 1 < chars.length && chars[i + 1] == '.') {
                    rq.add(i);
                }
            }
        }
        // 分别维护两个左右前进的队列，每次遍历前进一格，还有可前进的继续加入队列
        do {
            int ln = lq.size();
            for (int i = 0; i < ln; i++) {
                int l = lq.poll();
                if (l < 1) {
                    continue;
                }
                if (chars[l - 1] == '.') {
                    chars[l - 1] = 'L';
                    if (l > 1 && chars[l - 2] == '.') {
                        lq.add(l - 1);
                    }
                }
            }
            int rn = rq.size();
            for (int i = 0; i < rn; i++) {
                int r = rq.poll();
                if (r >= (chars.length - 1)) {
                    continue;
                }
                if (chars[r + 1] == '.') {
                    chars[r + 1] = 'R';
                    if (r + 2 < chars.length && chars[r + 2] == '.') {
                        rq.add(r + 1);
                    }
                }
                if (chars[r + 1] == 'L') {
                    chars[r + 1] = '.';
                }
            }
        } while (!lq.isEmpty() || !rq.isEmpty());
        return new String(chars);
    }

    /**
     * 高效解法 12ms 92%
     *
     * @param dominoes
     * @return
     */
    public String pushDominoes2(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int n = chars.length;
        int[] flag = new int[n];
        for (int i = 0; i < n; i++) {
            switch (chars[i]) {
                case 'L':
                    flag[i] = -1;
                    for (int j = i - 1; j >= 0 && (flag[j] == 0 || flag[j] > 1); j--) {
                        if (flag[j] == (0 - flag[j + 1])) {
                            break;
                        }
                        if (flag[j] == (1 - flag[j + 1])) {
                            flag[j] = 0;
                            break;
                        }
                        flag[j] = flag[j + 1] - 1;
                    }
                    break;
                case '.':
                    flag[i] = 0;
                    break;
                case 'R':
                    flag[i] = 1;
                    while (i + 1 < n && chars[i + 1] == '.') {
                        flag[i + 1] = flag[i] + 1;
                        i++;
                    }
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (flag[i] < 0) {
                chars[i] = 'L';
            } else if (flag[i] == 0) {
                chars[i] = '.';
            } else {
                chars[i] = 'R';
            }
        }
        return new String(chars);
    }

}
