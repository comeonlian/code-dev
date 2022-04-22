#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_3_18_pal_checker.py
# @Time      : 2022/4/22 15:15
# @Author    : liang.lian

"""
回文检查
输入一个字符串，并检查它是否是一个回文
从左到右处理字符串，并将每个字符添加到 deque 的尾部，可以直接删除并比较首尾字符，只有当它们匹配时才继续
"""

from chapter03.def_deque import Deque


def pal_checker(param: str) -> bool:
    deque = Deque()
    for s in param:
        deque.add_rear(s)
    while deque.size() > 1:
        front = deque.remove_front()
        rear = deque.remove_rear()
        if front != rear:
            return False
    return deque.size() <= 1


print(pal_checker("lsdkjfskf"))
print(pal_checker("raddar"))
