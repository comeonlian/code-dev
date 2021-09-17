package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * LC 349 : 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 示例1
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例2
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class LC_0349 {

	public static void main(String[] args) {
		LC_0349 lc0349 = new LC_0349();

		int[] nums1 = new int[]{4, 9, 5};
		int[] nums2 = new int[]{9, 4, 9, 8, 4};
		System.out.println(Arrays.toString(lc0349.intersection(nums1, nums2)));
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		if (null == nums1 || nums1.length == 0 || null == nums2 || nums2.length == 0) {
			return new int[0];
		}
		HashSet<Integer> res = new HashSet<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int index1 = 0;
		int index2 = 0;
		while (index1 < nums1.length && index2 < nums2.length) {
			if (nums1[index1] < nums2[index2]) {
				index1++;
			} else if (nums1[index1] > nums2[index2]) {
				index2++;
			} else {
				res.add(nums1[index1]);
				index1++;
				index2++;
			}
		}

		int[] arr = new int[res.size()];
		int index = 0;
		for (Integer re : res) {
			arr[index++] = re;
		}
		return arr;
	}
	
	/*
	public int[] intersection(int[] nums1, int[] nums2) {
		if (null == nums1 || nums1.length == 0 || null == nums2 || nums2.length == 0) {
			return new int[0];
		}
		HashSet<Integer> set1 = new HashSet<>();
		Arrays.stream(nums1).forEach(set1::add);
		HashSet<Integer> set2 = new HashSet<>();
		Arrays.stream(nums2).forEach(set2::add);

		HashSet<Integer> res = new HashSet<>(set1);
		res.retainAll(set2);

		int[] arr = new int[res.size()];
		int index = 0;
		for (Integer re : res) {
			arr[index++] = re;
		}
		return arr;
	}
	*/
}
