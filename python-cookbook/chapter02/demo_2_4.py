#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : demo_2_4.py
# @Time      : 2022/9/26 19:28
# @Author    : liang.lian
import re

text1 = "11/27/2012"
text2 = "Nov 27, 2012"
text3 = 'Today is 11/27/2012. PyCon starts 3/13/2013.'

datepat = re.compile(r'\d+/\d+/\d+')

if datepat.match(text1):
    print('yes')
else:
    print('no')

if datepat.match(text2):
    print('yes')
else:
    print('no')

datepat1 = re.compile(r'(\d+)(/\d+)(/\d+)')
print(datepat1.findall(text3))

for m in datepat1.finditer(text3):
    print(m.groups())