#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_4_17_dp_make_change.py
# @Time      : 2022/5/23 19:44
# @Author    : liang.lian

def dp_make_change(coin_value_list, change, min_coins, coins_used):
    for cents in range(change + 1):
        coin_count = cents
        new_coin = 1
        for j in [c for c in coin_value_list if c <= cents]:
            if min_coins[cents - j] + 1 < coin_count:
                coin_count = min_coins[cents - j] + 1
                new_coin = j
        min_coins[cents] = coin_count
        coins_used[cents] = new_coin
    
    print(min_coins)
    print(coins_used)

    min_coin = min_coins[change]
    changes = []

    coin = change
    while coin > 0:
        this_coin = coins_used[coin]
        changes.append(this_coin)
        coin = coin - this_coin

    return min_coin, changes


print(dp_make_change([1, 5, 10, 21, 25], 63, [0] * 64, [0] * 64))
