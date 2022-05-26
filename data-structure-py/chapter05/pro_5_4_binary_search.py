#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_5_4_binary_search.py
# @Time      : 2022/5/26 10:30
# @Author    : liang.lian

def binary_search(alist, item):
    if len(alist) == 0:
        return False
    else:
        midpoint = len(alist) // 2
        if alist[midpoint] == item:
            return True
        else:
            if item < alist[midpoint]:
                return binary_search(alist[:midpoint], item)
            else:
                return binary_search(alist[midpoint + 1:], item)


print(binary_search([17, 20, 26, 31, 44, 54, 55, 65, 77, 93], 77))