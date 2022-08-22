#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : demo_1_8.py
# @Time      : 2022/8/22 11:01
# @Author    : liang.lian

prices = {
    'ACME': 45.23,
    'AAPL': 612.78,
    'IBM': 205.55,
    'HPQ': 37.20,
    'FB': 10.75,
}

min_price = min(zip(prices.values(), prices.keys()))
print(min_price)

max_price = max(zip(prices.values(), prices.keys()))
print(max_price)

prices_sorted = sorted(zip(prices.values(), prices.keys()))
print(prices_sorted)
