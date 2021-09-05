package com.leolian.nowcoder.question.bank;

import java.util.LinkedList;
import java.util.Stack;

/**
 * NC 137 : 表达式求值
 * <p>
 * 题目描述：
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 * <p>
 * 示例1
 * 输入："1+2"
 * 返回值：3
 * <p>
 * 示例2
 * 输入："(2*(3-4))*5"
 * 返回值：-10
 * <p>
 * 示例3
 * 输入："3+2*3*4-1"
 * 返回值：26
 */
public class NC_0137 {

    public static void main(String[] args) {
        NC_0137 nc0137 = new NC_0137();

        // ((10+2)*10-(100-(10+20*10-(2*3)))*10*1*2)-2
        // 1-2-3
        String s = "3+2*3*4-1";
        System.out.println(nc0137.solve(s));
    }

    public int solve(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            char ch = s.charAt(0);
            if (ch < 48 || ch > 57)
                return 0;
            return ch - 48;
        }
        Stack<Character> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '(') {
                if (builder.length() > 0) {
                    stack2.push(Integer.valueOf(builder.toString()));
                    builder.delete(0, builder.length());
                }
                while ((ch == '+' || ch == '-') && !stack1.isEmpty() && stack1.peek() == '*') {
                    int num2 = stack2.pop();
                    int num1 = stack2.pop();
                    int val = cal(stack1.pop(), num1, num2);
                    stack2.push(val);
                }
                stack1.push(ch);
                continue;
            }
            if (ch >= 48 && ch <= 57) {
                builder.append(ch - 48);
                continue;
            }
            if (ch == ')') {
                if (builder.length() > 0) {
                    stack2.push(Integer.valueOf(builder.toString()));
                    builder.delete(0, builder.length());
                }
                while (!stack1.isEmpty() && stack1.peek() != '(') {
                    int num2 = stack2.pop();
                    int num1 = stack2.pop();
                    int val = cal(stack1.pop(), num1, num2);
                    stack2.push(val);
                }
                stack1.pop();
            }
        }
        if (builder.length() > 0) {
            stack2.push(Integer.valueOf(builder.toString()));
            builder.delete(0, builder.length());
        }
        // 剩下的操作符正序计算
        LinkedList<Character> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        while (!stack1.isEmpty()) {
            queue1.addFirst(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            queue2.addFirst(stack2.pop());
        }
        boolean first = true;
        int res = 0;
        while (!queue1.isEmpty()) {
            int num1 = queue2.removeFirst();
            int num2 = queue2.removeFirst();
            res = cal(queue1.removeFirst(), num1, num2);
            queue2.addFirst(res);
        }
        return res;
    }

    private int cal(char operator, int num1, int num2) {
        if (operator == '+') {
            return num1 + num2;
        } else if (operator == '-') {
            return num1 - num2;
        } else if (operator == '*') {
            return num1 * num2;
        }
        return 0;
    }
}
