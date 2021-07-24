package com.leolian.nowcoder.question.bank;

import java.util.Stack;

/**
 * NC 50 : 链表中的节点每k个一组翻转
 * 题目描述
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 O(1)
 * 例如：
 * 给定的链表是1 -> 2 -> 3 -> 4 -> 5
 * 对于 k=2, 你应该返回 2 -> 1 -> 4 -> 3 -> 5
 * 对于 k=3, 你应该返回 3 -> 2 -> 1 -> 4 -> 5
 * <p>
 * 示例1 :
 * 输入
 * {1,2,3,4,5}, 2
 * 返回值
 * {2,1,4,3,5}
 */
public class NC_0050 {

    public static void main(String[] args) {
        NC_0050 nc0050 = new NC_0050();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 6;
        ListNode resultNode = nc0050.reverseKGroup(head, k);
        while (resultNode != null) {
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        if (k == 0 || k == 1 || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size = size + 1;
            cur = cur.next;
        }
        if (k > size) {
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode newHead = null;
        ListNode newCur = null;
        cur = head;
        while (cur != null) {
            if (stack.size() >= k) {
                while (stack.size() > 0) {
                    ListNode tmpNode = new ListNode(stack.pop());
                    if (newHead == null) {
                        newHead = tmpNode;
                    } else {
                        newCur.next = tmpNode;
                    }
                    newCur = tmpNode;
                }
                stack.push(cur.val);
            } else {
                stack.push(cur.val);
            }
            cur = cur.next;
        }
        if (stack.size() > 0) {
            if ((stack.size() == k) && (newCur == null)) {
                while (stack.size() > 0) {
                    ListNode tmpNode = new ListNode(stack.pop());
                    if (newCur == null) {
                        newCur = tmpNode;
                        newHead = tmpNode;
                    } else {
                        newCur.next = tmpNode;
                        newCur = tmpNode;
                    }
                }
            } else {
                while (stack.size() > 0) {
                    ListNode tmpNode = new ListNode(stack.pop());
                    if (newCur.next == null) {
                        newCur.next = tmpNode;
                    } else {
                        ListNode right = newCur.next;
                        newCur.next = tmpNode;
                        tmpNode.next = right;
                    }
                }
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

