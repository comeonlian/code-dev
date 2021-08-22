package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.HashSet;

/**
 * JZ 56 : 删除链表中重复的结点
 * <p>
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * 示例1
 * 输入：{1,2,3,3,4,4,5}
 * 返回值：{1,2,5}
 */
public class JZ_056 {

    public static void main(String[] args) {
        JZ_056 jz056 = new JZ_056();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode res = jz056.deleteDuplication(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        if (null == pHead.next) {
            return pHead;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }
        ListNode newHead = new ListNode(0);
        ListNode newCur = newHead;
        cur = pHead;
        while (cur != null) {
            if (!set.contains(cur.val)) {
                ListNode node = new ListNode(cur.val);
                newCur.next = node;
                newCur = node;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
