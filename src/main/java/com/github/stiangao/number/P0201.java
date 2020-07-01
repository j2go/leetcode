package com.github.stiangao.number;

import com.github.stiangao.list.ListNode;

public class P0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        byte[] bitMap = new byte[2501];
        ListNode prev = null;
        int i, y;
        for (ListNode p = head; p != null; p = p.next) {
            i = p.val >> 3;
            y = 1 << (p.val & 7);
            if ((bitMap[i] & y) > 0) {
                prev.next = p.next;
            } else {
                bitMap[i] |= y;
                prev = p;
            }
        }
        return head;
    }

    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode prev;
        for(ListNode slow = head; slow != null; slow = slow.next) {
            prev = slow;
            for(ListNode fast = slow.next; fast != null; fast = fast.next) {
                if(fast.val == slow.val) {
                    prev.next = fast.next;
                } else {
                    prev = fast;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 1, 1, 1, 2);
        new P0201().removeDuplicateNodes2(head);
        System.out.println(head);
    }
}
