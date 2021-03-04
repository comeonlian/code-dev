package com.leolian.leetcode.explore.primaryalgorithm.array;

import java.util.Arrays;

/**
 * LC 只出现一次的数字:
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Array005 {

    public static void main(String[] args) {
        Array005 array005 = new Array005();

        int[] nums = new int[]{2, 2, 1, 1, 9};
        int singleNumber = array005.singleNumber(nums);
        System.out.println("Single num: " + singleNumber);

    }


    /**
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

}
