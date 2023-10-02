package com.leolian.leetcode.questionbank.algorithm.page13;

/**
 * LC 643 : 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * 提示：
 * n == nums.length
 * 1 <= k <= n <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * 示例1
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 示例2
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 */
public class LC_0643 {

    public static void main(String[] args) {
        LC_0643 lc0643 = new LC_0643();

        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(lc0643.findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    /*
     时间：2ms，击败 100.00% 使用 Java 的用户
     内存：51.88MB，击败 17.75% 使用 Java 的用户
     */
}
