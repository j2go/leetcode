package com.github.stiangao.cache;

import java.util.HashMap;
import java.util.Map;

class LFUCache {

    class CacheNode {
        int key;
        int value;
        int count;

        CacheNode prev;
        CacheNode next;

        void remove(){
            prev.next = next;
            next.prev = prev;
        }

        void insert(CacheNode node) {
            node.prev = this;
            node.next = this.next;

            this.next.prev = node;
            this.next = node;
        }

        void moveAfter(CacheNode node) {
            remove();
            node.insert(this);
            count++;
        }

        @Override
        public String toString() {
            if (next == null) {
                return "#";
            }
            CacheNode p = next;
            StringBuilder builder = prev == null ? new StringBuilder("^ - ") : new StringBuilder();
            while (p.next != null) {
                builder.append(p.value).append(" - ");
                p = p.next;
            }
            builder.append(p.toString());
            return builder.toString();
        }
    }

    private Map<Integer, CacheNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private CacheNode head, tail;

    public LFUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new CacheNode();
        tail = new CacheNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        CacheNode node = map.get(key);
        if (node == null) return -1;

        node.moveAfter(head);

        return node.value;
    }

    public void put(int key, int value) {
        CacheNode node = map.get(key);

        if(node != null) {
            node.value = value;
            node.moveAfter(head);
            return;
        }
        CacheNode newNode = new CacheNode();
        newNode.key = key;
        newNode.value = value;

        if(size == capacity) {
            map.remove(tail.prev.key);
            tail.prev.remove();
            --size;
        }
        map.put(key, newNode);
        CacheNode p = tail.prev;
        while (p != head && p.count == 0) {
            p = p.prev;
        }
        p.insert(newNode);

        ++size;
    }

}

