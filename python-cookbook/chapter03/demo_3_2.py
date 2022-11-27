#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/27 12:41
# @Author  : lianliang
# @File    : demo_3_2.py
from decimal import Decimal, localcontext

a = Decimal('1.3')
b = Decimal('1.7')
print(a + b)

with localcontext() as ctx:
    # ctx.prec = 3
    ctx.prec = 30
    print(a / b)
