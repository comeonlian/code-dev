package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 11 : 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点
 * 分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 * 提示：
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * <p>
 * 示例1
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例2
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 示例3
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * <p>
 * 示例4
 * 输入：height = [1,2,1]
 * 输出：2
 */
public class LC_0011 {

	public static void main(String[] args) {
		LC_0011 lc0011 = new LC_0011();

		int[] height = new int[]{1,8,6,2,5,4,8,3,7};
		System.out.println(lc0011.maxArea(height));
	}

	public int maxArea(int[] height) {
		if (null == height || height.length == 0) {
			return 0;
		}
		int max = 0;
		int start = 0;
		int end = height.length - 1;
		while (start < end) {
			int x = end - start;
			int y = Math.min(height[start], height[end]);
			int multi = x * y;
			if (multi > max) {
				max = multi;
			}
			if (height[start] <= height[end]) {
				start++;
			} else {
				end--;
			}
		}
		return max;
	}
}
