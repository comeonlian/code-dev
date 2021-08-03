package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 11 : 二进制中1的个数
 * <p>
 * 题目描述
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * 示例1
 * 输入：10
 * 返回值：2
 */
public class JZ_011 {

    public static void main(String[] args) {
        JZ_011 jz011 = new JZ_011();

        int n = -5;
        System.out.println(jz011.NumberOf1(n));
    }

    public int NumberOf1(int n) {
        if (n == 0) {
            return 0;
        }
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

}
