#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : lc_0049.py
# @Time      : 2022/3/31 19:57
# @Author    : liang.lian

"""
LC 49 : 字母异位词分组
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

提示：
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母

示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

示例 2:
输入: strs = [""]
输出: [[""]]

示例 3:
输入: strs = ["a"]
输出: [["a"]]
"""


class Solution:
    def group_anagrams(self, strs: list) -> list:
        total_list = {}
        for str in strs:
            add, multi, total = 0, 1, 0
            for ch in str:
                ch_val = ord(ch)
                add += ch_val
                multi *= ch_val
            total = add + multi
            if total in total_list:
                total_list[total].append(str)
            else:
                val_list = [str]
                total_list[total] = val_list
        return list(total_list.values())


solution = Solution()
strs = ["cab","tin","pew","duh","may","ill","buy","bar","max","doc"]
result_list = solution.group_anagrams(strs)
print(result_list)

"""
执行用时：52 ms, 在所有 Python3 提交中击败了67.12%的用户
内存消耗：17.6 MB, 在所有 Python3 提交中击败了97.76%的用户
"""