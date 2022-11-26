#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/26 16:54
# @Author  : lianliang
# @File    : demo_2_14_1.py

def sample():
    yield 'Is'
    yield 'Chicago'
    yield 'Not'
    yield 'Chicago?'


def combine(source, maxsize):
    parts = []
    size = 0
    for part in source:
        parts.append(part)
        size += len(part)
        if size > maxsize:
            yield ','.join(parts)
            parts = []
            size = 0
    yield ','.join(parts)


with open('output.txt', 'w') as f:
    for part in combine(sample(), 32798):
        f.write(part)
