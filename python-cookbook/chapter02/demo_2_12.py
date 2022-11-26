#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/11/26 16:11
# @Author  : lianliang
# @File    : demo_2_12.py
import sys
import unicodedata

cmb_chr = dict.fromkeys(c for c in range(sys.maxunicode)
                        if unicodedata.combining(chr(c)))

a = 'pýtĥöñ is awesome\n'
b = unicodedata.normalize('NFD', a)
print(b.translate(cmb_chr))

digitmap = {c: ord('0') + unicodedata.digit(chr(c))
            for c in range(sys.maxunicode)
            if unicodedata.category(chr(c)) == 'Nd'}
x = '\u0661\u0662\u0663'
print(x.translate(digitmap))

y = unicodedata.normalize('NFD', a)
print(y.encode('ascii', 'ignore').decode('ascii'))
