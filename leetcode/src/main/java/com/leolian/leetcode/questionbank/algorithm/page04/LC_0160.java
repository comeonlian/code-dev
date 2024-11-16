package com.leolian.leetcode.questionbank.algorithm.page04;

import java.util.HashSet;

/**
 * LC 160 : 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 示例1
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
 * <p>
 * 示例2
 * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例3
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：No intersection
 * https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 */
public class LC_0160 {

    public static void main(String[] args) {
        LC_0160 lc0160 = new LC_0160();

        ListNode headA = new ListNode(4);
        ListNode nodeA1 = new ListNode(1);

        headA.next = nodeA1;

        ListNode headB = new ListNode(5);
        ListNode nodeB1 = new ListNode(6);
        ListNode nodeB2 = new ListNode(1);

        headB.next = nodeB1;
        nodeB1.next = nodeB2;

        ListNode commonNode1 = new ListNode(8);
        ListNode commonNode2 = new ListNode(4);
        ListNode commonNode3 = new ListNode(5);

        commonNode1.next = commonNode2;
        commonNode2.next = commonNode3;

        nodeA1.next = commonNode1;
        nodeB2.next = commonNode1;

        System.out.println(commonNode1.hashCode());
        ListNode node = lc0160.getIntersectionNode(headA, headB);
        while (node != null) {
            System.out.print(" " + node.val);
            node = node.next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA.next == null || headB.next == null) {
            if (headA.hashCode() == headB.hashCode()) {
                return headA;
            }
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode curNode = headA;
        while (curNode != null) {
            set.add(curNode);
            curNode = curNode.next;
        }
        curNode = headB;
        while (curNode != null) {
            if (set.contains(curNode)) {
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
