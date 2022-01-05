package com.leolian.nowcoder.question.bank.page01;

/**
 * NC 4 : 判断链表中是否有环
 * <p>
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度 O(1) 的解法么？
 * 输入分为2部分，第一部分为链表，第二部分代表是否有环，然后回组成head头结点传入到函数里面。
 * -1代表无环，其他的数字代表有环，这些参数解释仅仅是为了方便读者自测调试
 * <p>
 * 示例1:
 * 输入：
 * {3,2,0,-4},1
 * 返回值：
 * true
 * 说明：
 * 第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1，即-4->2存在一个链接，组成传入的head为一个带环的链表 ,返回true
 * <p>
 * 示例2:
 * 输入：
 * {1},-1
 * 返回值：
 * false
 * 说明：
 * 第一部分{1}代表一个链表，-1代表无环，组成传入head为一个无环的单链表，返回false
 * <p>
 * 示例3:
 * 输入：
 * {-1,-7,7,-4,19,6,-9,-5,-2,-5},6
 * 返回值：
 * true
 */
public class NC_0004 {

    public static void main(String[] args) {
        NC_0004 nc0004 = new NC_0004();

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;

        boolean hasCycle = nc0004.hasCycle(node1);
        System.out.println(hasCycle);
    }


    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
