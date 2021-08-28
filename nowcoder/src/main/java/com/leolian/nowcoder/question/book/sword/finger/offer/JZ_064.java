package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;

/**
 * JZ 64 : 滑动窗口的最大值
 * <p>
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 * <p>
 * 示例1
 * 输入：[2,3,4,2,6,2,5,1],3
 * 返回值：[4,4,6,6,6,5]
 */
public class JZ_064 {

    public static void main(String[] args) {
        JZ_064 jz064 = new JZ_064();

        int[] num = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int size = 9;
        System.out.println(jz064.maxInWindows(num, size));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (null == num || num.length == 0 || size==0 || size > num.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1, start = 0;
        int max = Integer.MIN_VALUE;
        for (start = 0; start < num.length; ) {
            if (count > size) {
                list.add(max);
                max = num[start];
                count = 1;
                start = start - size + 1;
            } else {
                if (num[start] > max) {
                    max = num[start];
                }
                count++;
                start++;
            }
        }
        if (count >= size) {
            list.add(max);
        }
        return list;
    }

}
