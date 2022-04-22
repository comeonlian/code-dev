#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/17 18:17
# @Author  : lianliang
# @File    : pro_3_9_postfix_eval.py

from pro_3_9_infix_to_split import infix_to_split
from pro_3_9_infix_to_postfix import infix_to_postfix
from def_stack import Stack

'''
后缀表达式求值
1）创建一个名为 operandStack 的空栈
2）拆分字符串转换为标记列表
3）从左到右扫描标记列表：
    ①、如果标记是操作数，将其从字符串转换为整数，并将值压到 operandStack
    ②、如果标记是运算符*，/，+或-，它将需要两个操作数，弹出 operandStack 两次，第一个弹出的是第二个操作数，
        第二个弹出的是第一个操作数，执行算术运算后，将结果压到操作数栈中
4）当输入的表达式被完全处理后，结果就在栈上，弹出 operandStack 并返回值
'''


def postfix_eval(postfix_param: list) -> int:
    s = Stack()
    for token in postfix_param:
        if str.isnumeric(token):
            s.push(token)
        else:
            num2 = int(s.pop())
            num1 = int(s.pop())
            if token == '+':
                s.push(num1 + num2)
            elif token == '-':
                s.push(num1 - num2)
            elif token == '*':
                s.push(num1 * num2)
            elif token == '/':
                s.push(num1 / num2)
    return s.pop()


infix = infix_to_split('(66+88)*(99-55)')
postfix = infix_to_postfix(infix)
print(postfix_eval(postfix))
