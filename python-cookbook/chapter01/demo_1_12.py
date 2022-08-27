#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 11:10
# @Author  : lianliang
# @File    : demo_1_12.py
from collections import Counter

words = ['look', 'into', 'my', 'eyes', 'look', 'into', 'my', 'eyes',
         'the', 'eyes', 'the', 'eyes', 'the', 'eyes', 'not', 'around', 'the',
         'eyes', "don't", 'look', 'around', 'the', 'eyes', 'look', 'into',
         'my', 'eyes', "you're", 'under']

word_counts = Counter(words)
top_three = word_counts.most_common(3)  # 出现频率最高的3个单词

print(top_three)

# 数学运算
morewords = ['why', 'are', 'you', 'not', 'looking', 'in', 'my', 'eyes']

a = Counter(words)
b = Counter(morewords)

c = a + b
print(c)
print(c.most_common(3))

d = a - b
print(d)
print(d.most_common(3))

