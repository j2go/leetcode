package main.java.com.github.stiangao.list;

import java.util.Arrays;
import java.util.Comparator;

public class P23 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[3];
        list[0] = build(1, 4, 5);
        list[1] = build(1, 3, 4);
        list[2] = build(2, 6);
        System.out.println(mergeKLists(list));
    }

    private static ListNode build(int... nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }

    /**
     * 最简洁的了
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode t;
        Arrays.sort(lists, Comparator.comparingInt(e -> e.val));
        while (lists[0] != null) {
            p.next = lists[0];
            t = lists[0].next;
            p = p.next;
            p.next = null;
            if (t == null) {
                if (n == 1) {
                    break;
                }
                for (int i = 1; i < n; i++) {
                    lists[i - 1] = lists[i];
                }
                n--;
            } else {
                if (t.val <= lists[1].val) {
                    lists[0] = t;
                } else {
                    for (int i = 1; i < n; i++) {
                        if (t.val > lists[i].val) {
                            lists[i - 1] = lists[i];
                        } else {
                            lists[i - 1] = t;
                            break;
                        }
                        if (i == n - 1) {
                            lists[i] = t;
                        }
                    }
                }
            }
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(val);
            ListNode p = next;
            while (p != null) {
                builder.append(",").append(p.val);
                p = p.next;
            }
            return builder.toString();
        }

    }

    public static ListNode myMergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode[] zSkipList = new ListNode[5];
        zSkipList[0] = lists[0];


        return null;
    }

    private static void fresh(ListNode[] zSkipList) {

    }
}
