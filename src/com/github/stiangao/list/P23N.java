package com.github.stiangao.list;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
 */
public class P23N {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        Stream.of(lists).filter(Objects::nonNull).forEach(queue::add);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            ptr.next = node;
            ptr = ptr.next;
            node = node.next;
            if (node != null) queue.add(node);
        }
        return head.next;
    }

    ListNode merge(ListNode p, ListNode q) {
        if (p == null) return q;
        if (q == null) return p;
        if (p.val < q.val) {
            p.next = merge(p.next, q);
            return p;
        }
        q.next = merge(p, q.next);
        return q;
    }

}
