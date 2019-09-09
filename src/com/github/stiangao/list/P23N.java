package com.github.stiangao.list;

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
        if (lists == null || lists.length < 1) return null;
        ListNode head = new ListNode(0);
        for (int i = 0; i < lists.length; i++) {
            head.next = merge(head.next, lists[i]);
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
