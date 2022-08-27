#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 12:50
# @Author  : lianliang
# @File    : demo_1_15.py
import itertools
import operator

rows = [
    {'address': '5412 N CLARK', 'date': '07/01/2012'},
    {'address': '5148 N CLARK', 'date': '07/04/2012'},
    {'address': '5800 E 58TH', 'date': '07/02/2012'},
    {'address': '2122 N CLARK', 'date': '07/03/2012'},
    {'address': '5645 N RAVENSWOOD', 'date': '07/02/2012'},
    {'address': '1060 W ADDISON', 'date': '07/02/2012'},
    {'address': '4801 N BROADWAY', 'date': '07/01/2012'},
    {'address': '1039 W GRANVILLE', 'date': '07/04/2012'},
]

rows.sort(key=operator.itemgetter('date'))

for date, items in itertools.groupby(rows, key=operator.itemgetter('date')):
    print(date)
    for item in items:
        print(' ', item)
