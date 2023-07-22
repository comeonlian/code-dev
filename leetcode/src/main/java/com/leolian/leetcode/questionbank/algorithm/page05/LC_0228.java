package com.leolian.leetcode.questionbank.algorithm.page05;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 228 : 汇总区间
 * 给定一个无重复元素的有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 提示：
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * <p>
 * 示例1
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例2
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class LC_0228 {

    public static void main(String[] args) {
        LC_0228 lc0228 = new LC_0228();

        int[] nums = new int[]{-2147483648,-2147483647,2147483647};
        System.out.println(lc0228.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            int sub = temp - end;
            if (sub > 1 || sub < -1) {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = temp;
            }
            end = temp;
        }
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
        return result;
    }

    /*
     执行用时：6 ms, 在所有 Java 提交中击败了41.90%的用户
    内存消耗：39.8 MB, 在所有 Java 提交中击败了44.60%的用户
    通过测试用例：31 / 31
     */
}
