package com.leolian.leetcode.questionbank.algorithm.page07;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * LC 347 : 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * 示例1
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例2
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class LC_0347 {

    public static void main(String[] args) {
        LC_0347 lc0347 = new LC_0347();

        int[] nums = new int[]{1, 2};
        int k = 2;
        System.out.println(Arrays.toString(lc0347.topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (k > nums.length) {
            return null;
        }
        //先执行排序
        Arrays.sort(nums);
        //数组元素计数
        TreeSet<MyEntry> treeSet = new TreeSet<>();
        int val = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (val == nums[i]) {
                count = count + 1;
                continue;
            }
            treeSet.add(new MyEntry(count, val));
            val = nums[i];
            count = 1;
        }
        treeSet.add(new MyEntry(count, val));
        int index = 0;
        int[] result = new int[k];
        for (MyEntry entry: treeSet) {
            result[index++] = entry.val;
            if (index >= k) {
                break;
            }
        }
        return result;
    }

    static class MyEntry implements Comparable<MyEntry> {
        int count;
        int val;

        public MyEntry(int count, int val) {
            this.count = count;
            this.val = val;
        }

        @Override
        public int compareTo(MyEntry obj) {
            int compare = Integer.compare(count, obj.count);
            if (compare != 0) {
                return Math.negateExact(compare);
            }
            return Integer.compare(val, obj.val);
        }
    }

}
