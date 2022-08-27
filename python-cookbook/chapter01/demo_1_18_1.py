#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 21:11
# @Author  : lianliang
# @File    : demo_1_18_1.py
import collections

Stock = collections.namedtuple('Stock', ['name', 'shares', 'price', 'date', 'time'])

stock_prototype = Stock('', 0, 0.0, None, None)


def dict_to_stock(s):
    return stock_prototype._replace(**s)


a = {'name': 'ACME', 'shares': 100, 'price': 123.45}
r = dict_to_stock(a)
print(r)

b = {'name': 'ACME', 'shares': 100, 'price': 123.45, 'date': '12/17/2012'}
r = dict_to_stock(b)
print(r)
