package com.leolian.nowcoder.question.bank.page03;

/**
 * NC 110 : 旋转数组
 * <p>
 * 题目描述
 * 一个数组A中存有N（N>0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（M>=0）个位置，
 * 即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）（最后M个数循环移至最前面的M个位置）。
 * 如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 * 备注：
 * (1<=N<=100,M>=0)
 * <p>
 * 示例1
 * 输入：6,2,[1,2,3,4,5,6]
 * 返回值：[5,6,1,2,3,4]
 */
public class NC_0110 {

    public static void main(String[] args) {
        NC_0110 nc0110 = new NC_0110();

        int n = 6;
        int m = 6;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] resArr = nc0110.solve(n, m, arr);
        for (int val : resArr) {
            System.out.print(val + " ");
        }
    }


    /**
     * 旋转数组
     *
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve(int n, int m, int[] a) {
        if (null == a || a.length == 0) {
            return null;
        }
        if (n <= 0 || m <= 0) {
            return a;
        }
        if ((m % n) == 0) {
            return a;
        }
        int count = 0;
        while (count < m) {
            int val = a[n - 1];
            int i = n - 1;
            for (; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[i] = val;
            count = count + 1;
        }
        return a;
    }

}
