#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/10/2 15:32
# @Author  : lianliang
# @File    : demo_2_7.py
import re

text = 'Computer says "no." Phone says "yes."'

str_pat = re.compile(r'"(.*)"')

print(str_pat.findall(text))

str_pat1 = re.compile(r'"(.*?)"')
print(str_pat1.findall(text))
