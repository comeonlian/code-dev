#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/10/1 21:30
# @Author  : lianliang
# @File    : demo_2_5.py
import re
from calendar import month_abbr

text = "yeah, but no, but yeah, but no, but yeah"
print(text.replace('yeah', 'yep'))

text = "Today is 11/27/2012. PyCon starts 3/13/2013."
datepat = re.compile(r'(\d+)/(\d+)/(\d+)')
print(datepat.sub(r'\3-\1-\2', text))
result, n = datepat.subn(r'\3-\1-\2', text)
print(result, n)


def change_date(m):
    mon_name = month_abbr[int(m.group(1))]
    return '{} {} {}'.format(m.group(2), mon_name, m.group(3))


print(datepat.sub(change_date, text))
