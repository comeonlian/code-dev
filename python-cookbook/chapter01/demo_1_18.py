#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 21:00
# @Author  : lianliang
# @File    : demo_1_18.py
import collections

Stock = collections.namedtuple('Stock', ['name', 'shares', 'price'])


def compute_cost(records):
    total = 0.0
    for rec in records:
        s = Stock(**rec)
        total += s.shares * s.price
    return total


arr = [
    {'name': 'ACME', 'shares': 100, 'price': 123.45},
    {'name': 'ACME', 'shares': 100, 'price': 123.45},
]

print(compute_cost(arr))
