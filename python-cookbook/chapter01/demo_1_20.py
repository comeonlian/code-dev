#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 21:29
# @Author  : lianliang
# @File    : demo_1_20.py
import collections

a = {'x': 1, 'z': 3}
b = {'y': 2, 'z': 4}

c = collections.ChainMap(a, b)

print(c['x'])  # Outputs 1 (from a)
print(c['y'])  # Outputs 2 (from b)
print(c['z'])  # Outputs 3 (from a)

print(len(c))
print(list(c.keys()))
print(list(c.values()))
