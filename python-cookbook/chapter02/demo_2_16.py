#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/26 17:29
# @Author  : lianliang
# @File    : demo_2_16.py
import textwrap

s = "Look into my eyes, look into my eyes, the eyes, the eyes, \
the eyes, not around the eyes, don't look around the eyes, \
look into my eyes, you're under."

print(textwrap.fill(s, 70))
print(textwrap.fill(s, 40))
print(textwrap.fill(s, 40, initial_indent='      '))
print(textwrap.fill(s, 40, subsequent_indent='      '))
