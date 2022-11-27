#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/27 13:57
# @Author  : lianliang
# @File    : demo_3_3.py

x = 1234.56789
print(format(x, '>10.1f'))
print(format(x, '^10.1f'))
print(format(x, ','))
print(format(x, '0,.2f'))
print(format(x, 'e'))
print(format(x, '0.2E'))
print('The value is {:20,.2f}'.format(x))
