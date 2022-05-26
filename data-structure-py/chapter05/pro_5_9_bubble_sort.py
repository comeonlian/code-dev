#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_5_9_bubble_sort.py
# @Time      : 2022/5/26 16:45
# @Author    : liang.lian

def bubble_sort(alist):
    for passnum in range(len(alist) - 1, 0, -1):
        for i in range(passnum):
            if alist[i] > alist[i + 1]:
                alist[i], alist[i + 1] = alist[i + 1], alist[i]

alist = [54, 26, 93, 17, 77, 31, 44, 55, 20]
bubble_sort(alist)
print(alist)