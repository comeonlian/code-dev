#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/3/12 12:34
# @Author  : lianliang
# @File    : lc_0020.py

"""
LC 24 : 两两交换链表中的节点
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg

提示：
链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100

示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]

示例 2：
输入：head = []
输出：[]

示例 3：
输入：head = [1]
输出：[1]
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def swap_pairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        cur, index = head, 0
        list_node_1, list_node_2 = [], []
        while cur is not None:
            if (index % 2) == 0:
                list_node_2.append(cur)
            else:
                list_node_1.append(cur)
            index += 1
            cur = cur.next
        new_head, cur = None, None
        index, min_len = 0, min(len(list_node_1), len(list_node_2))
        while index < min_len:
            node_1, node_2 = list_node_1[index], list_node_2[index]
            if cur is not None:
                cur.next = node_1
            node_1.next = node_2
            if new_head is None:
                new_head = node_1
            cur = node_2
            index += 1
        cur.next = None
        if index < len(list_node_1):
            cur.next = list_node_1[index]
        if index < len(list_node_2):
            cur.next = list_node_2[index]
        return new_head


solution = Solution()
head = ListNode(1)
node1 = ListNode(2)
node2 = ListNode(3)
node3 = ListNode(4)
node4 = ListNode(5)

head.next = node1
node1.next = node2
node2.next = node3
node3.next = node4

newhead = solution.swap_pairs(head)
while newhead is not None:
    print(newhead.val, ' ')
    newhead = newhead.next

"""
执行用时：44 ms, 在所有 Python3 提交中击败了11.59%的用户
内存消耗：14.8 MB, 在所有 Python3 提交中击败了87.78%的用户
"""
