#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/16 16:29
# @Author  : lianliang
# @File    : par_checker_advanced.py

from chapter03.stack_code import Stack

'''
栈实现多括号匹配
'''


def par_checked(s: str) -> bool:
    if len(s) == 0:
        return True
    stack = Stack()
    for c in s:
        if c == '(' or c == '[' or c == '{':
            stack.push(c)
        else:
            if stack.size() == 0:
                return False
            peek = stack.peek()
            if peek == '(' and c == ')':
                stack.pop()
            elif peek == '[' and c == ']':
                stack.pop()
            elif peek == '{' and c == '}':
                stack.pop()
            else:
                return False
    return stack.size() == 0


print(par_checked('{{([][])}()}'))
print(par_checked('[{()]'))
