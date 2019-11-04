package com.github.stiangao.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/stickers-to-spell-word/
 */
public class P691 {

    /**
     * 这个解法不对，题意理解错了，stickers 数组里的数字也是有关系的
     *
     * @param stickers
     * @param target
     * @return
     */
    public int minStickers(String[] stickers, String target) {
        Map<Character, Set<Integer>> map = new HashMap<>(26);
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), new HashSet<>());
        }
        int n = stickers.length;
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                map.get(c).add(i);
            }
        }
        int[] weight = new int[n];
        Set[] sets = new Set[26];
        for (char c : target.toCharArray()) {
            Set<Integer> set = map.get(c);
            if (set.isEmpty()) {
                return -1;
            }
            int k = c - 'a';
            if (sets[k] == null) {
                sets[k] = set;
                set.forEach(i -> weight[i] += 1);
            }
        }
        Set<Integer> resultSet = new HashSet<>();
        for (Set set : sets) {
            if (set != null) {
                List<Integer> list = (List<Integer>) set.stream().sorted(Comparator.comparingInt(i -> weight[(int) i]).reversed()).collect(Collectors.toList());

                resultSet.add(list.get(0));
            }
        }
        return resultSet.size();
    }
}
