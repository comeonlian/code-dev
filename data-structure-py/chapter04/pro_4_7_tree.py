#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_4_7_tree.py
# @Time      : 2022/4/25 18:02
# @Author    : liang.lian

import turtle

def tree(p_branch_len, t):
    if p_branch_len > 5:
        t.forward(p_branch_len)
        t.right(20)
        tree(p_branch_len - 15, t)
        t.left(40)
        tree(p_branch_len - 15, t)
        t.right(20)
        t.backward(p_branch_len)
        
def main():
    t = turtle.Turtle()
    my_win = turtle.Screen()
    t.left(90)
    t.up()
    t.backward(100)
    t.down()
    t.color("green")
    tree(75, t)
    my_win.exitonclick()
    
main()
