package com.leolian.nowcoder.question.bank;

/**
 * NC 106 : 三个数的最大乘积
 * <p>
 * 题目描述
 * 给定一个长度为 n 的无序数组 A，包含正数、负数和 0 ，请从中找出 3 个数，使得乘积最大，返回这个乘积。
 * 要求时间复杂度：O(n)，空间复杂度：O(1)。
 * 数据范围：
 * 3≤n≤2∗10^5
 * 10^6≤A[i]≤10^6
 * <p>
 * 示例1
 * 输入：[3,4,1,2]
 * 返回值：24
 */
public class NC_0106 {

    public static void main(String[] args) {
        NC_0106 nc0106 = new NC_0106();

        int[] A = new int[]{3, 4, 1, 2};
        System.out.println(nc0106.solve(A));
    }

    public long solve(int[] A) {
        if (null == A || A.length == 0) {
            return 0L;
        }
        if (A.length <= 3) {
            long multi = 1;
            for (int val : A) {
                multi = multi * val;
            }
            return multi;
        }
        long maxOne = Long.MIN_VALUE, maxTwo = Long.MIN_VALUE, maxThree = Long.MIN_VALUE;
        long minOne = Long.MAX_VALUE, minTwo = Long.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < minOne) {
                minTwo = minOne;
                minOne = A[i];
            } else if (A[i] < minTwo) {
                minTwo = A[i];
            }
            if (A[i] > maxOne) {
                maxThree = maxTwo;
                maxTwo = maxOne;
                maxOne = A[i];
            } else if (A[i] > maxTwo) {
                maxThree = maxTwo;
                maxTwo = A[i];
            } else if (A[i] > maxThree) {
                maxThree = A[i];
            }
        }
        return Math.max(maxOne * minOne * minTwo, maxOne * maxTwo * maxThree);
    }

}
