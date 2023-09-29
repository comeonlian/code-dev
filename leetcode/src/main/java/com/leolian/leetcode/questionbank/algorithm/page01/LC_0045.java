package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 45 : 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 提示:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * <p>
 * 示例1
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 示例2
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class LC_0045 {

    public static void main(String[] args) {
        LC_0045 lc0045 = new LC_0045();

        int[] nums = new int[]{2,3,1,2,4,2,3};
        System.out.println(lc0045.jump(nums));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
    
    /*
    时间：1ms，击败 99.19%使用 Java 的用户 
    内存：42.69MB，击败 19.12%使用 Java 的用户
    */
}
