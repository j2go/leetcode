package com.github.stiangao;

import java.lang.reflect.Array;
import java.util.*;

public class P5068 {

    public static void main(String[] args) {
        String[] arr = new String[]{"mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"};
        String[] arr2 = new String[]{"writing code", "code rocks"};
        for (String s : new P5068().beforeAndAfterPuzzles(arr2)) {
            System.out.println(s);
        }
    }
    public String[] beforeAndAfterPuzzles(String[] phrases) {

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
            String begin = phrases[i].substring(0, phrases[i].indexOf(" "));
            List<Integer> indexs = map.get(begin);
            if (indexs != null) {
                indexs.add(i);
            } else {
                indexs = new ArrayList<>();
                indexs.add(i);
                map.put(begin, indexs);
            }
        }
        Set<String> sortStr = new TreeSet<>();
        for (int i = 0; i < phrases.length; i++) {
            String end = phrases[i].substring(phrases[i].lastIndexOf(" ") + 1);
            List<Integer> indexes = map.get(end);
            if (indexes != null) {
                for (int index : indexes) {
                    sortStr.add(phrases[i] + phrases[index].substring(end.length()));
                }
            }
        }
        return sortStr.toArray(new String[0]);
    }

}
