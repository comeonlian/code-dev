package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 724 : 寻找数组的中心下标
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * 提示：
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 * <p>
 * 示例1
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 * 示例2
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * <p>
 * 示例3
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 */
public class LC_0724 {

    public static void main(String[] args) {
        LC_0724 lc0724 = new LC_0724();

        int[] nums = new int[]{1, 2, 3};
        System.out.println(lc0724.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return -1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        int rightSum = sum;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                leftSum += nums[i-1];
            }
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
    
    /*
    执行用时：1 ms, 在所有 Java 提交中击败了98.85%的用户
    内存消耗：42.2 MB, 在所有 Java 提交中击败了5.08%的用户
    通过测试用例：742 / 742 
    */
}
