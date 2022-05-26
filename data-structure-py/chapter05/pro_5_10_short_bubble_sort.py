#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_5_10_short_bubble_sort.py
# @Time      : 2022/5/26 16:11
# @Author    : liang.lian

def short_bubble_sort(alist):
    exchanges = True
    passnum = len(alist) - 1
    while passnum > 0 and exchanges:
        exchanges = False
        for i in range(passnum):
            if alist[i] > alist[i + 1]:
                exchanges = True
                alist[i], alist[i + 1] = alist[i + 1], alist[i]
        passnum -= 1

alist = [54, 26, 93, 17, 77, 31, 44, 55, 20]
short_bubble_sort(alist)
print(alist)