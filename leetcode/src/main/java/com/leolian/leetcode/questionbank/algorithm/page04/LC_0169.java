package com.leolian.leetcode.questionbank.algorithm.page04;

/**
 * LC 169 : 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * 示例1
 * 输入：[3,2,3]
 * 输出：3
 * <p>
 * 示例2
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class LC_0169 {

    public static void main(String[] args) {
        LC_0169 lc0169 = new LC_0169();

        int[] nums = new int[]{3, 2, 3};
        System.out.println(lc0169.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int candidate = 0;
        int count = 0;
        for (int val : nums) {
            if (count == 0)
                candidate = val;
            if (candidate == val) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
