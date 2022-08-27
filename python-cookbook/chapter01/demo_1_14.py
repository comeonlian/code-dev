#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/27 12:39
# @Author  : lianliang
# @File    : demo_1_14.py
import operator


class User:
    def __init__(self, user_id):
        self._user_id = user_id

    def __repr__(self):
        return 'User({})'.format(self._user_id)


if __name__ == '__main__':
    users = [User(23), User(3), User(99)]
    print(users)
    print(sorted(users, key=lambda v: v._user_id))

    print(sorted(users, key=operator.attrgetter('_user_id')))
    
    print(max(users, key=operator.attrgetter('_user_id')))
