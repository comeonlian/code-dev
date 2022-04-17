#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/17 11:01
# @Author  : lianliang
# @File    : pro_3_8_divide_by_base.py

from chapter03.stack_code import Stack

'''
十进制转其他进制
'''

digits = '0123456789ABCDEF'


def base_convert(num: int, base: int) -> str:
    s = Stack()
    while num > 0:
        remain = num % base
        s.push(remain)
        num //= base
    res = ''
    while not s.is_empty():
        res += digits[s.pop()]
    return res


print(base_convert(num=233, base=2))
print(base_convert(num=233, base=8))
print(base_convert(num=233, base=16))
