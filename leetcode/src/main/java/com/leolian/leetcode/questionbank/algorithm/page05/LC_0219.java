package com.leolian.leetcode.questionbank.algorithm.page05;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * LC 219 : 存在重复元素 II
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 * <p>
 * 示例1
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 示例2
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 示例3
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 */
public class LC_0219 {

    public static void main(String[] args) {
        LC_0219 lc0219 = new LC_0219();

        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        System.out.println(lc0219.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                ArrayList<Integer> list = map.get(num);
                for (Integer index : list) {
                    if (Math.abs(index - i) <= k) {
                        return true;
                    }
                }
                list.add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            } 
        }
        return false;
    }
    
    /*
    执行用时：23 ms, 在所有 Java 提交中击败了18.58%的用户
    内存消耗：56.6 MB, 在所有 Java 提交中击败了5.02%的用户
    */
}
