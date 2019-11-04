package com.github.stiangao.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void get() {
        MyLinkedList list = new MyLinkedList();
        //["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        //[[],[1],[3],[1,2],[1],[1],[1]]
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        assertEquals(2, list.get(1));
        list.deleteAtIndex(1);
        assertEquals(3, list.get(1));
    }

    //["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
    //[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
    @Test
    public void test2() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtTail(2);
        list.addAtTail(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);

        assertEquals(4, list.get(4));
        list.addAtHead(4);
        list.addAtIndex(6,3);
        assertEquals(3, list.get(6));
        assertEquals(0, list.get(4));

        list.deleteAtIndex(0);
        assertEquals(-1, list.get(6));

        list.addAtHead(6);
        assertEquals(6, list.get(0));

    }


}