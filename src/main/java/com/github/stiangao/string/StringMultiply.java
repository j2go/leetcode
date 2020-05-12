package com.github.stiangao.string;

public class StringMultiply {

    /**
     * num1 num2 长度均不超过 110
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        int[] result = new int[220];
        int len2 = num2.length();
        for (int i = len2; i > 0; i--) {
            mul(result, num1, (num2.charAt(i - 1) - '0'), len2 - i);
        }
        StringBuilder builder = new StringBuilder();
        int k = 219;
        while (result[k] == 0) k--;
        while (k >= 0) builder.append(result[k--]);
        return builder.toString();
    }

    void mul(int[] result, String num1, int x, int offset) {
        int len1 = num1.length();
        for (int i = len1; i > 0; i--) {
            add(result, x * (num1.charAt(i - 1) - '0'), offset + (len1 - i));
        }
    }

    void add(int[] result, int n, int offset) {
        int cur = result[offset] + n;
        if (cur < 10) {
            result[offset] = cur;
            return;
        }
        result[offset] = cur % 10;
        add(result, cur / 10, offset + 1);
    }

    public static void main(String[] args) {
        StringMultiply stringMultiply = new StringMultiply();
        System.out.println(stringMultiply.multiply("2222", "3"));
        System.out.println(stringMultiply.multiply("4444", "3"));
        System.out.println(stringMultiply.multiply("34522", "1243124"));
    }
}
