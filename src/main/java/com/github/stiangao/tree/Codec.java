package com.github.stiangao.tree;

public class Codec {

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
        int i = data.indexOf("(");
        if (i < 0) return new TreeNode(Integer.parseInt(data));
        TreeNode node = new TreeNode(Integer.parseInt(data.substring(0, i)));
        parseLeaf(node, data, i + 1, data.length() - 1);
        return node;
    }

    /**
     * data 形如 5(1,2)
     *
     * @param node 父节点
     * @param data
     * @param a '(' 的后一个字符的索引
     * @param b ')' 的索引
     */
    private void parseLeaf(TreeNode node, String data, int a, int b) {
        if (a >= b) return;
        if (data.charAt(a) == ',') {
            node.left = null;
            node.right = deserialize(data.substring(a + 1, b));
            return;
        }
        if (data.charAt(b - 1) == ',') {
            node.left = deserialize(data.substring(a, b - 1));
            node.right = null;
            return;
        }
        for (int i = a + 1; i < b; i++) {
            if (data.charAt(i) == ',') {
                node.left = new TreeNode(Integer.parseInt(data.substring(a, i)));
                node.right = deserialize(data.substring(i + 1, findEnd(data, i, b)));
                return;
            }
            if (data.charAt(i) == '(') {
                int end = findEnd(data, a, b);
                node.left = deserialize(data.substring(a, end));
                node.right = deserialize(data.substring(end + 1, b));
                return;
            }
        }
    }

    private int findEnd(String data, int start, int end) {
        int c = 0;
        for (int i = start; i < end; i++) {
            if (data.charAt(i) == '(') {
                c++;
            } else if (data.charAt(i) == ')') {
                c--;
                if (c == 0) return i + 1;
            }
        }
        return end;
    }
}
