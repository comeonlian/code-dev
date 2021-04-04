package com.leolian.nowcoder.question.bank;

import java.util.Arrays;

/**
 * NC 22 : 合并两个有序的数组
 * 题目描述
 * 给出两个有序的整数数组 A 和 B ，请将数组 B 合并到数组 A 中，变成一个有序的数组
 * 注意：
 * 可以假设 A 数组有足够的空间存放 B 数组的元素，A 和 B 中初始的元素数目分别为 m 和 n
 */
public class NC_0022 {

    public static void main(String[] args) {
        NC_0022 nc0022 = new NC_0022();
        int m = 2;
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 7;
        int n = 3;
        int[] B = new int[10];
        B[0] = 2;
        B[1] = 4;
        B[2] = 8;
        System.out.println("A Before: " + Arrays.toString(A));
        nc0022.merge(A, m, B, n);
        System.out.println("A After: " + Arrays.toString(A));
    }

    /**
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        // 因为题目明确说了A数组足够大，所以直接在A数组操作
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1; //AB合并后最后一个元素所在位置
        while (i >= 0 && j >= 0) { //AB合并，谁大就先放谁
            A[index] = A[i] > B[j] ? A[i--] : B[j--];
            index--;
        }
        while (j >= 0) { //如果B没有遍历完，那么之间丢在A数组里面
            A[index--] = B[j--];
        }
    }

}
