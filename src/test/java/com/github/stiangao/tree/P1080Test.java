package com.github.stiangao.tree;

import org.junit.Test;

public class P1080Test {

    @Test
    public void sufficientSubset() {
        P1080 p = new P1080();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(3);
        p.sufficientSubset(root, 22);
    }

    @Test
    public void sufficientSubset2() {
        P1080 p = new P1080();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(-5);

        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(4);
        p.sufficientSubset(root, -1);
    }
}
