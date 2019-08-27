package com.github.stiangao.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class P94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrderTraversal(root, list);
        return list;
    }

    void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.left, list);
            list.add(node.val);
            inOrderTraversal(node.right, list);
        }
    }
}
