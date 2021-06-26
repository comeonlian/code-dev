package com.leolian.nowcoder.question.bank;

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

        int k = 2;

        ListNode resultNode = nc0050.reverseKGroup(head, k);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        // TODO
        return null;
    }

}

