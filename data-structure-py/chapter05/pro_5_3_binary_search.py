#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_5_3_binary_search.py
# @Time      : 2022/5/26 10:23
# @Author    : liang.lian

def binary_search(alist, item):
    first = 0
    last = len(alist) - 1
    found = False
    
    while first <= last and not found:
        midpoint = (first + last) // 2
        if alist[midpoint] == item:
            found = True
        else:
            if item < alist[midpoint]:
                last = midpoint - 1
            else:
                first = midpoint + 1
    return found


print(binary_search([17, 20, 26, 31, 44, 54, 55, 65, 77, 93], 56))