package com.leolian.nowcoder.question.bank.page02;

import java.util.*;

/**
 * NC 61 : 两数之和
 * <p>
 * 题目描述
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 * <p>
 * 示例1:
 * 输入
 * [3,2,4], 6
 * 返回值
 * [2,3]
 */
public class NC_0061 {

    public static void main(String[] args) {
        NC_0061 nc0061 = new NC_0061();

        int[] numbers = new int[]{3, 2, 4};
        int target = 6;

        int[] indexs = nc0061.twoSum(numbers, target);
        System.out.println(Arrays.toString(indexs));
    }


    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            if (map.containsKey(value)) {
                map.get(value).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(value, list);
            }
        }
        int[] result = new int[2];
        outer:
        for (int i = 0; i < numbers.length; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;
            if (map.containsKey(num2)) {
                List<Integer> list = map.get(num2);
                for (Integer idx : list) {
                    if (idx != i) {
                        if (idx > i) {
                            result[0] = i + 1;
                            result[1] = idx + 1;
                            break outer;
                        }
                    }
                }
            }
        }
        return result;
    }

}
