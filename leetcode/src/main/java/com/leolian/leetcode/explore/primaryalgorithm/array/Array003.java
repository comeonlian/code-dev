package com.leolian.leetcode.explore.primaryalgorithm.array;

import java.util.Arrays;

/**
 * LC 旋转数组:
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Array003 {

    public static void main(String[] args) {
        Array003 array003 = new Array003();

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("before: " + Arrays.toString(nums));
//        array003.rotate(nums, k);
        array003.rotate1(nums, k);
        System.out.println("after: " + Arrays.toString(nums));

//        array003.reverseArray(nums, 0, nums.length - 1);
//        System.out.println("reverse: " + Arrays.toString(nums));

    }


    /**
     * 方法 1：暴力法
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // 暴力法优化
        for (int i = 0; i < k; i++) {
            int before = nums[0];
            int curr = 0;
            for (int j = 1; j < nums.length; j++) {
                curr = nums[j];
                nums[j] = before;
                before = curr;
            }
            nums[0] = before;
        }
    }


    /**
     * 方法 4：反转法
     * <p>
     * 这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * <p>
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
     * <p>
     * 假设 n=7且 k=3。
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        k = k % nums.length; // 溢出优化
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }


    /**
     * 反转数组
     *
     * @param array
     * @param start
     * @param end
     */
    private void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }


}