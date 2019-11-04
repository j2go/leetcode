package com.github.stiangao.list;

public class SumListNode {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverse(sum(reverse(l1), reverse(l2), 0));
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }

    ListNode sum(ListNode l1, ListNode l2, int f) {
        if (l1 == null && l2 == null) {
            return f > 0 ? new ListNode(f) : null;
        }
        if (l1 == null) {
            l2.val += f;
            if(l2.val > 9) {
                l2.val -= 10;
                l2.next = sum(null, l2.next, 1);
            }
            return l2;
        }
        if (l2 == null) {
            l1.val += f;
            if(l1.val > 9) {
                l1.val -= 10;
                l1.next = sum(l1.next, null, 1);
            }
            return l1;
        }
        ListNode node = new ListNode(l1.val + l2.val + f);

        if (node.val > 9) {
            f = 1;
            node.val -= 10;
        } else {
            f = 0;
        }
        node.next = sum(l1.next, l2.next, f);
        return node;
    }
}
