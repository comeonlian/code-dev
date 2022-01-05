package com.leolian.nowcoder.question.bank.page02;

/**
 * NC 96 : 判断一个链表是否为回文结构
 * <p>
 * 题目描述
 * 给定一个链表，请判断该链表是否为回文结构。
 * 备注：
 * 1≤n≤10^6
 * <p>
 * 示例1:
 * 输入: [1]
 * 返回: true
 * 示例2:
 * 输入: [2,1]
 * 返回: false
 * 说明：2->1
 * 示例3:
 * 输入: [1,2,2,1]
 * 返回: true
 * 说明：1->2->2->1
 */
public class NC_0096 {

    public static void main(String[] args) {
        NC_0096 nc0096 = new NC_0096();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);

        //head.next = node1;
        //node1.next = node2;
        //node2.next = node3;

        System.out.println(nc0096.isPail(head));
    }

    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        if (null == head) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode curNode = head;
        ListNode newHead = null;
        while (curNode != null) {
            int val = curNode.val;
            if (newHead == null) {
                newHead = new ListNode(val);
            } else {
                ListNode tmpNode = new ListNode(val);
                tmpNode.next = newHead;
                newHead = tmpNode;
            }
            curNode = curNode.next;
        }
        while (head != null && newHead != null) {
            int val = head.val;
            int newVal = newHead.val;
            if (val != newVal) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}

