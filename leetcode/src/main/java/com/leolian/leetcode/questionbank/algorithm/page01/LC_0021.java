package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 21 : 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 示例1
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例2
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例3
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class LC_0021 {

    public static void main(String[] args) {
        LC_0021 lc0021 = new LC_0021();

        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode head2 = new ListNode(3);
        ListNode node11 = new ListNode(7);
        ListNode node22 = new ListNode(8);
        ListNode node33 = new ListNode(9);
        head2.next = node11;
        node11.next = node22;
        node22.next = node33;

        ListNode res = lc0021.mergeTwoLists(head1, head2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode res = new ListNode();
        ListNode cur = res;
        ListNode pt1 = l1, pt2 = l2;
        while (pt1 != null && pt2 != null) {
            if (pt1.val <= pt2.val) {
                cur.next = pt1;
                pt1 = pt1.next;
            } else {
                cur.next = pt2;
                pt2 = pt2.next;
            }
            cur = cur.next;
        }
        while (pt1 != null) {
            cur.next = pt1;
            cur = cur.next;
            pt1 = pt1.next;
        }
        while (pt2 != null) {
            cur.next = pt2;
            cur = cur.next;
            pt2 = pt2.next;
        }
        return res.next;
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
