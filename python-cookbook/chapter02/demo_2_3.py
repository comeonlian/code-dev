#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/28 17:18
# @Author  : lianliang
# @File    : demo_2_3.py
import fnmatch

print(fnmatch.fnmatch('foo.txt', '*.txt'))
print(fnmatch.fnmatch('foo.txt', '?oo.txt'))
print(fnmatch.fnmatch('Dat45.csv', 'Dat[0-9]'))

names = ['Dat1.csv', 'Dat2.csv', 'config.ini', 'foo.py']
r = [name for name in names if fnmatch.fnmatch(name, 'Dat*.csv')]
print(r)

addresses = [
    '5412 N CLARK ST',
    '1060 W ADDISON ST',
    '1039 W GRANVILLE AVE',
    '2122 N CLARK ST',
    '4802 N BROADWAY',
]
r = [addr for addr in addresses if fnmatch.fnmatch(addr, '* ST')]
print(r)
r = [addr for addr in addresses if fnmatch.fnmatch(addr, '54[0-9][0-9] *CLARK*')]
print(r)
