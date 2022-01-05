package com.leolian.nowcoder.question.bank.page01;

/**
 * NC 25 : 删除有序链表中重复的元素-I
 * <p>
 * 题目描述
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1→1→2，返回1→2
 * 给出的链表为1→1→2→3→3，返回1→2→3
 * <p>
 * 示例1
 * 输入：{1,1,2}
 * 返回值：{1,2}
 */
public class NC_0025 {

    public static void main(String[] args) {
        NC_0025 nc0025 = new NC_0025();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = nc0025.deleteDuplicates(head);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        ListNode newHead = null;
        ListNode newNode = null;
        while (curNode != null) {
            int curVal = curNode.val;
            if (null == newHead) {
                newHead = new ListNode(curVal);
                newNode = newHead;
                curNode = curNode.next;
            } else {
                int newVal = newNode.val;
                if (curVal == newVal) {
                    curNode = curNode.next;
                    continue;
                }
                ListNode listNode = new ListNode(curVal);
                newNode.next = listNode;
                newNode = listNode;
            }
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
