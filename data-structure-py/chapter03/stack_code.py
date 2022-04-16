#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/16 15:43
# @Author  : lianliang
# @File    : stack_code.py

class Stack:
    def __init__(self):
        self.items = []
        self.len = 0
    
    def is_empty(self):
        return self.len == 0
    
    def push(self, item):
        self.len += 1
        self.items.append(item)
    
    def pop(self):
        self.len -= 1
        return self.items.pop()
    
    def peek(self):
        return self.items[self.len - 1]
    
    def size(self):
        return self.len

if __name__ == '__main__':
    s = Stack()
    
    print(s.is_empty())
    s.push(4)
    s.push('dog')
    print(s.peek())
    s.push(True)
    print(s.size())
    print(s.is_empty())
    s.push(8.4)
    print(s.pop())
    print(s.pop())
    print(s.size())

