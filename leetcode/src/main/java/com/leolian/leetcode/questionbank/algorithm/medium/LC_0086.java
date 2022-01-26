package com.leolian.leetcode.questionbank.algorithm.medium;

/**
 * LC 86 : 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * <p>
 * 示例1
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * https://assets.leetcode.com/uploads/2021/01/04/partition.jpg
 * <p>
 * 示例2
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class LC_0086 {

	public static void main(String[] args) {
		LC_0086 lc0086 = new LC_0086();

		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(2);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		int x = 3;

		ListNode res = lc0086.partition(head, x);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if (null == head || null == head.next) {
			return head;
		}
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		ListNode cur1 = head1, cur2 = head2;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				cur1.next = cur;
				cur1 = cur1.next;
			} else {
				cur2.next = cur;
				cur2 = cur2.next;
			} 
			cur = cur.next;
		}
		cur2.next = null;
		cur1.next = head2.next;
		return head1.next;
	}

	private static class ListNode {
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
	执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
	内存消耗：40.9 MB, 在所有 Java 提交中击败了5.11%的用户
	通过测试用例：168 / 168
	*/
}
