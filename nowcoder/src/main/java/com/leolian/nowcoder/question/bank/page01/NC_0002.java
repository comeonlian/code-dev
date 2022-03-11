package com.leolian.nowcoder.question.bank.page01;

import java.util.Stack;

/**
 * NC 2 : 重排链表
 * <p>
 * 将给定的单链表 L： L0→L1→…→L{n-1}→Ln
 * 重新排序为：L0→Ln →L1→L{n-1}→L2→L{n-2}→…
 * 要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
 * 数据范围：链表长度 0≤n≤20000 ，链表中每个节点的值满足 0≤val≤1000
 * 要求：空间复杂度 O(n) 并在链表上进行操作而不新建链表，时间复杂度 O(n)
 * 进阶：空间复杂度 O(1) ， 时间复杂度 O(n)
 * <p>
 * 示例1
 * 输入：{1,2,3,4}
 * 返回值：{1,4,2,3}
 * 说明：给定head链表1->2->3->4, 重新排列为 1->4->2->3,会取head链表里面的值打印输出
 * <p>
 * 示例2
 * 输入：{1,2,3,4,5}
 * 返回值：{1,5,2,4,3}
 * 说明：给定head链表1->2->3->4->5, 重新排列为 1->5->2->4->3,会取head链表里面的值打印输出
 * <p>
 * 示例3
 * 输入：{}
 * 返回值：{}
 */
public class NC_0002 {

    public static void main(String[] args) {
        NC_0002 nc0002 = new NC_0002();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        nc0002.reorderList(head);

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public void reorderList(ListNode head) {
        if (null == head || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int index = 0;
        int targetIndex = ((len - 1) / 2) + 1;
        cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            if (index++ >= targetIndex) {
                stack.push(cur);
            }
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (stack.size() > 0) {
                ListNode pop = stack.pop();
                ListNode tmp = cur.next;
                cur.next = pop;
                pop.next = tmp;
                cur = cur.next;
            } else {
                cur.next = null;
            }
            cur = cur.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    /*
    运行时间：699ms
    超过43.43% 用Java提交的代码
    
    占用内存：41660KB
    超过75.17%用Java提交的代码
    */
}
