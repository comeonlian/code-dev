package com.leolian.nowcoder.question.bank.page01;

import java.util.Stack;

/**
 * NC 40 : 两个链表生成相加链表
 * <p>
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * 备注：
 * 1 ≤ n,m ≤ 10^6
 * 0 ≤ ai,bi ≤ 9
 * <p>
 * 示例1
 * 输入：[9,3,7],[6,3]
 * 返回值：{1,0,0,0}
 */
public class NC_0040 {

    public static void main(String[] args) {
        NC_0040 nc0040 = new NC_0040();

        ListNode head1 = new ListNode(9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        head1.next = node2;
        node2.next = node3;

        ListNode head2 = new ListNode(6);
        ListNode node22 = new ListNode(6);
        head2.next = node22;

        ListNode node = nc0040.addInList(head1, head2);
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        if (null == head1 && null == head2) {
            return null;
        }
        if (null == head1) {
            return head2;
        }
        if (null == head2) {
            return head1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur = head1;
        while (cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }
        cur = head2;
        while (cur != null) {
            stack2.push(cur.val);
            cur = cur.next;
        }
        ListNode resHead = new ListNode(0);
        int advance = 0;
        int num1 = 0, num2 = 0, sum = 0;
        while (stack1.size() > 0 || stack2.size() > 0) {
            num1 = stack1.isEmpty() ? 0 : stack1.pop();
            num2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = num1 + num2 + advance;
            if (sum >= 10) {
                sum = sum % 10;
                advance = 1;
            } else {
                advance = 0;
            }
            ListNode node = new ListNode(sum);
            if (null == resHead.next) {
                resHead.next = node;
            } else {
                ListNode tmpNode = resHead.next;
                resHead.next = node;
                node.next = tmpNode;
            }
        }
        if (advance == 1) {
            ListNode node = new ListNode(advance);
            ListNode tmpNode = resHead.next;
            resHead.next = node;
            node.next = tmpNode;
        }
        return resHead.next;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
