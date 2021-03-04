package com.leolian.leetcode.explore.primaryalgorithm.array;

import java.util.Arrays;

/**
 * LC 加一:
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *  
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Array007 {

    public static void main(String[] args) {
        Array007 demo = new Array007();

        int[] digits = new int[]{4, 9, 9, 9};
        int[] result = demo.plusOne(digits);

        System.out.println("Result array: " + Arrays.toString(result));
    }


    /**
     * @param digits
     * @return
     */
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
    /*
    执行结果：通过
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：36.8 MB, 在所有 Java 提交中击败了83.82%的用户
    */

}
