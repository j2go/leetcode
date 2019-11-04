package com.github.stiangao.tree;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 623. 在二叉树中增加一行
 * https://leetcode-cn.com/problems/add-one-row-to-tree/
 */
public class P623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        for(int i = 1; i < d; i++) {
            int n = list.size();
            for(int j = 0; j < n; j++) {
                TreeNode poll = list.poll();
                if(i == d - 1) {
                    TreeNode newLeft = new TreeNode(v);
                    newLeft.left = poll.left;
                    poll.left = newLeft;
                    TreeNode newRight = new TreeNode(v);
                    newRight.right = poll.right;
                    poll.right = newRight;
                } else {
                    if(poll.left != null) list.add(poll.left);
                    if(poll.right != null) list.add(poll.right);
                }
            }
        }
        return root;
    }
}
