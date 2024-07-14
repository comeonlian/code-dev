package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 19 : 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 示例1
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例2
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例3
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class LC_0019 {

    public static void main(String[] args) {
        LC_0019 lc0019 = new LC_0019();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newHead = lc0019.removeNthFromEnd(head, 6);
        while (newHead != null) {
            System.out.print(" " + newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        int length = 0;
        ListNode curNode = head;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        if (n > length) {
            return head;
        }

        int targetPos = length - n;
        if (targetPos == 0) {
            return head.next;
        }

        int index = 1;
        curNode = head;
        ListNode targetNode = null;
        while (curNode != null) {
            if (targetPos == index) {
                targetNode = curNode;
                break;
            }
            curNode = curNode.next;
            index++;
        }
        if (targetNode != null)
            targetNode.next = targetNode.next.next;
        return head;
    }

    protected static class ListNode {
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
