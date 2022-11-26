#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/26 16:27
# @Author  : lianliang
# @File    : demo_2_13.py

text = 'Hello World'
print(text.rjust(20, '='))
print(text.center(20, '*'))

print(format(text, '=>20s'))
print(format(text, '<20s'))
print(format(text, '*^20s'))
print('{:>10s} {:>10s}'.format('Hello', 'World'))

print(format(1.2345, '>10'))
print(format(1.2345, '^10.2f'))
