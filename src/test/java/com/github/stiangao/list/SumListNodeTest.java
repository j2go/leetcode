package com.github.stiangao.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumListNodeTest {

    final SumListNode sumListNode = new SumListNode();

    @Test
    public void reverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode list = sumListNode.reverse(head);
        assertEquals(5, list.val);
        assertEquals(4, list.next.val);
        assertEquals(3, list.next.next.val);
        assertEquals(2, list.next.next.next.val);
        assertEquals(1, list.next.next.next.next.val);
        assertNull(list.next.next.next.next.next);
    }

    @Test
    public void sum() {
    }
}