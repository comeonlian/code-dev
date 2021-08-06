package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * JZ 42 : 和为S的两个数字
 * <p>
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，返回两个数的乘积最小的，如果无法找出这样的数字，返回一个空数组即可。
 * 返回值描述：
 * 对应每个测试案例，输出两个数，小的先输出。
 * <p>
 * 示例1
 * 输入：[1,2,4,7,11,15],15
 * 返回值：[4,11]
 */
public class JZ_042 {

    public static void main(String[] args) {
        JZ_042 jz042 = new JZ_042();

        int[] array = new int[]{1,4,9};
        int sum = 8;
        System.out.println(jz042.FindNumbersWithSum(array, sum));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (null == array || array.length == 0 || sum == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        int multi = Integer.MAX_VALUE;
        int minVal = 0, maxVal = 0;
        int val, substr = 0;
        boolean has = false;
        for (int i = 0; i < array.length; i++) {
            val = array[i];
            substr = sum - val;
            if (map.containsKey(substr) && (i != map.get(substr))) {
                if (multi > (val * substr)) {
                    multi = val * substr;
                    minVal = Math.min(val, substr);
                    maxVal = Math.max(val, substr);
                    has = true;
                }
            }
        }
        if (has) {
            ArrayList<Integer> list = new ArrayList<>(2);
            list.add(minVal);
            list.add(maxVal);
            return list;
        }
        return new ArrayList<>();
    }

}
