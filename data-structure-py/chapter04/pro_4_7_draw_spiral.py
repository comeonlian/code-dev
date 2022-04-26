#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_4_7_draw_spiral.py
# @Time      : 2022/4/25 17:18
# @Author    : liang.lian

import turtle

my_turtle = turtle.Turtle()
my_win = turtle.Screen()


def draw_spiral(p_turtle, p_linelen):
    if p_linelen > 0:
        p_turtle.forward(p_linelen)
        p_turtle.right(90)
        draw_spiral(p_turtle, p_linelen - 5)

draw_spiral(my_turtle, 100)
my_win.exitonclick()