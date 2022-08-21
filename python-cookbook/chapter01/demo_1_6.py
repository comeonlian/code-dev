#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/21 21:27
# @Author  : lianliang
# @File    : demo_1_6.py
from collections import defaultdict

d = defaultdict(list)
d['a'].append(1)
d['a'].append(2)
d['b'].append(4)

ds = defaultdict(set)
ds['a'].add(1)
ds['a'].add(2)
ds['b'].add(4)

print(d)
print(ds)

dc = {}  # 一个普通的字典
dc.setdefault('a', []).append(1)
dc.setdefault('a', []).append(2)
dc.setdefault('b', []).append(4)

print(dc)
