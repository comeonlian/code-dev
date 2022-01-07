package com.leolian.nowcoder.question.bank.page05;

/**
 * NC 207 : 排序奇升偶降链表
 * 题目描述
 * 给定一个奇数位升序，偶数位降序的链表，返回对其排序后的链表。
 * 题面解释：例如链表 1->3->2->2->3->1 是奇数位升序偶数位降序的链表，而 1->3->2->2->3->2 则不符合题目要求。
 * 备注：
 * 数据范围：链表中元素个数满足  1 <= n <= 10000，链表中的元素大小满足 1 <= val <= 100000
 * <p>
 * 示例1
 * 输入：[1,3,2,2,3,1]
 * 返回值：{1,1,2,2,3,3}
 * <p>
 * 示例2
 * 输入：[1,2,2]
 * 返回值：{1,2,2}
 */
public class NC_0207 {

	public static void main(String[] args) {
		NC_0207 nc0207 = new NC_0207();

		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(2);
//		ListNode node4 = new ListNode(3);
//		ListNode node5 = new ListNode(1);
		head.next = node1;
		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;

		ListNode node = nc0207.sortLinkedList(head);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	public ListNode sortLinkedList(ListNode head) {
		ListNode cur = head;
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		int[] arr = new int[len];
		int index = 0;
		cur = head;
		while (cur != null) {
			arr[index++] = cur.val;
			cur = cur.next;
		}
		int left = 0, right = (((len - 1) % 2) == 0) ? len - 2 : len - 1;
		ListNode newHead = new ListNode(0);
		cur = newHead;
		ListNode node = null;
		while (left < len && right >= 0) {
			if (arr[left] < arr[right]) {
				node = new ListNode(arr[left]);
				cur.next = node;
				cur = node;
				left = left + 2;
			} else {
				node = new ListNode(arr[right]);
				cur.next = node;
				cur = node;
				right = right - 2;
			} 
		}
		while (left < len) {
			node = new ListNode(arr[left]);
			cur.next = node;
			cur = node;
			left = left + 2;
		}
		while (right >= 0) {
			node = new ListNode(arr[right]);
			cur.next = node;
			cur = node;
			right = right - 2;
		}
		return newHead.next;
	}
	
	/*
	运行时间：618ms
	超过60.61% 用Java提交的代码
	占用内存：44680KB
	超过21.05%用Java提交的代码
	*/
	
	private static class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}

}
