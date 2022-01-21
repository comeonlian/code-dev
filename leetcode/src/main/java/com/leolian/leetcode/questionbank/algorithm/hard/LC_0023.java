package com.leolian.leetcode.questionbank.algorithm.hard;

import java.util.PriorityQueue;

/**
 * LC 23 : 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 示例1
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例2
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例3
 * 输入：lists = [[]]
 * 输出：[]
 */
public class LC_0023 {

    public static void main(String[] args) {
        LC_0023 lc0023 = new LC_0023();

        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(5);

        head1.next = node11;
        node11.next = node12;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);

        head2.next = node21;
        node21.next = node22;

        ListNode head3 = new ListNode(2);
        ListNode node31 = new ListNode(6);

        head3.next = node31;

        ListNode[] listNodes = new ListNode[]{head1, head2, head3};

        ListNode res = lc0023.mergeKLists(listNodes);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(new Node(listNode.val, listNode));
            }
        }

        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            cur.next = poll.ptr;
            cur = cur.next;

            if (poll.ptr.next != null) {
                queue.offer(new Node(poll.ptr.next.val, poll.ptr.next));
            }
        }
        
        return newHead.next;
    }
    
    /*
    执行用时：4 ms, 在所有 Java 提交中击败了69.85%的用户
    内存消耗：40 MB, 在所有 Java 提交中击败了69.80%的用户
    通过测试用例：133 / 133
    */
    
    class Node implements Comparable<Node> {
        int val;
        ListNode ptr;

        public Node(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Node node) {
            return this.val - node.val;
        }
    }
    
/*
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        ListNode[] ptrs = new ListNode[lists.length];
        System.arraycopy(lists, 0, ptrs, 0, lists.length);

        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;

        HashSet<Integer> emptySet = new HashSet<>();
        while (emptySet.size() < lists.length) {
            int minIndex = 0;
            int minVal = Integer.MAX_VALUE;
            ListNode minPtr = null;
            for (int i = 0; i < ptrs.length; i++) {
                ListNode ptr = ptrs[i];
                if (null == ptr) {
                    emptySet.add(i); 
                    continue;
                }
                if (ptr.val < minVal) {
                    minIndex = i;
                    minVal = ptr.val;
                    minPtr = ptr;
                }
            }
            if(null != minPtr) { 
                ptrs[minIndex] = minPtr.next;
                ListNode node = new ListNode(minVal);
                cur.next = node;
                cur = node;
            }
        }
        return newHead.next;
    }
    */
    /*
    执行用时：1092 ms, 在所有 Java 提交中击败了5.13%的用户
    内存消耗：41.1 MB, 在所有 Java 提交中击败了5.11%的用户
    通过测试用例：133 / 133
    */

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
