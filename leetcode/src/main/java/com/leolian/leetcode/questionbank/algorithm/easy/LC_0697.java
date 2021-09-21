package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * LC 697 : 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 提示：
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * <p>
 * 示例1
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 示例2
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 */
public class LC_0697 {

    public static void main(String[] args) {
        LC_0697 lc0697 = new LC_0697();

        int[] nums = new int[]{1,2,2,3,2,1,3,3};
        System.out.println(lc0697.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int spend = -1;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val)) {
                map.get(val).add(i);
                if (map.get(val).size() > spend) {
                    spend = map.get(val).size();
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(val, list);
                if (spend == -1) {
                    spend = 1;
                }
            }
        }
        if (spend == 1) {
            return spend;
        }
        int len = nums.length;
        for (ArrayList<Integer> list : map.values()) {
            if (list.size() == spend) {
                int subArray = list.get(spend - 1) - list.get(0) + 1;
                if (subArray < len) {
                    len = subArray;
                }
            }
        }
        return len;
    }
}
