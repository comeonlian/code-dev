package com.leolian.leetcode.questionbank.algorithm.page02;

import java.util.Arrays;

/**
 * LC 66 : 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * 示例1
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例2
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例3
 * 输入：digits = [0]
 * 输出：[1]
 */
public class LC_0066 {

    public static void main(String[] args) {
        LC_0066 lc0066 = new LC_0066();

        int[] nums = new int[]{4, 3, 2, 1};
        System.out.println(Arrays.toString(lc0066.plusOne(nums)));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len + 1];
        int index = len - 1;
        int last = digits[index];
        if (last == 9) {
            while (last == 9) {
                digits[index] = 0;
                result[len] = digits[index];
                if (index == 0) {
                    result[0] = 1;
                    break;
                }
                index = index - 1;
                last = digits[index];
                len = len - 1;
            }
            if (index != 0 || last != 9) {
                digits[index] = digits[index] + 1;
                for (; index >= 0; index--, len--) {
                    result[len] = digits[index];
                }
            }
            if (result[0] == 0) {
                int[] res = new int[result.length - 1];
                System.arraycopy(result, 1, res, 0, result.length - 1);
                return res;
            } else {
                return result;
            }
        } else {
            digits[index] = digits[index] + 1;
            return digits;
        }
    }
}
