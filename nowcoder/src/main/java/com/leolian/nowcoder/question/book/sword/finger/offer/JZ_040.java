package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * JZ 40 : 数组中只出现一次的两个数字
 * <p>
 * 题目描述
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>
 * 示例1
 * 输入：[1,4,1,6]
 * 返回值：[4,6]
 * 说明：
 * 返回的结果中较小的数排在前面
 */
public class JZ_040 {

    public static void main(String[] args) {
        JZ_040 jz040 = new JZ_040();

        int[] array = new int[]{1, 4, 1, 6};
        System.out.println(Arrays.toString(jz040.FindNumsAppearOnce(array)));
    }

    public int[] FindNumsAppearOnce(int[] array) {
        if (null == array || array.length == 0) {
            return new int[0];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int start = 0, end = array.length - 1;
        int startVal, endVal;
        while (start < end) {
            startVal = array[start];
            if (map.containsKey(startVal)) {
                map.remove(startVal);
            } else {
                map.put(startVal, 1);
            }
            endVal = array[end];
            if (map.containsKey(endVal)) {
                map.remove(endVal);
            } else {
                map.put(endVal, 1);
            }
            start++;
            end--;
        }
        if (start == end) {
            startVal = array[start];
            if (map.containsKey(startVal)) {
                map.remove(startVal);
            } else {
                map.put(startVal, 1);
            }
        }
        int[] res = new int[map.size()];
        int index = 0;
        for (int val : map.keySet()) {
            res[index++] = val;
        }
        return res;
    }
}
