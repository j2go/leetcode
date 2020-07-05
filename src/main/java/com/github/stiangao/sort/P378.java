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
    int size;

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        smallHeap = new HeapNode[n];
        size = 0;
        for (int[] arr : matrix) {
            insertHeap(new HeapNode(arr, 0));
        }
        while ((--k) > 0) {
            poll();
        }
        return smallHeap[0].val();
    }

    void insertHeap(HeapNode node) {
        if (size == 0) {
            smallHeap[size++] = node;
            return;
        }
        int i = size;
        while (i > 0) {
            int p = (i - 1) >> 1;
            if (smallHeap[p].val() < node.val()) break;
            smallHeap[i] = smallHeap[p];
            i = p;
        }
        smallHeap[i] = node;
        size++;
    }

    int poll() {
        int top = smallHeap[0].val();
        if(smallHeap[0].plusAndHasNext()) {
            adjustTop();
        } else {
            upLeaf();
        }
        return top;
    }

    private void upLeaf() {
        int l = 1, r = 2;
    }

    private void adjustTop() {

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(new P378().kthSmallest(matrix, 5));
    }
}
