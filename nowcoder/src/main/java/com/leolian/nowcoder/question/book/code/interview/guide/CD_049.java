package com.leolian.nowcoder.question.book.code.interview.guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * CD 49 : 在链表中删除倒数第K个节点
 * <p>
 * 题目描述
 * 给出一个单链表，返回删除单链表的倒数第 K 个节点的链表。
 * <p>
 * 输入描述：
 * n 表示链表的长度。
 * val 表示链表中节点的值。
 * 输出描述：
 * 在给定的函数内返回链表的头指针。
 * <p>
 * 示例1
 * 输入：
 * 5 4
 * 1 2 3 4 5
 * 输出：
 * 1 3 4 5
 * <p>
 * 备注：
 * 1 <= K <= N <= 1000000
 * −1000000 <= val <= 1000000
 */
public class CD_049 {

    public static void main(String[] args) throws IOException {
        CD_049 main = new CD_049();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray1 = bufferedReader.readLine().trim().split(" ");
        int[] intArray1 = Arrays.stream(strArray1).mapToInt(Integer::parseInt).toArray();
        int n = intArray1[0];
        int k = intArray1[1];
        String[] strArray2 = bufferedReader.readLine().trim().split(" ");
        int[] intArray2 = Arrays.stream(strArray2).mapToInt(Integer::parseInt).toArray();
        ListNode head = null, cur = null;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                head = new ListNode(intArray2[i]);
                cur = head;
            } else {
                ListNode node = new ListNode(intArray2[i]);
                cur.next = node;
                cur = node;
            }
        }
        ListNode res = solve(head, k);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    private static ListNode solve(ListNode head, int n) {
        if (null == head || n <= 0) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int num = length - n + 1;
        if (num == 1) {
            return head.next;
        }
        int index = 1;
        cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (index == num) {
                pre.next = cur.next;
                break;
            }
            index++;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
