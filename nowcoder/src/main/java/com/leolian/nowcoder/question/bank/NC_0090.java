package com.leolian.nowcoder.question.bank;

import java.util.Stack;

/**
 * NC 90 : 包含min函数的栈
 * <p>
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，
 * 并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 * <p>
 * 示例1:
 * 输入：["PSH-1","PSH2","MIN","TOP","POP","PSH1","TOP","MIN"]
 * 返回值：-1,2,1,-1
 * 解析：
 * "PSH-1"表示将-1压入栈中，栈中元素为-1
 * "PSH2"表示将2压入栈中，栈中元素为2，-1
 * “MIN”表示获取此时栈中最小元素==>返回-1
 * "TOP"表示获取栈顶元素==>返回2
 * "POP"表示弹出栈顶元素，弹出2，栈中元素为-1
 * "PSH-1"表示将1压入栈中，栈中元素为1，-1
 * "TOP"表示获取栈顶元素==>返回1
 * “MIN”表示获取此时栈中最小元素==>返回-1
 */
public class NC_0090 {

    public static void main(String[] args) {
        NC_0090 nc0090 = new NC_0090();

        nc0090.push(-1);
        nc0090.push(2);
        System.out.println(nc0090.min());
        System.out.println(nc0090.top());
        nc0090.pop();
        nc0090.push(1);
        System.out.println(nc0090.top());
        System.out.println(nc0090.min());
    }

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.size() == 0) {
            minStack.push(node);
        } else {
            int min = minStack.peek();
            if (min > node) {
                min = node;
            }
            minStack.push(min);
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}

