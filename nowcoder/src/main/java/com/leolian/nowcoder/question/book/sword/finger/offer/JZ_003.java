package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * JZ 3 : 从尾到头打印链表
 * <p>
 * 题目描述
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 * 如 输入{1,2,3}的链表 如下:
 * head -> 1 -> 2 -> 3
 * 返回一个数组为 [3,2,1]
 * 0 <= 链表长度 <= 1000
 * <p>
 * 示例1
 * 输入：{1,2,3}
 * 返回值：[3,2,1]
 * <p>
 * 示例2
 * 输入：{67,0,24,58}
 * 返回值：[58,24,0,67]
 */
public class JZ_003 {

    public static void main(String[] args) {
        JZ_003 jz003 = new JZ_003();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(jz003.printListFromTailToHead(head));
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (null == listNode) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer> list = new ArrayList<>(stack.size());
        while (stack.size() > 0) {
            list.add(stack.pop());
        }
        return list;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
