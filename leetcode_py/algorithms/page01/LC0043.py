#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : LC0043.py
# @Time      : 2022/3/21 17:29
# @Author    : liang.lian

"""
LC 43 : 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。

提示：
1 <= num1.length, num2.length <= 200
num1 和 num2 只能由数字组成。
num1 和 num2 都不包含任何前导零，除了数字0本身。

示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"
"""

class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == '0' or num2 == '0':
            return '0'
        sum_res, power = '0', 0
        for n in ''.join(reversed(num2)):
            multi_res = self.multi(num1, n)
            if power != 0:
                index = 0
                while index < power:
                    multi_res = multi_res + '0'
                    index += 1
            sum_res = self.add(sum_res, multi_res)
            power += 1
        return sum_res
    
    def multi(self, num1: str, num2: str) -> str:
        result = []
        num1_r = ''.join(reversed(num1))
        n2, index, carry = ord(num2) - 48, 0, 0
        while index < len(num1_r):
            n1 = ord(num1_r[index]) - 48
            total = (n1 * n2) + carry
            carry = 0
            if total >= 10:
                carry = total // 10
                result.insert(0, str(total % 10))
            else:
                result.insert(0, str(total))
            index = index + 1
        if carry != 0:
            result.insert(0, str(carry))
        return ''.join(result)
    
    def add(self, num1: str, num2: str) -> str:
        result = []
        num1_r, num2_r = ''.join(reversed(num1)), ''.join(reversed(num2))
        index, carry = 0, 0
        while index < len(num1_r) or index < len(num2_r):
            n1, n2 = 0, 0
            if index < len(num1_r):
                n1 = ord(num1_r[index]) - 48
            if index < len(num2_r):
                n2 = ord(num2_r[index]) - 48
            total = n1 + n2 + carry
            carry = 0
            if total >= 10:
                carry = 1
                result.insert(0, str(total - 10))
            else:
                result.insert(0, str(total))
            index = index + 1
        if carry != 0:
            result.insert(0, str(carry))
        return ''.join(result)

"""
执行用时：340 ms, 在所有 Python3 提交中击败了5.44%的用户
内存消耗：15.1 MB, 在所有 Python3 提交中击败了25.27%的用户
"""