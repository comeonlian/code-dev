package com.leolian.leetcode.questionbank.algorithm.page06;

import java.util.Arrays;

/**
 * LC 268 : 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 * <p>
 * 示例1
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 */
public class LC_0268 {

    public static void main(String[] args) {
        LC_0268 lc0268 = new LC_0268();

        int[] nums = {3,0,1};
        System.out.println(lc0268.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int calTotal = (len * (len + 1)) / 2;
        int numTotal = Arrays.stream(nums).sum();
        return calTotal - numTotal;
    }
}
