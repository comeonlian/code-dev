#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_4_14_rec_mc.py
# @Time      : 2022/5/19 17:24
# @Author    : liang.lian

def rec_mc(coin_value_list, change):
    min_coins = change
    if change in coin_value_list:
        return 1
    else:
        for i in [c for c in coin_value_list if c <= change]:
            num_coins = 1 + rec_mc(coin_value_list, change - i)
            if num_coins < min_coins:
                min_coins = num_coins
    return min_coins

print(rec_mc([1, 5, 10, 25], 63))