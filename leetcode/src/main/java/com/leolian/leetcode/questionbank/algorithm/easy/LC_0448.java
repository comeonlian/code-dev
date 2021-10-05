package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 448 : 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * 进阶：
 * 你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例1
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * 示例2
 * 输入：nums = [1,1]
 * 输出：[2]
 */
public class LC_0448 {

    public static void main(String[] args) {
        LC_0448 lc0448 = new LC_0448();

        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(lc0448.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int index = (val - 1) % n; // 新下标，取模防止下标越界
            nums[index] = nums[index] + n;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
