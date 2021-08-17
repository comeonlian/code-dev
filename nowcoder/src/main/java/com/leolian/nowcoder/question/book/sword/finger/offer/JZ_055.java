package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 55 : 链表中环的入口结点
 * <p>
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 * <p>
 * 输入描述：
 * 输入分为2段，第一段是入环前的链表部分，第二段是链表环的部分，后台将这2个会组装成一个有环或者无环单链表
 * 返回值描述：
 * 返回链表的环的入口结点即可。而我们后台程序会打印这个节点。
 * <p>
 * 示例1
 * 输入：{1,2},{3,4,5}
 * 返回值：3
 * 说明：
 * 返回环形链表入口节点，我们后台会打印该环形链表入口节点，即3
 * <p>
 * 示例2
 * 输入：{1},{}
 * 返回值："null"
 * 说明：
 * 没有环，返回null，后台打印"null"
 * <p>
 * 示例3
 * 输入：{},{2}
 * 返回值：2
 * 说明：
 * 只有环形链表节点2，返回节点2，后台打印2
 */
public class JZ_055 {

    public static void main(String[] args) {
        JZ_055 jz055 = new JZ_055();

        ListNode pHead = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        pHead.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

//        node6.next = node3;

        ListNode res = jz055.EntryNodeOfLoop(pHead);
        if (res == null) {
            System.out.println(res);
        } else {
            System.out.println(res.val);
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
