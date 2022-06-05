#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/6/5 11:32
# @Author  : lianliang
# @File    : pro_5_13_shell_sort.py

def shell_sort(a_list):
    sub_list_step = len(a_list) // 2
    while sub_list_step > 0:
        for start_position in range(sub_list_step):
            gap_insertion_sort(a_list, start_position, sub_list_step)
        print("After increments of size: ", sub_list_step, "The list is: ", a_list)
        sub_list_step = sub_list_step // 2


def gap_insertion_sort(a_list, start, step):
    for i in range(start + step, len(a_list), step):
        current_value = a_list[i]
        position = i
        while position >= step and a_list[position - step] > current_value:
            a_list[position] = a_list[position - step]
            position = position - step
        a_list[position] = current_value


a_list = [54, 26, 93, 17, 77, 31, 44, 55, 20]
shell_sort(a_list)
print(a_list)
