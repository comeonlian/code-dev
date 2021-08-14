package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
 * 并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中
 * 同样的元素。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class LC_0001 {

    public static void main(String[] args) {
        int[] nums = new int[]{15, 2, 11, 6, 8, 7};
        int target = 9;
        int[] twoSum = twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }

    /**
     * 执行用时 : 80 ms, 在Two Sum的Java提交中击败了11.82% 的用户
     * 内存消耗 : 37.9 MB, 在Two Sum的Java提交中击败了0.99% 的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int lastIndex = nums.length - 1;
        int[] result = new int[2];
        first: for (int i = 0; i < lastIndex; i++) {
            second: for (int j = lastIndex; j > i; j--) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    break first;
                }
            }
        }
        return result;
    }
}
