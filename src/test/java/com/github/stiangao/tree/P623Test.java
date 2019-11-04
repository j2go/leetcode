package com.github.stiangao.tree;

import org.junit.Test;

public class P623Test {

    @Test
    public void addOneRow() {
        P623 p = new P623();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(2);
        p.addOneRow(root, 2, 4);
    }
}
