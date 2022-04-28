#!/usr/bin/env python
# -*- coding:utf-8 -*-

# @FileName  : pro_4_8_sierpinski.py
# @Time      : 2022/4/26 10:28
# @Author    : liang.lian

import turtle


def draw_triangle(points, color, p_turtle):
    p_turtle.fillcolor(color)
    p_turtle.up()
    p_turtle.goto(points[0][0], points[0][1])
    p_turtle.down()
    p_turtle.begin_fill()
    p_turtle.goto(points[1][0], points[1][1])
    p_turtle.goto(points[2][0], points[2][1])
    p_turtle.goto(points[0][0], points[0][1])
    p_turtle.end_fill()


def get_mid(p1, p2):
    return [(p1[0] + p2[0]) / 2, (p1[1] + p2[1]) / 2]


def sierpinski(points, degree, p_turtle):
    colormap = ['blue', 'red', 'green', 'white', 'yellow', 'violet', 'orange']
    draw_triangle(points, colormap[degree], p_turtle)
    if degree > 0:
        sierpinski([points[0], get_mid(points[0], points[1]), get_mid(points[0], points[2])],
                   degree - 1, p_turtle)
        sierpinski([points[1], get_mid(points[0], points[1]), get_mid(points[1], points[2])],
                   degree - 1, p_turtle)
        sierpinski([points[2], get_mid(points[2], points[1]), get_mid(points[0], points[2])],
                   degree - 1, p_turtle)


def main():
    my_turtle = turtle.Turtle()
    my_win = turtle.Screen()
    my_points = [[-200, -100], [0, 200], [200, -100]]
    sierpinski(my_points, 5, my_turtle)
    my_win.exitonclick()


main()
