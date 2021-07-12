package com.leolian.nowcoder.question.bank;

/**
 * NC 32 : 求平方根
 * <p>
 * 题目描述
 * 实现函数 int sqrt(int x)，计算并返回x的平方根（向下取整）
 * <p>
 * 示例1
 * 输入：2
 * 返回值：1
 */
public class NC_0032 {

    public static void main(String[] args) {
        NC_0032 nc0032 = new NC_0032();

        int x = 7;
        System.out.println(nc0032.sqrt(x));
    }

    /**
     * @param x int整型
     * @return int整型
     */
    public int sqrt(int x) {
        int res = (int) Math.sqrt(x);
        return res;
    }

}
