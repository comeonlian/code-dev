#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 21:47
# @Author  : lianliang
# @File    : urlparse_util.py
import json
import urllib.parse


def encode(data):
    """
    :param data: dict类型数据
    :return: 编码后的JSON字符串
    """
    json_s = json.dumps(data).replace(' ', '')
    # print(json_s)
    en_str = urllib.parse.quote(json_s, encoding='utf8')
    return en_str


def decode(data):
    """
    :param data: 编码字符串
    :return: 原始字符串
    """
    de_str = urllib.parse.unquote(data, encoding='utf-8')
    return de_str


if __name__ == '__main__':
    # {"exchangeType":"K","stockCode":"00700.HK","pageNo":1,"pageSize":20}
    # %7B%22exchangeType%22%3A%22K%22%2C%22stockCode%22%3A%2200700.HK%22%2C%22pageNo%22%3A1%2C%22pageSize%22%3A20%7D

    d = {
        'exchangeType': 'K',
        'stockCode': '00700.HK',
        'pageNo': 1,
        'pageSize': 20
    }

    r = encode(d)
    print(r)

    s = decode(r)
    print(s)
