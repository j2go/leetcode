package com.github.stiangao.list;

public class LinkListSort {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode low = head, fast = head.next;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        ListNode mid = low.next;
        low.next = null;
        return merge(head, mid);
    }

    ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        a = sortList(a);
        b = sortList(b);
        if (a.val < b.val) {
            a.next = merge(a.next, b);
            return a;
        }
        b.next = merge(a, b.next);
        return b;
    }

    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode mid = head;
        ListNode pl = left, pr = right, pm = mid;

        int val = head.val;
        head = head.next;
        while (head != null) {
            if (head.val < val) {
                pl.next = head;
                pl = pl.next;
            } else if (head.val > val) {
                pr.next = head;
                pr = pr.next;
            } else {
                pm.next = head;
                pm = pm.next;
            }
            head = head.next;
        }
        pl.next = null;
        pr.next = null;

        pm.next = sortList(right.next);

        left = sortList(left.next);
        if(left == null) return mid;

        pl = left;
        while(pl.next != null) pl = pl.next;
        pl.next = mid;
        return left;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        new LinkListSort().sortList(head);
    }
}
