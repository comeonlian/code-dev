#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : def_unordered_list.py
# @Time      : 2022/4/22 17:08
# @Author    : liang.lian

from chapter03.def_node import Node


class UnorderedList:
    def __init__(self, p_data):
        self.head = Node(p_data)
        self.len = 1

    def is_empty(self):
        return self.head is None

    def size(self):
        return self.len

    def add(self, p_data):
        item = Node(p_data)
        item.next = self.head
        self.head = item
        self.len += 1

    def search(self, p_data) -> bool:
        current = self.head
        while current is not None:
            if current.data == p_data:
                return True
            current = current.next
        return False

    def remove(self, p_data):
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
            previous.next = current.next
        self.len -= 1

    def print(self):
        current = self.head
        while current is not None:
            print(current.data, end=' ')
            current = current.next
