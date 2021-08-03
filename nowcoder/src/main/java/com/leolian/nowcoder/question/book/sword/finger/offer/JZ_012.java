package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 12 : 数值的整数次方
 * <p>
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
 * <p>
 * 示例1
 * 输入：2.00000,3
 * 返回值：8.00000
 * <p>
 * 示例2
 * 输入：2.10000,3
 * 返回值：9.26100
 * <p>
 * 示例3
 * 输入：2.00000,-2
 * 返回值：0.25000
 * 说明：
 * 2的-2次方等于1/4=0.25
 */
public class JZ_012 {

    public static void main(String[] args) {
        JZ_012 jz012 = new JZ_012();

        double base = -2;
        int exponent = -3;
        System.out.println(jz012.Power(base, exponent));
    }

    public double Power(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            return 0;
        }
        if (base == 0) {
            return 0;
        }
        if (exponent == 1) {
            return base;
        }
        int abs = Math.abs(exponent);
        double res = 1;
        while (abs-- > 0) {
            res = res * base;
        }
        if (exponent < 0) {
            res = 1 / res;
        }
        return res;
    }

}
