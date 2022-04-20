#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/20 22:32
# @Author  : lianliang
# @File    : pro_3_13_hot_potato.py

from queue_code import Queue
"""
模拟：烫手山芋
在这个游戏中孩子们围成一个圈，并尽可能快的将一个山芋递给旁边的孩子。在某一个时间，动作结束，有山芋的孩子从圈中移除。
游戏继续开始直到剩下最后一个孩子。
模拟这个烫山芋的过程，程序将输入名称列表和一个称为 num 常量用于报数。它将返回以 num 为单位重复报数后剩余的最后一个人的姓名
为了模拟这个圈，使用队列。假设拿着山芋的孩子在队列的前面。当拿到山芋的时候，这个孩子将先出列再入队列，把他放在队列的最后。
经过 num 次的出队入队后，前面的孩子将被永久移除队列。并且另一个周期开始，继续此过程，直到只剩下一个名字（队列的大小为 1）
"""


def hot_potato(names: list, num: int) -> str:
    queue = Queue()
    for name in names:
        queue.enqueue(name)
    while queue.size() > 1:
        for cnt in range(num):
            queue.enqueue(queue.dequeue())
        queue.dequeue()
    return queue.dequeue()


# print(hot_potato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 7))
# print(hot_potato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 6))
# print(hot_potato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 5))
# print(hot_potato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 4))
# print(hot_potato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 3))
# print(hot_potato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 2))
print(hot_potato(["Bill", "David", "Susan", "Jane", "Kent", "Brad"], 1))
