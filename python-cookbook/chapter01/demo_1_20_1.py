#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 21:33
# @Author  : lianliang
# @File    : demo_1_20_1.py
import collections

values = collections.ChainMap()

values['x'] = 1
print(values)

values = values.new_child()
values['x'] = 2
print(values)

values = values.parents
print(values)
