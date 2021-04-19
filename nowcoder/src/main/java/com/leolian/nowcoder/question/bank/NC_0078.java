package com.leolian.nowcoder.question.bank;

/**
 * NC 78 : 反转链表
 * <p>
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * <p>
 * 示例1:
 * 输入
 * {1,2,3}
 * 返回值
 * {3,2,1}
 */
public class NC_0078 {

    public static void main(String[] args) {
        NC_0078 nc0078 = new NC_0078();
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode resHead = nc0078.ReverseList(head);
        ListNode nodeTmp = resHead.next;
        while (nodeTmp != null) {
            System.out.print(nodeTmp.val + " ");
            nodeTmp = nodeTmp.next;
        }
    }

    /**
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            if (newHead.next != null) {
                ListNode node1 = newHead.next;
                newNode.next = node1;
                newHead.next = newNode;
            } else {
                newHead.next = newNode;
            }
            head = head.next;
        }
        return newHead.next;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}