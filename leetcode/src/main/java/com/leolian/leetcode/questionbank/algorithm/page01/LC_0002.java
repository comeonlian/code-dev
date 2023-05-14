package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LC_0002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(3);
        l1.next = second;
        second.next = third;

        ListNode l2 = new ListNode(5);
        ListNode second1 = new ListNode(6);
        ListNode third1 = new ListNode(4);
        l2.next = second1;
        second1.next = third1;

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
        
    }

    /**
     * 执行用时 : 36 ms, 在Add Two Numbers的Java提交中击败了81.80% 的用户
     * 内存消耗 : 48 MB, 在Add Two Numbers的Java提交中击败了16.25% 的用户
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode tempNode = new ListNode(sum % 10);
        ListNode first = tempNode;
        int division = sum / 10;
        while (l1.next != null || l2.next != null) {
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
            sum = l1.val + l2.val + division;
            tempNode.next = new ListNode(sum % 10);
            tempNode = tempNode.next;
            division = sum / 10;
        }
        if (division > 0) {
            tempNode.next = new ListNode(1);
        }
        return first;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

