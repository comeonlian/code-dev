#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/3/12 12:34
# @Author  : lianliang
# @File    : lc_0020.py

"""
LC 34 : 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：
你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？

提示：
0 <= nums.length <= 10^5
-10^9<= nums[i]<= 10^9
nums是一个非递减数组
-10^9<= target<= 10^9

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]
"""


class Solution:
    def search_range(self, nums: list, target: int) -> list:
        if len(nums) == 0:
            return [-1, -1]
        start = 0
        end = len(nums) - 1
        if target < nums[start] or target > nums[end]:
            return [-1, -1]

        num_index_list = []

        self.binary_search(nums, target, start, end, num_index_list)

        if len(num_index_list) == 0:
            return [-1, -1]
        num_index_list.sort()
        return [num_index_list[0], num_index_list[-1]]

    def binary_search(self, nums: list, target: int, start: int, end: int, num_index_list: list):
        if start <= end:
            mid = (start + end) // 2
            if nums[mid] > target:
                self.binary_search(nums, target, start, mid - 1, num_index_list)
            elif nums[mid] < target:
                self.binary_search(nums, target, mid + 1, end, num_index_list)
            elif nums[mid] == target:
                num_index_list.append(mid)
                self.binary_search(nums, target, start, mid - 1, num_index_list)
                self.binary_search(nums, target, mid + 1, end, num_index_list)


solution = Solution()
nums = [5, 7, 7, 8, 8, 10]
target = 6
print(solution.search_range(nums, target))

"""
执行用时：40 ms, 在所有 Python3 提交中击败了41.59%的用户
内存消耗：15.9 MB, 在所有 Python3 提交中击败了64.20%的用户
"""
