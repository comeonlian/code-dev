#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : demo_1_7.py
# @Time      : 2022/8/22 10:50
# @Author    : liang.lian
import json
from collections import OrderedDict

d = OrderedDict()

d['foo'] = 1
d['bar'] = 2
d['spam'] = 3
d['grok'] = 4

# Outputs "foo 1", "bar 2", "spam 3", "grok 4"
for key in d:
    print(key, d[key])

print(json.dumps(d))
