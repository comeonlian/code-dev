package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 674 : 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 提示：
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * 示例1
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * <p>
 * 示例2
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 */
public class LC_0674 {

    public static void main(String[] args) {
        LC_0674 lc0674 = new LC_0674();

        int[] nums = new int[]{1,3,5,4,7,8,9};
        System.out.println(lc0674.findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        int len = 1;
        int pre, cur;
        for (int i = 1; i < nums.length; i++) {
            pre = nums[i - 1];
            cur = nums[i];
            if (cur > pre) {
                len++;
            } else {
                len = 1;
            }
            if (len > max) {
                max = len;
            }
        }
        return max;
    }
}
