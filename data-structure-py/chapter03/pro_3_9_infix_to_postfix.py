#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/17 12:50
# @Author  : lianliang
# @File    : pro_3_9_infix_to_postfix.py

from chapter03.def_stack import Stack

'''
中缀表达式转后缀表达式
中缀表达式是一个由空格分隔的标记字符串，操作符标记是*，/，+和 - ，以及左右括号，操作数是单字符 A，B，C
1）创建一个名为 opstack 的空栈以保存运算符，给输出创建一个空列表
2）通过使用字符串方法拆分将输入的中缀字符串转换为标记列表
3）从左到右扫描标记列表：
    ①、如果标记是操作数，将其附加到输出列表的末尾
    ②、如果标记是左括号，将其压到 opstack 上
    ③、如果标记是右括号，则弹出 opstack，直到删除相应的左括号，将每个运算符附加到输出列表的末尾
    ④、如果标记是运算符，*，/，+或 - ，将其压入 opstack，但是首先删除已经在 opstack 中具有更高或相等优先级的任何运算符，
        并将它们加到输出列表中
4）当输入表达式被完全处理时，检查 opstack，仍然在栈上的任何运算符都可以删除并加到输出列表的末尾
'''

prec = {'+': 2, '-': 2, '*': 3, '/': 3}


def infix_to_postfix(infix: str) -> list:
    s = Stack()
    result = []
    token_list = infix.split()
    for token in token_list:
        if token in '+-*/':
            while not s.is_empty() and s.peek() != '(' and prec[s.peek()] >= prec[token]:
                result.append(s.pop())
            s.push(token)
        elif token == '(':
            s.push(token)
        elif token == ')':
            while not s.is_empty() and s.peek() != '(':
                result.append(s.pop())
            s.pop()
        else:
            result.append(token)
    while not s.is_empty():
        result.append(s.pop())
    return result


if __name__ == '__main__':
    print(infix_to_postfix('( A + B ) * ( C + D )'))
    print(infix_to_postfix('( A + B ) * C'))
    print(infix_to_postfix('A + B * C'))
    print(infix_to_postfix('( 966 + 48 ) * 6888'))
    print(infix_to_postfix('( 966 + 48 ) * ( 6888 - 1888 )'))
