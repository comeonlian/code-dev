#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : def_node.py
# @Time      : 2022/4/22 17:03
# @Author    : liang.lian

class Node:
    def __init__(self, p_data: int):
        self.data = p_data
        self.next = None

    def get_data(self):
        return self.data

    def get_next(self):
        return self.next

    def set_data(self, p_data: int):
        self.data = p_data

    def set_next(self, p_next):
        self.next = p_next
