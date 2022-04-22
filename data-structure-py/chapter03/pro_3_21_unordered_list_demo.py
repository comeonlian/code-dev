#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_3_21_unordered_list_demo.py
# @Time      : 2022/4/22 17:31
# @Author    : liang.lian

from chapter03.def_unordered_list import UnorderedList


unordered_list = UnorderedList(2)
unordered_list.add('a')
unordered_list.add(5.33)
unordered_list.add('k')
unordered_list.add(10)
unordered_list.print()
print()
print(unordered_list.search('k'))
print(unordered_list.is_empty())
print(unordered_list.size())
unordered_list.remove(5.33)
unordered_list.print()

