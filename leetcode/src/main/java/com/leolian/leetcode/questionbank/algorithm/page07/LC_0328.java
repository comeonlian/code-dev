package com.leolian.leetcode.questionbank.algorithm.page07;

/**
 * LC 328 : 奇偶链表
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * 提示：
 * n ==  链表中的节点数
 * 0 <= n <= 104
 * -10^6 <= Node.val <= 10^6
 * <p>
 * 示例1
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * https://assets.leetcode.com/uploads/2021/03/10/oddeven-linked-list.jpg
 * <p>
 * 示例2
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * https://assets.leetcode.com/uploads/2021/03/10/oddeven2-linked-list.jpg
 */
public class LC_0328 {

    public static void main(String[] args) {
        LC_0328 lc0328 = new LC_0328();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = lc0328.oddEvenList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int index = 1;
        ListNode curNode = head;
        ListNode oddHead = new ListNode(0);
        ListNode oddCur = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evenCur = evenHead;

        while (curNode != null) {
            if (index % 2 != 0) {
                oddCur.next = curNode;
                oddCur = oddCur.next;
            } else {
                evenCur.next = curNode;
                evenCur = evenCur.next;
            }
            curNode = curNode.next;
            index = index + 1;
        }
        evenCur.next = null;
        oddCur.next = evenHead.next;
        return oddHead.next;
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
