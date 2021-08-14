package com.leolian.nowcoder.question.book.code.interview.guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * CD 5 : 设计getMin功能的栈
 * <p>
 * 题目描述
 * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * <p>
 * 输入描述：
 * 第一行输入一个整数N，表示对栈进行的操作总数。
 * 下面N行每行输入一个字符串S，表示操作的种类。
 * 如果S为"push"，则后面还有一个整数X表示向栈里压入整数X。
 * 如果S为"pop"，则表示弹出栈顶操作。
 * 如果S为"getMin"，则表示询问当前栈中的最小元素是多少。
 * 输出描述：
 * 对于每个getMin操作，输出一行表示当前栈中的最小元素是多少。
 * <p>
 * 示例1
 * 输入：
 * 6
 * push 3
 * push 2
 * push 1
 * getMin
 * pop
 * getMin
 * 输出：
 * 1
 * 2
 * <p>
 * 备注：
 * 1 <= N <= 1000000
 * -1000000 <= X <= 1000000
 * 数据保证没有不合法的操作
 */
public class CD_005 {

    private Stack<Integer> numStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        CD_005 main = new CD_005();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] line = null;
        for (int i = 0; i < n; i++) {
            line = reader.readLine().split(" ");
            if (line[0].equals("getMin")) {
                System.out.println(main.getMin());
            } else if (line[0].equals("push")) {
                main.push(Integer.parseInt(line[1]));
            } else {
                main.pop();
            }
        }
    }

    private void pop() {
        int pop = numStack.pop();
        if (pop == minStack.peek()) {
            minStack.pop();
        }
    }

    private int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    private void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (minStack.peek() > val) {
            minStack.push(val);
        }
        numStack.push(val);
    }

}
