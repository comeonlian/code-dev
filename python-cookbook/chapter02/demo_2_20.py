#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/26 19:17
# @Author  : lianliang
# @File    : demo_2_20.py
import re

data = b'Hello World'
print(data[0:5])
print(data.startswith(b'Hello'))
print(data.split())

data = bytearray(b'Hello World')
print(data[0:5])
print(data.replace(b'Hello', b'Hello Cruel'))

data = b'FOO:BAR,SPAM'
print(re.split(b'[:,]', data))
