#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 10:33
# @Author  : lianliang
# @File    : demo_1_9_1.py

def dedupe_mul(items, key=None):
    seen = set()
    for item in items:
        val = item if key is None else key(item)
        if val not in seen:
            yield item
            seen.add(val)


a = [{'x': 1, 'y': 2}, {'x': 1, 'y': 3}, {'x': 1, 'y': 5}, {'x': 2, 'y': 4}]
r = list(dedupe_mul(a, key=lambda d: (d['x'], d['y'])))

print(r)
