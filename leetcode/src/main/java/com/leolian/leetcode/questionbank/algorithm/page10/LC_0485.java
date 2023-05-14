package com.leolian.leetcode.questionbank.algorithm.page10;

/**
 * LC 485 : 最大连续 1 的个数
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * 提示：
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 示例1
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 */
public class LC_0485 {

    public static void main(String[] args) {
        LC_0485 lc0485 = new LC_0485();

        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(lc0485.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        for (int val : nums) {
            if (val == 1) {
                count++;
            } else {
                if (count > sum)
                    sum = count;
                count = 0;
            }
        }
        if (count > sum)
            sum = count;
        return sum;
    }
}
