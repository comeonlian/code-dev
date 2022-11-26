#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/26 17:15
# @Author  : lianliang
# @File    : demo_2_15.py
import sys


class safesub(dict):
    def __missing__(self, key):
        return '{' + key + '}'


def sub(text):
    return text.format_map(safesub(sys._getframe(1).f_locals))


name = 'Guido'
n = 37

s = '{name} has {n} messages.'

print(s.format(name=name, n=n))
print(s.format_map(vars()))

print(sub('Hello {name}'))
print(sub('Your favorite color is {color}'))
