#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_4_16_dp_make_change.py
# @Time      : 2022/5/23 19:19
# @Author    : liang.lian

def dp_make_change(coin_value_list, change, min_coins):
    for cents in range(change + 1):
        coin_count = cents
        for j in [c for c in coin_value_list if c <= cents]:
            if min_coins[cents - j] + 1 < coin_count:
                coin_count = min_coins[cents - j] + 1
        min_coins[cents] = coin_count
    # print(min_coins)
    # [0, 1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6, 3, 4, 5, 6, 7, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 3, 4, 5, 6, 7, 3, 4, 5, 6]
    return min_coins[change]

print(dp_make_change([1, 5, 10, 25], 63, [0] * 64))