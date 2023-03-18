#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : lc_0056.py
# @Author    : liang.lian

"""
LC 56 : 合并区间
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

提示：
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4

示例 1:
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2:
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
"""
from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result = []
        if len(intervals) == 0:
            return result
        c_intervals = []
        for interval in intervals:
            list.append(c_intervals, interval)
        c_intervals = sorted(c_intervals, key=lambda t: t[0])
        start_f, end_f = c_intervals[0][0], c_intervals[0][1]
        for enum in enumerate(c_intervals[1:]):
            index, start, end = enum[0], enum[1][0], enum[1][1]
            if start <= start_f or start <= end_f:
                if start <= start_f:
                    start_f = start
                if end > end_f:
                    end_f = end
            else:
                list.append(result, [start_f, end_f])
                start_f = start
                end_f = end
        list.append(result, [start_f, end_f])
        return result


solution = Solution()
intervals = [[2, 3], [4, 5], [6, 7], [8, 9], [1, 10]]
result_val = solution.merge(intervals)
print(result_val)

"""
执行用时：52 ms, 在所有 Python3 提交中击败了53.71%的用户
内存消耗：19.4 MB, 在所有 Python3 提交中击败了5.05%的用户
通过测试用例：170 / 170
"""
