package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 504 : 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * 提示：
 * -10^7 <= num <= 10^7
 * <p>
 * 示例1
 * 输入: num = 100
 * 输出: "202"
 * <p>
 * 示例2
 * 输入: num = -7
 * 输出: "-10"
 */
public class LC_0504 {

    public static void main(String[] args) {
        LC_0504 lc0504 = new LC_0504();

        int num = -7;
        System.out.println(lc0504.convertToBase7(num));
    }

    // 循环取模法
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
    /*
    public String convertToBase7(int num) {
        if (num > -7 && num < 7) {
            return String.valueOf(num);
        }
        String res = "";
        int abs = Math.abs(num);
        while (abs > 0) {
            res = (abs % 7) + res;
            abs /= 7;
        }
        return num > 0 ? res : "-" + res;
    }
    */
}
