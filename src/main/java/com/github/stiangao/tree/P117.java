package com.github.stiangao.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/
 */
public class P117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        root.next = null;
        Node node = findNext(root);
        if (node.left != null) {
            if (node.right != null)
                node.left.next = node.right;
            else
                node.next = findNext(node.next);
        }
        if (node != null) {
            connect(node);
        }
        return root;
    }

    Node findNext(Node node) {
        if (node == null) return null;
        if(node.left != null) return node.left;
        if(node.right != null) return node.right;
        return findNext(node.next);
    }



    /**
     * 广度优先队列解法
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 26.10% 的用户
     * 内存消耗 : 61.2 MB , 在所有 Java 提交中击败了 21.69% 的用户
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node preNode = null;
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (preNode != null) preNode.next = node;
                preNode = node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 这个其实还是用队列的套路，只是执行效率。。。。
     * <p>
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 97.29% 的用户
     * 内存消耗 : 60.6 MB , 在所有 Java 提交中击败了 27.71% 的用户
     *
     * @param root
     * @return
     */
    public Node connect3(Node root) {
        if (root == null) return null;
        root.next = null;
        link(root.left, root.right);
        return root;
    }

    void link(Node... nodes) {
        int n = nodes.length;
        Node[] next = new Node[n * 2];
        Node last = null;
        int i = 0;
        for (Node node : nodes) {
            if (node != null) {
                if (last != null) last.next = node;

                if (node.left != null) next[i++] = node.left;
                if (node.right != null) next[i++] = node.right;
                last = node;
            }
        }
        if (i > 0) {
            link(Arrays.copyOf(next, i));
        }
    }
}
