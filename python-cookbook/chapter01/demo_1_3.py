#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/21 11:00
# @Author  : lianliang
# @File    : demo_1_3.py
from collections import deque


def search(lines, pattern, history=5):
    previous_lines = deque(maxlen=history)
    for line in lines:
        if pattern in line:
            yield line, previous_lines
        previous_lines.append(line)


if __name__ == '__main__':
    with open(r'./somefile.txt') as f:
        for line, prevlines in search(f, 'python', 5):
            for pline in prevlines:
                print(pline, end='')
            print(line, end='')
            print('-' * 20)
# 包含 yield 关键字，就变成了生成器函数
def foo():
    print('Starting.....')
    while True:
        res = yield 4
        print("res:", res)

