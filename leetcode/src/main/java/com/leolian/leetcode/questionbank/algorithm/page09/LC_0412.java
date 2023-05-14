package com.leolian.leetcode.questionbank.algorithm.page09;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 412 :  Fizz Buzz
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i 如果上述条件全不满足。
 * 提示：
 * 1 <= n <= 10^4
 * <p>
 * 示例1
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * <p>
 * 示例2
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * <p>
 * 示例3
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */
public class LC_0412 {

	public static void main(String[] args) {
		LC_0412 lc0412 = new LC_0412();

		int n = 5;
		System.out.println(lc0412.fizzBuzz(n));
	}

	public List<String> fizzBuzz(int n) {
		ArrayList<String> list = new ArrayList<>(n);
		int start = 1;
		while (start <= n) {
			if ((start % 3 == 0) && (start % 5 == 0)) {
				list.add("FizzBuzz");
			} else if (start % 3 == 0) {
				list.add("Fizz");
			} else if (start % 5 == 0) {
				list.add("Buzz");
			} else {
				list.add(String.valueOf(start));
			} 
			start++;
		}
		return list;
	}
}
