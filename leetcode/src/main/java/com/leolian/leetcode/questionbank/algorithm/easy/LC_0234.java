package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 234 : 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 提示：
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 * <p>
 * 示例1
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 链接：https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg
 * <p>
 * 示例2
 * 输入：head = [1,2]
 * 输出：false
 * 链接：https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg
 */
public class LC_0234 {

    public static void main(String[] args) {
        LC_0234 lc0234 = new LC_0234();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        System.out.println(lc0234.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        ListNode[] ptrArr = new ListNode[length];
        int index = 0;
        current = head;
        while (current != null) {
            ListNode ptrTmp = current;
            ptrArr[index++] = ptrTmp;
            current = current.next;
        }
        for (int i = 0, j = length - 1; i <= j; i++, j--) {
            ListNode start = ptrArr[i];
            ListNode end = ptrArr[j];
            if (start.val != end.val) {
                return false;
            }
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    /*
    执行用时：4 ms, 在所有 Java 提交中击败了81.44%的用户
    内存消耗：63.6 MB, 在所有 Java 提交中击败了5.04%的用户
    */
}
