package com.github.stiangao.tree;

/**
 * Codec 的优化版
 */
public class Codec2 {
    //序列化为带括号的字符串 exp: 5(1,2(3,4))
    public String serialize(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";
        if (root.left == null) return String.format("%d(,%s)", root.val, serialize(root.right));
        if (root.right == null) return String.format("%d(%s,)", root.val, serialize(root.left));
        return String.format("%d(%s,%s)", root.val, serialize(root.left), serialize(root.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        char[] chars = data.toCharArray();
        return decode(chars, 0, chars.length);
    }

    private TreeNode decode(char[] chars, int start, int end) {
//        System.out.println(new String(chars).substring(start, end));
        int c = 0;
        boolean neg = false;
        if (start >= end) return null;
        for (int i = start; i < end; i++) {
            if (chars[i] == '(') {
                TreeNode node = new TreeNode(neg ? 0 - c : c);
                int mid = findNodeEnd(chars, i + 1, end);
                node.left = decode(chars, i + 1, mid);
                node.right = decode(chars, mid + 1, end - 1);
                return node;
            }
            if (chars[i] == '-') {
                neg = true;
            } else {
                c = c * 10 + (chars[i] - '0');
            }
        }
        return new TreeNode(neg ? 0 - c : c);
    }

    private int findNodeEnd(char[] chars, int i, int end) {
        int k = 0;
        while (i < end) {
            if (chars[i] == '(') {
                k++;
            } else if (chars[i] == ')') {
                k--;
                if (k == 0) return i + 1;
            } else if (chars[i] == ',' && k == 0) {
                return i;
            }
            i++;
        }
        return end;
    }


}
