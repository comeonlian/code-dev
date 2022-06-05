#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/6/5 17:54
# @Author  : lianliang
# @File    : pro_5_14_merge_sort.py

def merge_sort(a_list):
    if len(a_list) > 1:
        mid = len(a_list) // 2
        left_half, right_half = a_list[:mid], a_list[mid:]

        merge_sort(left_half)
        merge_sort(right_half)

        # 合并两个有序列表
        i, j, k = 0, 0, 0
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                a_list[k], i, k = left_half[i], i + 1, k + 1
            else:
                a_list[k], j, k = right_half[j], j + 1, k + 1

        while i < len(left_half):
            a_list[k], i, k = left_half[i], i + 1, k + 1

        while j < len(right_half):
            a_list[k], j, k = right_half[j], j + 1, k + 1


a_list = [54, 26, 93, 17, 77, 31, 44, 55, 20]
merge_sort(a_list)
print(a_list)
