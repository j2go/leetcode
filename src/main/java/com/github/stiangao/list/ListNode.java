package com.github.stiangao.list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode build(int... ints) {
        ListNode head = new ListNode(ints[0]);
        ListNode p = head;
        for (int i = 1; i < ints.length; i++) {
            p.next = new ListNode(ints[i]);
            p = p.next;
        }
        return head;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + ", " + next.toString();
        }
        return val + "";
    }
}
