package com.leolian.leetcode.questionbank.algorithm.page18;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LC 888 : 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。
 * （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。答案肯定存在。
 * <p>
 * 示例1
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * <p>
 * 示例2
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * <p>
 * 示例3
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * <p>
 * 示例4
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 */
public class LC_0888 {

    public static void main(String[] args) {
        LC_0888 lc0888 = new LC_0888();

        int[] aliceSizes = new int[]{2};
        int[] bobSizes = new int[]{1, 3};
        System.out.println(Arrays.toString(lc0888.fairCandySwap(aliceSizes, bobSizes)));
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (int val : aliceSizes) {
            mapA.put(val, 0);
            sumA += val;
        }
        int sumB = Arrays.stream(bobSizes).sum();
        for (int val : bobSizes) {
            int x = val + (sumA - sumB) / 2;
            if (mapA.containsKey(x)) {
                return new int[]{x, val};
            }
        }
        return new int[]{};
    }
}
