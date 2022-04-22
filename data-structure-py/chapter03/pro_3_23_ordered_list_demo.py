#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_3_21_unordered_list_demo.py
# @Time      : 2022/4/22 17:31
# @Author    : liang.lian

from chapter03.def_ordered_list import OrderedList

ordered_list = OrderedList(11)
ordered_list.add(6)
ordered_list.add(9)
ordered_list.add(22)
ordered_list.add(88)
ordered_list.print()
print()
print(ordered_list.is_empty())
print(ordered_list.size())
ordered_list.remove(11)
ordered_list.print()
