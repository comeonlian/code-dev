package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 908 : 最小差值 I
 * 给你一个整数数组 nums，请你给数组中的每个元素 nums[i] 都加上一个任意数字 x （-k <= x <= k），
 * 从而得到一个新数组 result 。
 * 返回数组 result 的最大值和最小值之间可能存在的最小差值。
 * 提示：
 * 1 <= nums.length <= 10000
 * 0 <= nums[i] <= 10000
 * 0 <= k <= 10000
 * <p>
 * 示例1
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：result = [1]
 * <p>
 * 示例2
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：result = [2,8]
 * <p>
 * 示例3
 * 输入：nums = [1,3,6], k = 3
 * 输出：0
 * 解释：result = [3,3,3] or result = [4,4,4]
 */
public class LC_0908 {

    public static void main(String[] args) {
        LC_0908 lc0908 = new LC_0908();

        int[] nums = new int[]{1, 3, 6};
        int k = 3;
        System.out.println(lc0908.smallestRangeI(nums, k));
    }

    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return Math.max(0, max - min - 2 * k);
    }
}
