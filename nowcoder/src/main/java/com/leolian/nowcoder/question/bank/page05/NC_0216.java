package com.leolian.nowcoder.question.bank.page05;

import java.util.Stack;

/**
 * NC 216 : 逆波兰表达式求值
 * 题目描述
 * 给定一个逆波兰表达式，求表达式的值。
 * 备注：
 * 数据范围：表达式长度满足 1 <= n <= 10^4 ，表达式中仅包含数字和 + ，- , * , / ，其中数字的大小满足 |val| <= 200。
 * <p>
 * 示例1
 * 输入：["2","1","+","4","*"]
 * 返回值：12
 * <p>
 * 示例2
 * 输入：["2","0","+"]
 * 返回值：2
 */
public class NC_0216 {

	public static void main(String[] args) {
		NC_0216 nc0216 = new NC_0216();

		String[] tokens = new String[]{"4","4","+","4","/"};
		System.out.println(nc0216.evalRPN(tokens));
	}

	/**
	 * 1、创建一个操作数栈，遍历数组时，遇到数字即入栈，遇到运算符即弹出栈顶的两个元素执行运算再把结果入栈
	 * 2、最后将栈中的数据结果弹出返回
	 */
	public int evalRPN (String[] tokens) {
		if (null == tokens || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int res = calculate(num1, num2, token);
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	private int calculate(int num1, int num2, String token) {
		switch (token) {
			case "+" :
				return num2 + num1;
			case "-":
				return num2 - num1;
			case "*":
				return num2 * num1;
			case "/":
				return num2/num1;
			default:
				return 0;
		}
	}

	/*
	运行时间：99ms
	超过19.35% 用Java提交的代码
	
	占用内存：15108KB
	超过19.35%用Java提交的代码
	*/
	
}
