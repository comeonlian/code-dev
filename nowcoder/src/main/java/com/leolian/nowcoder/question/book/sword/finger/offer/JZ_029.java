package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * JZ 29 : 最小的K个数
 * <p>
 * 题目描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 0 <= k <= input.length <= 10000
 * 0 <= input[i] <= 10000
 * <p>
 * 示例1
 * 输入：[4,5,1,6,2,7,3,8],4
 * 返回值：[1,2,3,4]
 * 说明：
 * 返回最小的4个数即可，返回[1,3,2,4]也可以
 * 示例2
 * 输入：[1],0
 * 返回值：[]
 * 示例3
 * 输入：[0,1,2,1,2],3
 * 返回值：[0,1,1]
 */
public class JZ_029 {

    public static void main(String[] args) {
        JZ_029 jz029 = new JZ_029();

        // 4, 5, 1, 6, 2, 7, 3, 8
        // 1
        // 0,1,2,1,2
        int[] input = new int[]{0, 1, 2, 1, 2};
        int k = 3;

        System.out.println(jz029.GetLeastNumbers_Solution(input, k));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (null == input || input.length == 0 || k == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

}
