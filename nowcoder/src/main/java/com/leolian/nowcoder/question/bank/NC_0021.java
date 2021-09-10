package com.leolian.nowcoder.question.bank;

/**
 * NC 21 : 链表内指定区间反转
 * <p>
 * 题目描述
 * 将一个链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
 * 例如：
 * 给出的链表为 1→2→3→4→5→NULL, m=2,n=4
 * 返回 1→4→3→2→5→NULL.
 * 注意：
 * 给出的 m,n 满足以下条件：
 * 1≤m≤n≤链表长度
 * <p>
 * 示例1:
 * 输入：{1,2,3,4,5},2,4
 * 返回值：{1,4,3,2,5}
 */
public class NC_0021 {

	public static void main(String[] args) {
		NC_0021 nc0021 = new NC_0021();

		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		int m = 2;
		int n = 3;
		ListNode res = nc0021.reverseBetween(head, m, n);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

	// 1、还是采用头插和尾插方式，创建一个新的链表
	// 2、首先遍历原始链表，并对遍历过的每个节点计数，如果遍历节点计数小于等于m，则采用尾插法插入新链表
	// 3、如果遍历节点计数大于m并且小于等于n，则采用头插法插入新链表
	// 4、如果遍历节点计数大于n，则采用尾插法插入新链表
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (null == head) {
			return null;
		}
		if (m >= n) {
			return head;
		}
		ListNode newHead = new ListNode(0);
		ListNode pre = newHead; // 头插前驱指针
		ListNode tail = newHead; // 尾插指针
		int count = 1;
		ListNode cur = head;
		while (cur != null) {
			ListNode node = new ListNode(cur.val);
			if (count <= m || count > n) {
				// 尾插
				tail.next = node;
				pre = tail;
				tail = node;
			} else if (count <= n) {
				// 头插
				node.next = pre.next;
				pre.next = node;
			}
			count++;
			cur = cur.next;
		}
		return newHead.next;
	}

	private static class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}

}
