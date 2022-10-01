#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/10/1 21:49
# @Author  : lianliang
# @File    : demo_2_6.py
import re

text = 'UPPER PYTHON, lower python, Mixed Python'
print(re.sub('python', 'snake', text, flags=re.IGNORECASE))


def matchcase(word):
    def replace(m):
        v = m.group()
        if v.isupper():
            return word.upper()
        elif v.islower():
            return word.lower()
        elif v[0].isupper():
            return word.capitalize()
        else:
            return word

    return replace


print(re.sub('python', matchcase('snake'), text, flags=re.IGNORECASE))
