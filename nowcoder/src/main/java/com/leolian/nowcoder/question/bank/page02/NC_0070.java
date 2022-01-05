package com.leolian.nowcoder.question.bank.page02;

import java.util.Arrays;

/**
 * NC 70 : 单链表的排序
 * <p>
 * 题目描述
 * 给定一个无序单链表，实现单链表的排序(按升序排序)。
 * <p>
 * 示例1:
 * 输入：[1,3,2,4,5]
 * 返回值：{1,2,3,4,5}
 */
public class NC_0070 {

    public static void main(String[] args) {
        NC_0070 nc0070 = new NC_0070();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode resultNode = nc0070.sortInList(node1);
        while (resultNode != null) {
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }
    }

    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }
        int size = 0;
        ListNode sizeHead = head;
        while (sizeHead != null) {
            size = size + 1;
            sizeHead = sizeHead.next;
        }
        int[] array = new int[size];
        int index = 0;
        ListNode readHead = head;
        while (readHead != null) {
            array[index] = readHead.val;
            index = index + 1;
            readHead = readHead.next;
        }
        // 排序
        Arrays.sort(array);
        ListNode resHead = null;
        ListNode curNode = null;
        for (int val : array) {
            if (null == resHead) {
                resHead = new ListNode(val);
                curNode = resHead;
            } else {
                ListNode listNode = new ListNode(val);
                curNode.next = listNode;
                curNode = listNode;
            }
        }
        return resHead;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}

