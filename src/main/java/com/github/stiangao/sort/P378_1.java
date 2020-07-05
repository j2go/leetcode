package com.github.stiangao.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shitiangao
 */
public class P378_1 {


    public int kthSmallest(int[][] matrix, int k) {
        class P {
            int x;
            int y;
            public P(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        PriorityQueue<P> queue = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a.x][a.y]));
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            queue.add(new P(i, 0));
        }
        P top;
        for (int i = 0; i < k; i++) {
            top = queue.poll();
            top.y = top.y + 1;
            if (top.y < n) {
                queue.add(top);
            }
        }
        top = queue.poll();
        return matrix[top.x][top.y];
    }
}
