#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/22 21:17
# @Author  : lianliang
# @File    : pro_4_6_int_to_str_stack.py

from chapter03.def_stack import Stack

"""
整数转换为任意进制字符串
在此示例中通过栈实现整数转任意进制
"""

CONVERT_STR = '0123456789ABCDEF'


def to_str(num: int, base: int) -> str:
    stack = Stack()
    while num > 0:
        if num < base:
            stack.push(CONVERT_STR[num])
        else:
            stack.push(CONVERT_STR[num % base])
        num = num // base
    result = ''
    while stack.size() > 0:
        result = result + stack.pop()
    return result


print(to_str(10, 2))
print(to_str(32, 2))
print(to_str(32, 16))
print(to_str(768, 10))
print(to_str(1478, 16))
