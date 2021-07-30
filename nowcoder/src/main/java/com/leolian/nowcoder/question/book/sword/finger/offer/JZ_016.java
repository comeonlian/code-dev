package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 16 : 合并两个排序的链表
 * <p>
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * <p>
 * 示例1
 * 输入：{1,3,5},{2,4,6}
 * 返回值：{1,2,3,4,5,6}
 */
public class JZ_016 {

    public static void main(String[] args) {
        JZ_016 jz016 = new JZ_016();

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(5);

        list1.next = list2;
        list2.next = list3;

        ListNode list11 = new ListNode(2);
        ListNode list22 = new ListNode(4);
        ListNode list33 = new ListNode(6);

        list11.next = list22;
        list22.next = list33;

        ListNode merge = jz016.Merge(list1, list11);
        while (merge != null) {
            System.out.print(merge.val + " ");
            merge = merge.next;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode left = list1;
        ListNode right = list2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                cur = left;
                left = left.next;
            } else {
                cur.next = right;
                cur = right;
                right = right.next;
            }
        }
        while (left != null) {
            cur.next = left;
            cur = left;
            left = left.next;
        }
        while (right != null) {
            cur.next = right;
            cur = right;
            right = right.next;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
