#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/17 18:28
# @Author  : lianliang
# @File    : pro_3_9_infix_to_split.py

"""
中缀表达式转换
将中缀表达式转换为带空格的字符串表达式
"""


def infix_to_split(infix: str) -> str:
    result = ''
    num_str = ''
    for token in infix:
        if token in '0123456789':
            num_str += token
        else:
            if len(num_str) > 0:
                result = result + num_str + ' '
            result = result + token + ' '
            num_str = ''
    if len(num_str) > 0:
        result = result + num_str
        num_str = ''
    return str.strip(result)


if __name__ == '__main__':
    print(infix_to_split('(966+48)*6888'))
    print(infix_to_split('(966+48)*(6888-1888)'))
