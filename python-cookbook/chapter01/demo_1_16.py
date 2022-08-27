#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 15:55
# @Author  : lianliang
# @File    : demo_1_16.py

def is_int(val):
    try:
        x = int(val)
        return True
    except ValueError:
        return False


values = ['1', '2', '-3', '-', '4', 'N/A', '5']
int_vals = list(filter(is_int, values))
print(int_vals)
