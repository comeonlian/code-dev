#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/10/2 15:45
# @Author  : lianliang
# @File    : demo_2_8.py
import re

text1 = '/* this is a comment */'
text2 = '''/* this is a
 multiline comment */
'''

comment_pat = re.compile(r'/\*(.*?)\*/')
comment_pat1 = re.compile(r'/\*((?:.|\n)*?)\*/')
comment_pat2 = re.compile(r'/\*(.*?)\*/', re.DOTALL)

print(comment_pat.findall(text1))
print(comment_pat1.findall(text2))
print(comment_pat2.findall(text2))
