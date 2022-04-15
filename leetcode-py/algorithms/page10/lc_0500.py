#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/3/20 18:27
# @Author  : lianliang
# @File    : lc_0500.py

"""
LC 500 : 键盘行
给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
美式键盘 中：
第一行由字符 "qwertyuiop" 组成。
第二行由字符 "asdfghjkl" 组成。
第三行由字符 "zxcvbnm" 组成。
https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/keyboard.png

示例 1：
输入：words = ["Hello","Alaska","Dad","Peace"]
输出：["Alaska","Dad"]

示例 2：
输入：words = ["omk"]
输出：[]

示例 3：
输入：words = ["adsdf","sfd"]
输出：["adsdf","sfd"]

提示：
1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] 由英文字母（小写和大写字母）组成
"""

first_line = {x for x in 'qwertyuiop'}
second_line = {x for x in 'asdfghjkl'}
third_line = {x for x in 'zxcvbnm'}


class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        result = list()
        for s in words:
            temp_set = {x for x in s.lower()}
            if len(temp_set.difference(first_line)) == 0:
                result.append(s)
            elif len(temp_set.difference(second_line)) == 0:
                result.append(s)
            elif len(temp_set.difference(third_line)) == 0:
                result.append(s)
        return result


words = ["Hello", "Alaska", "Dad", "Peace"]
solution = Solution()
print(solution.findWords(words))

"""
执行用时：20 ms, 在所有 Python 提交中击败了27.70%的用户
内存消耗：12.9 MB, 在所有 Python 提交中击败了73.65%的用户
通过测试用例：
22 / 22
"""
