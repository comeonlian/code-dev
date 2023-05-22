package com.leolian.leetcode.questionbank.algorithm.page01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * LC 46 : 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 提示:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * 示例1
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例2
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例3
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class LC_0046 {

    public static void main(String[] args) {
        LC_0046 lc0046 = new LC_0046();

        int[] nums = new int[]{0, 1};
        System.out.println(lc0046.permute(nums));
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        recursion(set, list);
        return result;
    }

    public void recursion(HashSet<Integer> set, ArrayList<Integer> list) {
        Iterator<Integer> it = set.iterator();
        if (set.size() == 1) {
            list.add(it.next());
            ArrayList<Integer> tmp = new ArrayList<>(list);
            result.add(tmp);
            list.remove(list.size() - 1);
            return;
        }
        while (it.hasNext()) {
            Integer val = it.next();
            list.add(val);

            HashSet<Integer> tmp = new HashSet<>(set);
            tmp.remove(val);
            recursion(tmp, list);
            list.remove(list.size() - 1);
        }
    }
    /*
    执行用时：2 ms, 在所有 Java 提交中击败了8.66%的用户
    内存消耗：42.6 MB, 在所有 Java 提交中击败了10.92%的用户
    */
}
