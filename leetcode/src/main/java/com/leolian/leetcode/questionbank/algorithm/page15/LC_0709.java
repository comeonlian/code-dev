package com.leolian.leetcode.questionbank.algorithm.page15;

/**
 * LC 709 : 转换成小写字母
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * 提示：
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 * <p>
 * 示例1
 * 输入：s = "Hello"
 * 输出："hello"
 * <p>
 * 示例2
 * 输入：s = "here"
 * 输出："here"
 * <p>
 * 示例3
 * 输入：s = "LOVELY"
 * 输出："lovely"
 */
public class LC_0709 {

    public static void main(String[] args) {
        LC_0709 lc0709 = new LC_0709();

        String s = "Hello";
        System.out.println(lc0709.toLowerCase(s));
    }
    
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
