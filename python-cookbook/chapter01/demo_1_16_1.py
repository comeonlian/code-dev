#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 16:03
# @Author  : lianliang
# @File    : demo_1_16_1.py
from itertools import compress

address = [
    '5412 N CLARK',
    '5148 N CLARK',
    '5800 E 58TH',
    '2122 N CLARK',
    '5645 N RAVENSWOOD',
    '1060 W ADDISON',
    '4801 N BROADWAY',
    '1039 W GRANVILLE',
]
counts = [0, 3, 10, 4, 1, 7, 6, 1]

more5 = [n > 5 for n in counts]
res = list(compress(address, more5))
print(res)
