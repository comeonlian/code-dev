package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 48 : 不用加减乘除做加法
 * <p>
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * <p>
 * 示例1
 * 输入：1,2
 * 返回值：3
 */
public class JZ_048 {

    public static void main(String[] args) {
        JZ_048 jz048 = new JZ_048();

        int num1 = 112;
        int num2 = 111;
        System.out.println(jz048.Add(num1, num2));
    }

    public int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }

}
