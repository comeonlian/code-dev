package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.Stack;

/**
 * JZ14 : 链表中倒数最后k个结点
 * <p>
 * 题目描述
 * 输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 * <p>
 * 示例1
 * 输入：{1,2,3,4,5},1
 * 返回值：{5}
 */
public class JZ_014 {

    public static void main(String[] args) {
        JZ_014 jz014 = new JZ_014();

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        int k = 2;
        ListNode listNode = jz014.FindKthToTail(list1, k);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    /**
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (null == pHead || k == 0) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = pHead;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        if (stack.size() < k) {
            return null;
        }
        int count = 1;
        while (stack.size() > 0) {
            ListNode listNode = stack.pop();
            if (count == k) {
                return listNode;
            }
            count++;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
