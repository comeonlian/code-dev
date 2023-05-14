package com.leolian.leetcode.questionbank.algorithm.page05;

import java.util.Arrays;

/**
 * LC 217 : 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例1
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例2
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例3
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class LC_0217 {

    public static void main(String[] args) {
        LC_0217 lc0217 = new LC_0217();

        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(lc0217.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
