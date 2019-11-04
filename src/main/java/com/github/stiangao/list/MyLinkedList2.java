package com.github.stiangao.list;

public class MyLinkedList2 {

    int size;
    MyNode head;

    class MyNode {
        int val;
        MyNode next;

        public MyNode(int val, MyNode n) {
            this.val = val;
            this.next = n;
        }
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        MyNode tmpNode = head;
        for (int i = 0; i < index; i++) {
            tmpNode = tmpNode.next;
        }
        return tmpNode.val;
    }

    public void addAtHead(int val) {
        MyNode newNode = new MyNode(val, head);
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        MyNode tmpNode = head;
        for (int i = 0; i < size - 1; i++) {
            tmpNode = tmpNode.next;
        }
        MyNode newNode = new MyNode(val, null);
        tmpNode.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        } else if (index > size) {
            return;
        }
        MyNode tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        MyNode newNode = new MyNode(val, tmp.next);
        tmp.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index > 0 && index < size) {
            MyNode tmpNode = head;
            for (int i = 0; i < index - 1; i++) {
                tmpNode = tmpNode.next;
            }
            MyNode deled = tmpNode.next;
            if (deled != null) {
                tmpNode.next = deled.next;
            }
            size--;
            return;
        }
        if (index == 0 && size > 0) {
            head = head.next;
        }
    }
}
