#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 12:13
# @Author  : lianliang
# @File    : demo_1_13.py
from operator import itemgetter

rows = [
    {'fname': 'Brian', 'lname': 'Jones', 'uid': 1003},
    {'fname': 'David', 'lname': 'Beazley', 'uid': 1002},
    {'fname': 'John', 'lname': 'Cleese', 'uid': 1001},
    {'fname': 'Big', 'lname': 'Jones', 'uid': 1004}
]

rows_by_name = sorted(rows, key=itemgetter('fname'))
print(rows_by_name)

rows_by_uid = sorted(rows, key=itemgetter('uid'))
print(rows_by_uid)

rows_by_lname_fname = sorted(rows, key=itemgetter('lname', 'fname'))
print(rows_by_lname_fname)
