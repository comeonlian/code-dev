package com.leolian.nowcoder.question.bank.page05;

import java.util.Arrays;
import java.util.Stack;

/**
 * NC 208 : 每日温度
 * 题目描述
 * 根据往后 n 天的天气预报，计算每一天需要等待几天才会出现一次更高的气温，如果往后都没有更高的气温，则用 0 补位。
 * 例如往后三天的气温是 [1,2,3] ， 则输出 [1,1,0]
 * 备注：
 * 数据范围：1 <= n <= 10^5  ，每天的温度满足 0 <= temp <= 100
 * <p>
 * 示例1
 * 输入：[1,2,3]
 * 返回值：[1,1,0]
 * <p>
 * 示例2
 * 输入：[2,4,5,9,10,0,9]
 * 返回值：[1,1,1,1,0,1,0]
 * <p>
 * 示例3
 * 输入：[3,1,4]
 * 返回值：[2,1,0]
 */
public class NC_0208 {

	public static void main(String[] args) {
		NC_0208 nc0208 = new NC_0208();

		int[] temperatures = new int[]{2, 4, 5, 9, 10, 0, 9};
		int[] res = nc0208.temperatures(temperatures);
		System.out.println(Arrays.toString(res));
	}

	/**
	 * 1、使用单调栈，栈中存放数组元素的下标
	 * 2、遍历数组中的元素，分别与栈中的元素进行比较，如果小于栈顶元素直接入栈，如果大于栈顶元素则将栈元素出栈并用下标计算天数
	 */
	public int[] temperatures(int[] temperatures) {
		if (null == temperatures || temperatures.length == 0) {
			return new int[0];
		}
		int[] res = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < temperatures.length; i++) {
			while ((!stack.isEmpty()) && (temperatures[stack.peek()] < temperatures[i])) {
				int idx = stack.pop();
				res[idx] = i - idx;
			}
			stack.push(i);
		}
		return res;
	}

	/*
	运行时间：618ms
	超过62.22% 用Java提交的代码
	
	占用内存：27604KB
	超过68.89%用Java提交的代码
	*/
	
}
