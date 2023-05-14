package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 4 : 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例1
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例2
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例3
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例4
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例5
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class LC_0004 {

    public static void main(String[] args) {
        LC_0004 lc0004 = new LC_0004();

        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        System.out.println(lc0004.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((null == nums1 || nums1.length == 0) && (null == nums2 || nums2.length == 0)) {
            return 0d;
        }
        if (null == nums1 || nums1.length == 0) {
            return middle(nums2);
        }
        if (null == nums2 || nums2.length == 0) {
            return middle(nums1);
        }
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            int first = nums1[i];
            int second = nums2[j];
            if (first <= second) {
                nums[index++] = first;
                i++;
            } else {
                nums[index++] = second;
                j++;
            }
        }
        while (i < nums1.length) {
            nums[index++] = nums1[i];
            i++;
        }
        while (j < nums2.length) {
            nums[index++] = nums2[j];
            j++;
        }
        return middle(nums);
    }

    private double middle(int[] nums) {
        int len = nums.length;
        if ((len % 2) == 0) {
            int end = len / 2;
            int start = end - 1;
            return (nums[start] + nums[end]) / 2.0;
        } else {
            return nums[len / 2];
        } 
    }
    
    
}
