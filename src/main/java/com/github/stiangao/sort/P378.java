package com.github.stiangao.sort;

public class P378 {
    class HeapNode {
        int[] array;
        int index;

        HeapNode(int[] arr, int i) {
            array = arr;
            index = i;
        }

        int val() {
            return array[index];
        }

        boolean plusAndHasNext() {
            index++;
            return index < array.length;
        }

        @Override
        public String toString() {
            return String.format("array[%d]=%d", index, val());
        }
    }

    HeapNode[] smallHeap;
    int hi;

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        smallHeap = new HeapNode[n];
        hi = 0;
        for (int[] arr : matrix) {
            insertHeap(new HeapNode(arr, 0));
        }
        while ((--k) != 0) {
            HeapNode node = poll();
            if (node.plusAndHasNext()) {
                insertHeap(node);
            }
        }
        return smallHeap[0].val();
    }

    void insertHeap(HeapNode node) {
        if (hi == 0) {
            smallHeap[hi++] = node;
            return;
        }
        int i = hi;
        while (true) {
            int p = i >> 1;
            if (!(p > 0 && smallHeap[p].val() > node.val())) break;
            smallHeap[i] = smallHeap[p];
            i >>= 1;
        }
        smallHeap[i] = node;
        hi++;
    }

    HeapNode poll() {
        HeapNode head = smallHeap[0];
        for (int i = 0; i << 1 + 1 < hi; ) {
            if (i << 1 + 2 == hi) {
                smallHeap[i] = smallHeap[i * 2 + 1];
                break;
            }
            if (smallHeap[i * 2 + 1].val() < smallHeap[i * 2 + 2].val()) {
                smallHeap[i] = smallHeap[i * 2 + 1];
                if (((i >> 1) + 2) == hi - 1) {
                    smallHeap[i * 2 + 1] = smallHeap[i * 2 + 2];
                    break;
                }
                i = i * 2 + 1;
            } else {
                smallHeap[i] = smallHeap[i * 2 + 2];
                i = i * 2 + 2;
            }
        }
        hi--;
        return head;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new P378().kthSmallest(matrix, 8));
    }
}
