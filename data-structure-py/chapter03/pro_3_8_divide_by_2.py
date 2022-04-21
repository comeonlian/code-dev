#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/17 10:49
# @Author  : lianliang
# @File    : pro_3_8_divide_by_2.py

from chapter03.def_stack import Stack

'''
十进制转换成二进制
'''


def divide_by_2(num: int) -> str:
    s = Stack()
    while num > 0:
        remain = num % 2
        s.push(remain)
        num //= 2
    res = ''
    while not s.is_empty():
        res += str(s.pop())
    return res


print(divide_by_2(8))
print(divide_by_2(233))
