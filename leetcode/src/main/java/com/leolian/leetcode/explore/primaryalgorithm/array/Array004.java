package com.leolian.leetcode.explore.primaryalgorithm.array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * LC 存在重复元素:
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Array004 {

    public static void main(String[] args) {
        Array004 array004 = new Array004();

        int[] nums = new int[]{1, 2, 3, 4};
//        boolean res = array004.containsDuplicate(nums);

//        boolean res = array004.containsDuplicate1(nums);

        boolean res = array004.containsDuplicate2(nums);

        System.out.println("Result: " + res);
    }


    /**
     * 朴素线性查找 [运行超时，悲剧...]
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 排序法
     * 本方法使用排序算法。由于比较排序算法，如堆排序，可以在最坏情况下具有 O(nlogn) 的时间复杂度。
     * 因此，排序经常是很好的预处理方法。排序之后，我们可以扫描已排序的数组,以查找是否有任何连续的重复元素。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }


    /**
     * 哈希法
     * 有许多数据结构常用作动态集合,如二进制搜索树和哈希表。这里我们需要的操作是 search 和 insert。
     * 对于平衡二叉搜索树（Java 中的 TreeSet 或 TreeMap），search 和 insert 的时间复杂度均为 O(\log n)。
     * 对于哈希表（Java 中的 HashSet 或 HashMap），search 和 insert 的平均时间复杂度为 O(1)。因此，通过使用哈希表，
     * 我们可以达到在线性时间复杂度解决问题。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }


}
