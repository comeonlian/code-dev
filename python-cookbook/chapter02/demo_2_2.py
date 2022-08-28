#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/28 17:01
# @Author  : lianliang
# @File    : demo_2_2.py

filenames = ['Makefile', 'foo.c', 'bar.py', 'spam.c', 'spam.h']
a1 = [name for name in filenames if name.endswith(('.c', '.h'))]
a2 = any([name.endswith('.py') for name in filenames])
print(a1)
print(a2)

choices = ['http:', 'ftp:']
url = 'http://www.python.org'
print(url.startswith(tuple(choices)))
