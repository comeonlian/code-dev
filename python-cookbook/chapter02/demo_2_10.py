#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : demo_2_10.py
# @Time      : 2022/11/15 11:32
# @Author    : liang.lian
import re

pat1 = re.compile('\d+')
print(pat1.match('124'))
print(pat1.match('\u0661\u0662\u0663'))

pat2 = re.compile('stra\u00afe', re.IGNORECASE)
s = 'straße'
print(pat2.match(s))
print(pat2.match(s.upper()))
