#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/26 17:36
# @Author  : lianliang
# @File    : demo_2_17.py
import html
from xml.sax.saxutils import unescape

s = 'Elements are written as "<tag>text</tag>".'
print(html.escape(s, quote=False))

s = 'Spicy &quot;Jalape&#241;o&quot.'
print(html.unescape(s))

t = 'The prompt is &gt;&gt;&gt;'
print(unescape(t))