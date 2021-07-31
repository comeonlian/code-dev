package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 30 : 连续子数组的最大和
 * <p>
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * <p>
 * 示例1
 * 输入：[1,-2,3,10,-4,7,2,-5]
 * 返回值：18
 * 说明：
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class JZ_030 {

    public static void main(String[] args) {
        JZ_030 jz030 = new JZ_030();

        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(jz030.FindGreatestSumOfSubArray(array));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            sum += val;
            if (sum < val) {
                sum = val;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

}
