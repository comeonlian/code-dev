package com.leolian.leetcode.questionbank.algorithm.page02;

import java.util.LinkedList;
import java.util.List;

/**
 * LC 78 : 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * <p>
 * 示例1
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例2
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class LC_0078 {

	public static void main(String[] args) {
		LC_0078 lc0078 = new LC_0078();

		int[] nums = new int[]{1, 2, 3};
		System.out.println(lc0078.subsets(nums));
	}

	//结果集合
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> subsets(int[] nums) {
		LinkedList<Integer> track = new LinkedList<>();
		backtrack(nums, 0, track);
		return res;
	}

	public void backtrack(int[] nums, int start, LinkedList<Integer> track) {
		res.add(new LinkedList(track));
		for (int i = start; i < nums.length; i++) {
			track.add(nums[i]);
			backtrack(nums, i + 1, track);
			track.removeLast();
		}
	}
}
