#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/16 16:15
# @Author  : lianliang
# @File    : pro_3_6_par_checker.py

from chapter03.def_stack import Stack

'''
栈实现小括号匹配
'''


def par_checker(param: str) -> bool:
    if len(param) == 0:
        return True
    stack = Stack()
    for c in param:
        if c == '(':
            stack.push(c)
        else:
            if stack.size() == 0:
                return False
            stack.pop()

    return stack.size() == 0


print(par_checker("()()"))
print(par_checker("(()()(()"))
print(par_checker("(())))))))))))"))
