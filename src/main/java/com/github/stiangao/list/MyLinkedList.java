package com.github.stiangao.list;

public class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int v, ListNode n) {
            val = v;
            next = n;
        }
    }

    ListNode head = new ListNode(-1, null);
    ListNode tail = head;
    int size = 0;

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        return (index < 0 || index >= size) ? -1 : indexOf(index).val;
    }

    ListNode indexOf(int i) {
        ListNode p = head;
        while (i >= 0) {
            --i;
            p = p.next;
        }
        return p;
    }

    public void addAtHead(int val) {
        head.next = new ListNode(val, head.next);
        if (tail == head) {
            tail = head.next;
        }
        ++size;
    }

    public void addAtTail(int val) {
        tail.next = new ListNode(val, null);
        tail = tail.next;
        ++size;
    }

    public void addAtIndex(int index, int val) {
        //这个地方奇葩了，题目里都没说明
        if (index < 1) {
            addAtHead(val);
            return;
        }
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode pre = indexOf(index - 1);
        pre.next = new ListNode(val, pre.next);
        ++size;
    }


    public void deleteAtIndex(int index) {
        if (index < 0 || size < 1 || index >= size) return;

        ListNode preNode = indexOf(index - 1);

        if (preNode.next == tail) {
            tail = preNode;
        }
        preNode.next = preNode.next.next;
        --size;
    }
}
