package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 43 : 左旋转字符串
 * <p>
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出（保证 K 小于等于 S 的长度）。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移 3 位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * <p>
 * 示例1
 * 输入："abcXYZdef",3
 * 返回值："XYZdefabc"
 */
public class JZ_043 {

    public static void main(String[] args) {
        JZ_043 jz043 = new JZ_043();

        String str = "abcXYZdef";
        int n = 3;

        System.out.println(jz043.LeftRotateString(str, n));
    }

    public String LeftRotateString(String str, int n) {
        if (null == str || str.length() == 0) {
            return "";
        }
        int len = str.length();
        if (n == 0 || (n % len) == 0) {
            return str;
        }
        return str.substring(n) + str.substring(0, n);
    }

}
