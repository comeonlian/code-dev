package com.leolian.leetcode.questionbank.algorithm.page02;

/**
 * LC 61 :  旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 * <p>
 * 示例1
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg
 * <p>
 * 示例2
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg
 */
public class LC_0061 {

    public static void main(String[] args) {
        LC_0061 lc0061 = new LC_0061();

        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 0;

        ListNode newHead = lc0061.rotateRight(head, k);
        while (newHead != null) {
            System.out.print(" " + newHead.val);
            newHead = newHead.next;
        }
        System.out.println();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode curNode = head;
        int len = 0;
        while (curNode != null) {
            len++;
            curNode = curNode.next;
        }
        if ((k >= len) && (k % len == 0)) {
            return head;
        }
        int mod = len > k ? k : Math.floorMod(k, len);
        int start = len - mod;
        curNode = head;
        int index = 0;
        while (curNode != null) {
            index++;
            if (index == start) {
                break;
            }
            curNode = curNode.next;
        }
        assert curNode != null;
        ListNode newHead = curNode.next; //新的子链表
        curNode.next = null;
        ListNode curNewNode = newHead;
        while (curNewNode.next != null) {
            curNewNode = curNewNode.next;
        }
        curNewNode.next = head;
        return newHead;
    }

    static class ListNode {
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
