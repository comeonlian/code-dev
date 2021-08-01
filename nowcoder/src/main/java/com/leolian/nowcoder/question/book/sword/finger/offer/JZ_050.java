package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.HashSet;

/**
 * JZ 50 : 数组中重复的数字
 * <p>
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 * <p>
 * 示例1
 * 输入：[2,3,1,0,2,5,3]
 * 返回值：2
 * 说明：
 * 2或3都是对的
 */
public class JZ_050 {

    public static void main(String[] args) {
        JZ_050 jz050 = new JZ_050();

        int[] numbers = new int[]{2, 3, 1, 0, 6, 5, 4};
        System.out.println(jz050.duplicate(numbers));
    }

    /**
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate(int[] numbers) {
        if (null == numbers || numbers.length < 1) {
            return -1;
        }
        HashSet<Integer> hashSet = new HashSet<>(numbers.length);
        for (int number : numbers) {
            if (number >= numbers.length) {
                return -1;
            }
            if (hashSet.contains(number)) {
                return number;
            } else {
                hashSet.add(number);
            }
        }
        return -1;
    }

}
