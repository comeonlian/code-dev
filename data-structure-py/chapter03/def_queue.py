#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/20 22:03
# @Author  : lianliang
# @File    : def_queue.py

class Queue:
    def __init__(self):
        self.items = []
        self.len = 0

    def is_empty(self):
        return self.len == 0

    def enqueue(self, item):
        self.items.insert(0, item)
        self.len += 1

    def dequeue(self):
        self.len -= 1
        return self.items.pop()

    def size(self):
        return self.len


if __name__ == '__main__':
    queue = Queue()
    queue.enqueue(66)
    queue.enqueue('ss')
    print(queue.is_empty())
    print(queue.dequeue())
    print(queue.size())
    queue.enqueue(9.99)
    print(queue.size())
