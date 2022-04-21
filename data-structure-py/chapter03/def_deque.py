#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @Time      : 2022/4/21 19:48
# @Author    : liang.lian
# @FileName  : def_deque.py

class Deque:
    
    def __init__(self):
        self.items = []
        self.len = 0
    
    def is_empty(self):
        return self.len == 0
    
    def size(self):
        return self.len
    
    def add_front(self, item):
        self.len += 1
        self.items.append(item)
        
    def remove_front(self):    
        self.len -= 1
        self.items.pop()
    
    def add_rear(self, item):
        self.len += 1
        self.items.insert(0, item)
    
    def remove_rear(self):
        self.len -= 1
        self.items.pop(0)
    
