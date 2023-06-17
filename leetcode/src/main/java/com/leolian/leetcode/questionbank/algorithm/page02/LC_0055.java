package com.leolian.leetcode.questionbank.algorithm.page02;

import java.util.ArrayList;

/**
 * LC 55 :  跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 示例1
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例2
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class LC_0055 {

    public static void main(String[] args) {
        LC_0055 lc0055 = new LC_0055();

        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(lc0055.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int length = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            return true;
        }
        ArrayList<Boolean> skipZeroList = new ArrayList<>();
        for (int index : list) {
            if (index == 0) {
                return false;
            }
            boolean lastZero = index == (length - 1);
            boolean skipZero = false;
            for (int j = index - 1; j >= 0; j--) {
                int num = nums[j];
                if (num == 0) {
                    continue;
                }
                if (lastZero) {
                    if (num >= (index - j)) {
                        skipZero = true;
                        break;
                    }
                } else if (num > (index - j)) {
                    skipZero = true;
                    break;
                }
            }
            skipZeroList.add(skipZero);
        }
        for (boolean skipZero : skipZeroList) {
            if (!skipZero) {
                return false;
            }
        }
        return true;
    }
    
    /*
    执行用时：26 ms, 在所有 Java 提交中击败了13.85%的用户
    内存消耗：43.2 MB, 在所有 Java 提交中击败了5.09%的用户
    通过测试用例：172 / 172
    */
}
