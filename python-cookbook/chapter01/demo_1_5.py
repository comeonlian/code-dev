#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/21 17:59
# @Author  : lianliang
# @File    : demo_1_5.py
import heapq


class PriorityQueue:
    def __init__(self):
        self._queue = []
        self._index = 0

    def push(self, item, priority):
        heapq.heappush(self._queue, (-priority, self._index, item))
        self._index += 1

    def pop(self):
        return heapq.heappop(self._queue)[-1]


class Item:
    def __init__(self, name):
        self._name = name

    def __repr__(self):
        return 'Item({!r})'.format(self._name)


if __name__ == '__main__':
    q = PriorityQueue()
    q.push(Item('foo'), 1)
    q.push(Item('bar'), 5)
    q.push(Item('spam'), 4)
    q.push(Item('grok'), 1)
    
    print(q.pop())
    print(q.pop())
    print(q.pop())
    print(q.pop())
