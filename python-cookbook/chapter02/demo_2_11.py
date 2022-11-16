#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : demo_2_11.py
# @Time      : 2022/11/16 15:50
# @Author    : liang.lian
import re

s = ' hello world  \n'
print(s.strip())
print(s.lstrip())
print(s.rstrip())
print('-------------------------')
t = '-------hello========'
print(t.lstrip('-'))
print(t.strip('-='))

print('-------------------------')
y = ' hello     world \n'
print(s.replace(' ', ''))
print(re.sub('\s+', '_', s))
