package com.leolian.leetcode.questionbank.algorithm.page13;

/**
 * LC 628 : 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 提示：
 * 3 <= nums.length <= 10^4
 * -1000 <= nums[i] <= 1000
 * <p>
 * 示例1
 * 输入：nums = [1,2,3]
 * 输出：6
 * <p>
 * 示例2
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * <p>
 * 示例3
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 */
public class LC_0628 {

    public static void main(String[] args) {
        LC_0628 lc0628 = new LC_0628();

        int[] nums = new int[]{1,2,3,4};
        System.out.println(lc0628.maximumProduct(nums));
    }

    public int maximumProduct(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int min1 = 1001, min2 = 1001;
        int max1 = -1001, max2 = -1001, max3 = -1001;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
