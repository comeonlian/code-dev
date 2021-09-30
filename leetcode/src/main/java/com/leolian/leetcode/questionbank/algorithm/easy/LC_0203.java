package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 203 : 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * <p>
 * 示例1
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例2
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例3
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class LC_0203 {

    public static void main(String[] args) {
        LC_0203 lc0203 = new LC_0203();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        int val = 6;

        ListNode res = lc0203.removeElements(null, val);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

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
