package com.github.stiangao.tree;

public class P1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null || dfs(root, limit)) return null;
        return root;
    }

    // needDel = sum < limit   --> limit - sum > 0
    private boolean dfs(TreeNode node, int lim) {
        lim -= node.val;
        if (node.left == null && node.right == null) return lim > 0;
        boolean delLeft = true;
        if (node.left != null) {
            delLeft = dfs(node.left, lim);
            if (delLeft) node.left = null;
        }
        boolean delRight = true;
        if (node.right != null) {
            if (delRight = dfs(node.right, lim)) node.right = null;
        }
        return delLeft && delRight;
    }
}

