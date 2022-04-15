#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/4/15 22:47
# @Author  : lianliang
# @File    : list_code.py

from timeit import Timer

popend = Timer("x.pop()", "from __main__ import x")
popzero = Timer("x.pop(0)", "from __main__ import x")

print("pop(0) pop()")

for i in range(1000000, 100000001, 1000000):
    x = list(range(i))
    pt = popend.timeit(number=1000)
    x = list(range(i))
    pz = popzero.timeit(number=1000)
    print("%15.5f, %15.5f" % (pz, pt))
