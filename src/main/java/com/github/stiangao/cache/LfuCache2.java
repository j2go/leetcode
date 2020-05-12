package com.github.stiangao.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 优先队列实现 LFU
 *
 * @author shitiangao
 */
public class LfuCache2 {
    class CacheNode implements Comparable<CacheNode> {
        int key;
        int value;
        int count;
        int clock;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.clock = ++CLK;
        }

        @Override
        public int compareTo(CacheNode o) {
            if (count == o.count) {
                return clock - o.clock;
            }
            return count - o.count;
        }

        void update() {
            count++;
            clock = ++CLK;
        }

        void update(int v) {
            value = v;
            update();
        }

        @Override
        public String toString() {
            return "CacheNode{" +
                    "k=" + key +
                    ", v=" + value +
                    ", c=" + count +
                    ", time=" + clock +
                    '}';
        }
    }

    private Map<Integer, CacheNode> map;
    private PriorityQueue<CacheNode> queue;
    final int cap;
    static int CLK = 0;

    public LfuCache2(int capacity) {
        cap = capacity;
        if (cap > 0) {
            map = new HashMap<>();
            queue = new PriorityQueue<>();
        }
    }

    public int get(int key) {
        if (cap < 1) {
            return -1;
        }
        CacheNode node = map.get(key);
        if (node == null) return -1;

        node.update();
        queue.remove(node);
        queue.add(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cap < 1) {
            return;
        }
        CacheNode node = map.get(key);

        if (node != null) {
            node.update(value);
            queue.remove(node);
            queue.add(node);
            return;
        }
        CacheNode newNode = new CacheNode(key, value);

        map.put(key, newNode);
        if (map.size() > cap) {
            CacheNode poll = queue.poll();
            map.remove(poll.key);
        }
        queue.add(newNode);
    }
}
