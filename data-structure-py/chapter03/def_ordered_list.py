#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : def_unordered_list.py
# @Time      : 2022/4/22 17:08
# @Author    : liang.lian

from chapter03.def_node import Node


class OrderedList:
    def __init__(self, p_data: int):
        self.head = Node(p_data)
        self.len = 1

    def is_empty(self):
        return self.head is None

    def size(self):
        return self.len

    def add(self, p_data: int):
        item = Node(p_data)
        previous = None
        current = self.head
        while current is not None and p_data >= current.data:
            previous = current
            current = current.next
        if previous is None:
            self.head = item
            item.next = current
        else:
            previous.next = item
            item.next = current
        self.len += 1

    def search(self, p_data: int) -> bool:
        current = self.head
        while current is not None:
            if current.data == p_data:
                return True
            elif current.data > p_data:
                break
        return False

    def remove(self, p_data: int):
        previous = Node
        current = self.head
        while current is not None:
            if current.data == p_data:
                break
            previous = current
            current = current.next
        if previous is None:
            self.head = self.head.next
        else:
            if current is not None:
                previous.next = current.next
        self.len -= 1

    def print(self):
        current = self.head
        while current is not None:
            print(current.data, end=' ')
            current = current.next
