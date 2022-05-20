#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_4_15_rec_dc.py
# @Time      : 2022/5/19 17:24
# @Author    : liang.lian

def rec_dc(coin_value_list, change, known_results):
    min_coins = change
    if change in coin_value_list:
        known_results[change] = 1
        return 1
    elif known_results[change] > 0:
        return known_results[change]
    else:
        for i in [c for c in coin_value_list if c <= change]:
            num_coins = 1 + rec_dc(coin_value_list, change - i, known_results)
            if num_coins < min_coins:
                min_coins = num_coins
                known_results[change] = min_coins
    return min_coins

print([0] * 63)
print(rec_dc([1, 5, 10, 25], 63, [0] * 64))