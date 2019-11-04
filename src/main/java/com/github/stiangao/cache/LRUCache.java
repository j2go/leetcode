package com.github.stiangao.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class LRUCache {

    private int cap;
    static AtomicInteger CLOCK = new AtomicInteger();
    Map<Integer, CacheItem> map = new HashMap<>();
    PriorityQueue<CacheItem> queue = new PriorityQueue<>();

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (cap < 1) {
            return -1;
        }
        CacheItem item = map.get(key);
        if (item == null) {
            return -1;
        }
        int value = item.val();
        queue.remove(item);
        queue.add(item);
        return value;
    }

    public void put(int key, int value) {
        if (cap < 1) {
            return;
        }
        CacheItem item = map.get(key);
        if (item != null) {
            queue.remove(item);
            item.val(value);
            queue.add(item);
        } else {
            item = new CacheItem(key, value);
            if (map.size() == cap) {
                CacheItem poll = queue.poll();
                map.remove(poll.k);
            }
            map.put(key, item);
            queue.add(item);
        }
    }

    class CacheItem implements Comparable<CacheItem> {
        final int k;
        private int v;
        private int time;

        CacheItem(int k, int v) {
            this.k = k;
            this.v = v;
            time = CLOCK.incrementAndGet();
        }

        @Override
        public int compareTo(CacheItem o) {
            return this.time - o.time;
        }

        public int val() {
            time = CLOCK.incrementAndGet();
            return v;
        }

        public void val(int v) {
            time = CLOCK.incrementAndGet();
            this.v = v;
        }
    }
}