#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/22 20:56
# @Author  : lianliang
# @File    : pro_4_5_int_to_str.py

"""
整数转换为任意进制字符串
看一个十进制数 769 的具体示例。假设我们有一个对应于前 10 位数的字符序列，例如 convString =“0123456789”。 
通过在序列中查找，很容易将小于 10 的数字转换为其等效的字符串。
如果数字为 9 ，则字符串为 convString[9] 或 “9”。如果我们将数字 769 分成三个单个位数字，7，6 和 9，那么将其转换为字符串很简单。
使用整数除法将 769 除以 10 ，我们得到 76，余数为 9。这给了我们两个好的结果。首先，余数是小于我们的基数的数字，
可以通过查找立即转换为字符串。第二，我们得到的商小于原始数字，并让我们靠近具有小于基数的单个数字的基本情况。
现在我们的工作是将 76 转换为其字符串表示。再次，我们使用商和余数分别获得 7 和 6 的结果。
最后，我们将问题减少到转换 7，我们可以很容易地做到，因为它满足 n < base 的基本条件，其中 base = 10
"""

CONVERT_STR = '0123456789ABCDEF'


def to_str(num: int, base: int) -> str:
    if num < base:
        return CONVERT_STR[num]
    return to_str(num // base, base) + CONVERT_STR[num % base]


print(to_str(10, 2))
print(to_str(32, 2))
print(to_str(32, 16))
print(to_str(768, 10))
print(to_str(1478, 16))
