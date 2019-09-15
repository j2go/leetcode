package main.java.com.github.stiangao.string;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 破解保险箱
 * https://leetcode-cn.com/problems/cracking-the-safe/
 */
public class P753 {
    public static void main(String[] args) {
        System.out.println(new P753().crackSafe2(3, 3));
    }

    public String crackSafe(int n, int k) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, n).forEach(e -> builder.append('0'));
        Set<String> set = new HashSet<>();
        set.add(builder.toString());
        int ie = (int) Math.pow(k, n);
        for (int i = 0; i < ie; i++) {
            String sp = builder.substring(builder.length() - n + 1);
            for (int j = k - 1; j >= 0; j--) {
                String s = sp + j;
                if (!set.contains(s)) {
                    set.add(s);
                    builder.append(j);
                    break;
                }
            }
        }
        return builder.toString();
    }

    public String crackSafe2(int n, int k) {
        int m = (int) Math.pow(k, n - 1);
        int[] arr = new int[m * k];
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < m; ++j) {
                arr[i * m + j] = j * k + i;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m * k; ++i) {
            int j = i;
            while (arr[j] >= 0) {
                ans.append(j / m);
                int v = arr[j];
                arr[j] = -1;
                j = v;
            }
        }
        for (int i = 0; i < n - 1; ++i) {
            ans.append("0");
        }
        return ans.toString();
    }
}
