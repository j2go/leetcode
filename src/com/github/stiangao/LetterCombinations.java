package com.github.stiangao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinations {

    /**
     * 题目解释： 数字上对应字符串编码，输入数字，输出所有数字对应字母的排列组合结果
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations2("237"));
    }

    /**
     * 先进先出队列解法，每轮结果依次拼上后一个 chars 的遍历再加入数组
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            char[] chars = mapping[(digits.charAt(i) - '0')].toCharArray();
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                for (char ch : chars) {
                    ans.add(ans.getFirst() + ch);
                }
                ans.removeFirst();
            }
        }
        return ans;
    }

    /**
     * 朴素解法，计算每个字母在哪个位置，通过划分和取余计算得到结果
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String[] numStrings = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] numChars = digits.toCharArray();
        int length = numChars.length;
        if (length == 0) {
            return new ArrayList<>(0);
        }
        int[] lengthArray = new int[length];
        int[] numArray = new int[length];
        int size = 1;
        for (int i = 0; i < length; i++) {
            numArray[i] = numChars[i] - '1';
            lengthArray[i] = numStrings[numArray[i]].length();
            size *= lengthArray[i];
        }
        int[] remainders = new int[length];
        remainders[0] = size / lengthArray[0];
        for (int i = 1; i < length; i++) {
            remainders[i] = remainders[i - 1] / lengthArray[i];
        }
        List<String> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder();
            int temp = i;
            for (int j = 0; j < length; j++) {
                String str = numStrings[numArray[j]];
                int index = temp / remainders[j];
                temp = temp % remainders[j];
                builder.append(str.charAt(index));
            }
            result.add(builder.toString());
        }
        return result;
    }
}
