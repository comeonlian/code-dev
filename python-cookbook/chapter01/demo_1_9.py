#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 10:22
# @Author  : lianliang
# @File    : demo_1_9.py

def dedupe(items):
    seen = set()
    for item in items:
        if item not in seen:
            yield item
            seen.add(item)


arr = [1, 5, 2, 1, 9, 1, 5, 10]
res = list(dedupe(items=arr))

print(res)
