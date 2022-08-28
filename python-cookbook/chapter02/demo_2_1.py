#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/28 16:51
# @Author  : lianliang
# @File    : demo_2_1.py
import re

line = 'asdf fjdk; afed, fjek,asdf, foo'
arr = re.split(r'[;,\s]\s*', line)
print(arr)

arr = re.split(r'(;|,|\s)\s*', line)
print(arr)
