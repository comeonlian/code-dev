package com.leolian.nowcoder.question.bank;

/**
 * NC 53 : 删除链表的倒数第n个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 nn 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1→2→3→4→5, n=2.
 * 删除了链表的倒数第 n个节点之后,链表变为 1→2→3→5.
 * 备注：
 * 题目保证 n 一定是有效的
 * 请给出请给出时间复杂度为 O(n) 的算法
 * <p>
 * 示例1
 * 输入：{1,2},2
 * 返回值：{2}
 */
public class NC_0053 {

    public static void main(String[] args) {
        NC_0053 nc0053 = new NC_0053();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int n = 1;
        ListNode res = nc0053.removeNthFromEnd(head, n);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n <= 0) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int num = length - n + 1;
        if (num == 1) {
            return head.next;
        }
        int index = 1;
        cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (index == num) {
                pre.next = cur.next;
                break;
            }
            index++;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
