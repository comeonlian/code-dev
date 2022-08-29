#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/8/28 10:54
# @Author  : lianliang
# @File    : urlparse_view.py


import json
import time
from tkinter import Label, Text, Button, END, Tk

from util import urlparse_util

LOG_LINE_NUM = 0


class UrlparseView(object):
    def __init__(self, init_window_name):
        self._init_window_name = init_window_name

    def _get_window_position(self):
        # 获取屏幕尺寸计算参数，使窗口显示再屏幕中央
        screen_width = self._init_window_name.winfo_screenwidth()
        screen_height = self._init_window_name.winfo_screenheight()
        width = 1068
        height = 681
        # window_size = '%dx%d+%d+%d' % (width, height, (screen_width-width)/2, (screen_height-height)/2)
        # round去掉小数
        window_size = f'{width}x{height}+{round((screen_width - width) / 2)}+{round((screen_height - height) / 2)}'
        return window_size

    # 设置窗口
    def _set_init_window(self):
        self._init_window_name.title("URL编解码")  # 窗口名

        # self.init_window_name.geometry('320x160+10+10') #290 160为窗口大小，+10 +10 定义窗口弹出时的默认展示位置
        # self._init_window_name.geometry('1068x681+220+80')
        window_size = self._get_window_position()
        self._init_window_name.geometry(window_size)
        # self.init_window_name["bg"] = "pink" #窗口背景色，其他背景色见：blog.csdn.net/chl0000/article/details/7657887
        # self.init_window_name.attributes("-alpha",0.9) #虚化，值越小虚化程度越高

        # 标签
        self._init_data_label = Label(self._init_window_name, text="待编码字符串")
        self._init_data_label.grid(row=0, column=0)

        self._result_data_label = Label(self._init_window_name, text="编码结果")
        self._result_data_label.grid(row=0, column=12)

        self._log_label = Label(self._init_window_name, text="日志")
        self._log_label.grid(row=12, column=0)

        # 文本框
        self._init_data_text = Text(self._init_window_name, borderwidth=1, width=68, height=39)  # 原始数据录入框
        self._init_data_text.grid(row=1, column=0, rowspan=10, columnspan=10)

        self._result_data_text = Text(self._init_window_name, width=71, height=49)  # 处理结果展示
        self._result_data_text.grid(row=1, column=12, rowspan=15, columnspan=12)

        self._log_data_text = Text(self._init_window_name, borderwidth=1, width=68, height=8)  # 日志框
        self._log_data_text.grid(row=13, column=0, columnspan=10)

        # 编码按钮
        self._url_str_encode_to_target = Button(self._init_window_name, text="编码", bg="lightblue", width=10,
                                                command=self.url_str_encode)  # 调用内部方法  加()为直接调用
        self._url_str_encode_to_target.grid(row=4, column=11)

        # 解码按钮
        self._url_str_decode_to_target = Button(self._init_window_name, text="解码", bg="lightblue", width=10,
                                                command=self.url_str_decode)  # 调用内部方法  加()为直接调用
        self._url_str_decode_to_target.grid(row=6, column=11)

    # 获取当前时间
    def _get_current_time(self):
        current_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time()))
        return current_time

    # 日志动态打印
    def _write_log_to_text(self, logmsg):
        global LOG_LINE_NUM
        current_time = self._get_current_time()
        # 换行
        logmsg_in = str(current_time) + " " + str(logmsg) + "\n"
        if LOG_LINE_NUM <= 7:
            self._log_data_text.insert(END, logmsg_in)
            LOG_LINE_NUM = LOG_LINE_NUM + 1
        else:
            self._log_data_text.delete(1.0, 2.0)
            self._log_data_text.insert(END, logmsg_in)

    '''
    {
        "exchangeType": "K", 
        "stockCode": "00700.HK", 
        "pageNo": 1, 
        "pageSize": 20
    }
    '''

    # URL字符串编码功能函数
    def url_str_encode(self):
        data = self._init_data_text.get(1.0, END).strip().replace("\n", "").replace(" ", "")
        # print(type(data), " data: ", data)
        if len(data) > 0:
            # 编码
            try:
                # 先将字符串转为JSON，再转dict
                dc = self.str_to_dict(data)
                if dc is None:
                    return

                # 编码
                result = urlparse_util.encode(dc)

                # 输出到界面
                self._result_data_text.delete(1.0, END)
                self._result_data_text.insert(1.0, result)
                self._write_log_to_text("INFO: url_str_encode success")
            except:
                self._result_data_text.delete(1.0, END)
                # self._result_data_text.insert(1.0, "字符串转MD5失败")
                self._write_log_to_text("ERROR: 字符串编码失败！")
        else:
            self._write_log_to_text("WARN: 请输入需要转换的字符串！")

    # JSON字符串转换为dict
    def str_to_dict(self, data):
        try:
            dc_obj = json.loads(data)
            # print(type(json_obj))
            return dc_obj
        except:
            self._result_data_text.delete(1.0, END)
            # self._result_data_text.insert(1.0, "字符串转JSON失败")
            self._write_log_to_text("ERROR: 字符串转JSON失败！")
        return None

    # URL字符串解码功能函数
    def url_str_decode(self):
        data = self._init_data_text.get(1.0, END).strip().replace("\n", "").replace(" ", "")
        # print(type(data), " data: ", data)
        if data:
            try:
                # 解码
                result = urlparse_util.decode(data)
                
                flag, json_obj = self.is_json_str(result)
                if flag is True:
                    result = json.dumps(json_obj, indent=2)

                # 输出到界面
                self._result_data_text.delete(1.0, END)
                self._result_data_text.insert(1.0, result)
                self._write_log_to_text("INFO: url_str_decode success")
            except:
                self._result_data_text.delete(1.0, END)
                # self._result_data_text.insert(1.0, "字符串转MD5失败"
                self._write_log_to_text("ERROR: 字符串解码失败！")
        else:
            self._write_log_to_text("WARN: 请输入需要转换的字符串！")

    def is_json_str(self, json_str):
        try:
            json_obj = json.loads(json_str)
            return True, json_obj
        except ValueError:
            return False,None


def view_start():
    init_window = Tk()  # 实例化出一个父窗口
    urlparse_view = UrlparseView(init_window)
    # 设置根窗口默认属性
    urlparse_view._set_init_window()

    init_window.mainloop()  # 父窗口进入事件循环，可以理解为保持窗口运行，否则界面不展示


if __name__ == '__main__':
    view_start()
