package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.Arrays;

/**
 * JZ 13 : 调整数组顺序使奇数位于偶数前面
 * <p>
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 示例1
 * 输入：[1,2,3,4]
 * 返回值：[1,3,2,4]
 * <p>
 * 示例2
 * 输入：[2,4,6,5,7]
 * 返回值：[5,7,2,4,6]
 */
public class JZ_013 {

    public static void main(String[] args) {
        JZ_013 jz013 = new JZ_013();

        int[] array = new int[]{4};
        System.out.println(Arrays.toString(jz013.reOrderArray(array)));
    }

    public int[] reOrderArray(int[] array) {
        if (null == array || array.length == 0) {
            return new int[0];
        }
        if (array.length == 1) {
            return array;
        }
        int[] res = new int[array.length];
        int index = 0;
        for (int val : array) {
            if ((val % 2) != 0) {
                res[index++] = val;
            }
        }
        for (int val : array) {
            if ((val % 2) == 0) {
                res[index++] = val;
            }
        }
        return res;
    }

}
