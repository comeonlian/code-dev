#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_5_11_selection_sort.py
# @Time      : 2022/5/26 17:14
# @Author    : liang.lian

def selection_sort(alist):
    for fill_slot in range(len(alist) - 1, 0, -1):
        position_of_max = 0
        for location in range(1, fill_slot + 1):
            if alist[location] > alist[position_of_max]:
                position_of_max = location
        alist[fill_slot], alist[position_of_max] = alist[position_of_max], alist[fill_slot]


alist = [54, 26, 93, 17, 77, 31, 44, 55, 20]
selection_sort(alist)
print(alist)
