package com.leolian.leetcode.explore.primaryalgorithm.array;

import java.util.Arrays;

/**
 * LC 两数之和:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Array009 {

    public static void main(String[] args) {
        Array009 array009 = new Array009();

        int[] array = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] sum = array009.twoSum(array, target);

        System.out.println("Result array: " + Arrays.toString(sum));
    }


    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int lastIndex = nums.length - 1;
        int[] result = new int[2];
        first:
        for (int i = 0; i < lastIndex; i++) {
            second:
            for (int j = lastIndex; j > i; j--) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    break first;
                }
            }
        }
        return result;
    }
    /*
    执行结果：通过
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：38.5 MB, 在所有 Java 提交中击败了83.81%的用户 
    */

}
