package com.leolian.nowcoder.question.bank.page06;

/**
 * NC 251 : 多数组第 K 小数
 * 题目描述
 * 给定两个升序的数列 arr1 和 arr2 ，和一个整数 target ，请你找出两个数列中第 K 小的值。
 * 备注：
 * 数据范围：两个数列的长度都满足 1 <= n <= 10^6，数列中的值都满足 1 <= n <= 10^9 ，给定整数大小满足 1 <= target <= len(arr1)+len(arr2)
 * <p>
 * 示例1
 * 输入：[1,2,3,4],[1,3,4],2
 * 返回值：1
 * 说明：两个数列中数升序排列是 1 1 2 3 3 4，故第二小的是 1
 * <p>
 * 示例2
 * 输入：[1,2,3,4],[1,3,4],7
 * 返回值：4
 */
public class NC_0251 {

    public static void main(String[] args) {
        NC_0251 nc0251 = new NC_0251();

        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 3, 4};
        int target = 7;

        System.out.println(nc0251.findKthNum(arr1, arr2, target));
    }

    public int findKthNum(int[] arr1, int[] arr2, int target) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (target > (len1 + len2)) {
            return 0;
        }
        int[] arrMerge = new int[len1 + len2];
        int i = 0, j = 0, index = 0;
        while (i < len1 && j < len2) {
            int val1 = arr1[i];
            int val2 = arr2[j];
            if (val1 <= val2) {
                arrMerge[index++] = val1;
                i++;
            } else {
                arrMerge[index++] = val2;
                j++;
            } 
        }
        while (i < len1) {
            arrMerge[index++] = arr1[i];
            i++;
        }
        while (j < len2) {
            arrMerge[index++] = arr2[j];
            j++;
        }
        index = 0;
        int val = 0;
        while (target-- > 0) {
            val = arrMerge[index++];
        }
        return val;
    }

    /*
    运行时间：754ms
    超过80.00% 用Java提交的代码
    
    占用内存：243864KB
    超过79.66%用Java提交的代码
     */

}